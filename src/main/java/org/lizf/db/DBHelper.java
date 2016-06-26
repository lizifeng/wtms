package org.lizf.db;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DBHelper {

	DBConfig dbConfig;
	ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();;

	public void setDbConfig(DBConfig dbConfig) {
		this.dbConfig = dbConfig;
	}

	public DBConfig getDbConfig() {
		return dbConfig;
	}

	public final Connection getConnection() {
		Connection connection = threadLocal.get();
		try {
			if (connection == null || connection.isClosed()) {
				connection = createConnection();
				threadLocal.set(connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public abstract Connection createConnection();

	public abstract boolean testConnection();

	public abstract void executeAdd(String addSql, Object[] params);
	
	public abstract int executeDelete(String delelteSql, Object[] params);

	public abstract int executeUpdate(String updateSql, Object[] params);

	public abstract <E> E executeQuery(String querySql, Object[] params, Class<E> clz) throws ClassCastException;

}
