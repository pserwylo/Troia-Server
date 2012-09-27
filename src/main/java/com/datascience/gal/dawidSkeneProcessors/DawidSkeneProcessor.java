/*******************************************************************************
 * Copyright (c) 2012 Panagiotis G. Ipeirotis & Josh M. Attenberg
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package com.datascience.gal.dawidSkeneProcessors;


/**
 * This class is root of all classes used for modyfing DS model. 
 */
public abstract class DawidSkeneProcessor implements Runnable {
    



    /**
     * Identifier of DawidSkene model that will be modified
     */
    private String dawidSkeneId;
    
    /**
     * @return Identifier of DawidSkene model that will be modified
     */
    public String getDawidSkeneId() {
	return dawidSkeneId;
    }
    
    /**
     * @param dawidSkeneId Identifier of DawidSkene model that will be modified
     */
    public void setDawidSkeneId(String dawidSkeneId) {
	this.dawidSkeneId = dawidSkeneId;
    }

    /**
     * Cache used by this processor
     */
    private DawidSkeneCache cache;
    
    /**
     * Cache used by this processor
     */
    public DawidSkeneCache getCache() {
	return cache;
    }
    
    /**
     * Cache used by this processor
     */
    public void setCache(DawidSkeneCache cache) {
	this.cache = cache;
    }

    /**
     * True if this processor already finished doing ts task
     */
    private boolean processed;
    
    /**
     * @return True if this processor already finished doing ts task
     */
    public boolean isProcessed() {
	return processed;
    }
    
    /**
     * @param processed True if this processor already finished doing ts task
     */
    protected void setProcessed(boolean processed) {
	this.processed = processed;
    }


}
