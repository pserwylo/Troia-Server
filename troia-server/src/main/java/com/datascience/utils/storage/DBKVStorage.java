package com.datascience.utils.storage;

import org.apache.log4j.Logger;

import java.sql.*;

/**
 * @Author: konrad
 */
public class DBKVStorage implements IKVStorage<String> {

	private static Logger logger = Logger.getLogger(DBKVStorage.class);

	private static final String GET = "SELECT value FROM %s WHERE id = ?;";
	private static final String INSERT = "REPLACE INTO %s (id, value) VALUES (?, ?);";
	private static final String DELETE = "DELETE FROM %s WHERE id = ?;";

	protected String table;
	protected DBStorage dbStorage;

	public DBKVStorage(String table, DBStorage dbStorage){
		this.table = table;
		this.dbStorage = dbStorage;
	}

	private String prepareString(String sql, String table){
		return String.format(sql, table);
	}

	@Override
	public void put(String key, String value) throws SQLException{
		String logmsg = "DBKV put " + key;
		logger.debug(logmsg);
		PreparedStatement sql = null;
		try {
			sql = dbStorage.initStatement(prepareString(INSERT, table));
			sql.setString(1, key);
			sql.setString(2, value);
			sql.executeUpdate();
			logger.debug(logmsg + " DONE");
		} catch (Exception ex) {
			logger.error(logmsg + " FAIL", ex);
		} finally {
			dbStorage.cleanup(sql, null);
		}
	}

	@Override
	public String get(String key) throws SQLException{
		String logmsg = "DBKV get " + key;
		logger.debug(logmsg);
		PreparedStatement sql = null;
		ResultSet result = null;
		String value = null;
		try {
			sql = dbStorage.initStatement(prepareString(GET, table));
			sql.setString(1, key);
			result = sql.executeQuery();
			if (!result.next()) {
				logger.debug(logmsg + " DONE no results");
				return value;
			}
			value = result.getString("value");
			logger.debug(logmsg + " DONE");
		} catch (Exception ex) {
			logger.error(logmsg + " FAIL", ex);
		} finally {
			dbStorage.cleanup(sql, result);
			return value;
		}
	}

	@Override
	public void remove(String key) throws SQLException{
		String logmsg = "DBKV remove " + key;
		logger.debug(logmsg);
		PreparedStatement sql = null;
		try {
			sql = dbStorage.initStatement(prepareString(DELETE, table));
			sql.setString(1, key);
			sql.executeUpdate();
			logger.debug(logmsg + " DONE");
		} catch (Exception ex) {
			logger.error(logmsg + " FAIL", ex);
		} finally {
			dbStorage.cleanup(sql, null);
		}
	}

	@Override
	public boolean contains(String key) throws SQLException{
		// TODO XXX FIXME rewrite this to run without deserialization (count results)
		logger.debug("DBKV contains");
		return get(key) != null;
	}

	@Override
	public void shutdown() throws SQLException{
		// TODO XXX FIXME THINK - I think we don't should close DB here
//		dbStorage.close();
	}
}
