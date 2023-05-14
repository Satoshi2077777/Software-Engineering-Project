package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil {
	static final String DRIVERCLASS;
	static final String URL;
	static final String USERNAME;
	static final String PASSWORD;
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		DRIVERCLASS = bundle.getString("driverClass");
		URL = bundle.getString("url");
		USERNAME = bundle.getString("username");
		PASSWORD = bundle.getString("password");
	}

	public static void main(String args[]) throws SQLException {
		JDBCUtil.getConnection();

	}

	static {
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	/**
	 * 关闭数据库资源
	 * 
	 * @param conn
	 * @param statement
	 * @param resultSet
	 */
	public static void closeResource(Connection conn, Statement statement, ResultSet resultSet) {
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(conn);

	}

	public static void closeResultSet(ResultSet set) {
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
