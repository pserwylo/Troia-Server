package com.datascience.scheduler;

import com.datascience.core.base.LObject;
import com.datascience.core.base.Project;
import com.datascience.core.base.Worker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class CachedScheduler<T> extends Scheduler<T> {

	private static Logger logger = Logger.getLogger(CachedScheduler.class);

	private Cache<String, LObject<T>> polled;
	private long pauseDuration;
	private TimeUnit pauseUnit;

	public CachedScheduler() { }

	public CachedScheduler(Project<T, ?, ?, ?> project, IPriorityCalculator<T> calculator, long pauseDuration, TimeUnit pauseUnit) {
		super(project, calculator);
		setUpCache(pauseDuration, pauseUnit);
	}

	@Override
	public void update() {
		polled.invalidateAll();
		super.update();
	}

	@Override
	public void update(LObject<T> object) {
		if (polled.getIfPresent(object.getName()) != null) {
			polled.invalidate(object.getName());
		} else {
			super.update(object);
		}
	}

	@Override
	public LObject<T> nextObject() {
		polled.cleanUp();
		LObject<T> object = queue.getAndRemoveFirst();
		if (object != null) {
			polled.put(object.getName(), object);
		}
		return object;
	}

	@Override
	public LObject<T> nextObject(Worker worker) {
		polled.cleanUp();
		LObject<T> object = super.nextObject(worker);
		if (object != null) {
			polled.put(object.getName(), object);
			queue.remove(object);
		}
		return object;
	}

	public void setUpCache(long pauseDuration, TimeUnit pauseUnit) {
		polled = CacheBuilder.newBuilder()
				.expireAfterWrite(pauseDuration, pauseUnit)
				.removalListener(getRemovalListener())
				.build();
		this.pauseDuration = pauseDuration;
		this.pauseUnit = pauseUnit;
	}

	public long getPauseDuration() {
		return pauseDuration;
	}

	public TimeUnit getPauseUnit() {
		return pauseUnit;
	}

	private RemovalListener<String, LObject<T>> getRemovalListener() {
		return new RemovalListener<String, LObject<T>>() {
			@Override
			public void onRemoval(RemovalNotification<String, LObject<T>> notification) {
				try {
					CachedScheduler.super.update(notification.getValue());
				} catch (Exception e) {
					logger.error("CachedScheduler on eviction", e);
				}
			}
		};
	}

	@Override
	public String getId(){
		return "cachedscheduler";
	}
}
