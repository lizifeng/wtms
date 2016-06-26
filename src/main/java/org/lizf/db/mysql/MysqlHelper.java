package org.lizf.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lizf.db.DBHelper;

public class MysqlHelper extends DBHelper {

	@Override
	public Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName(getDbConfig().getDriverName());
			conn = DriverManager.getConnection(getDbConfig().getUrl(), getDbConfig().getUsername(),
					getDbConfig().getPassword());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public boolean testConnection() {
		boolean flag = false;
		String sql = "select 1 ";
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public void executeSQL(String sql) {

	}

	@Override
	public void executeAdd(String addSql, Object[] params) {
		Connection conn = getConnection();
	}

	@Override
	public int executeDelete(String delelteSql, Object[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String updateSql, Object[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <E> E executeQuery(String querySql, Object[] params, Class<E> clz) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

}
