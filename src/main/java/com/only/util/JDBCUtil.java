package com.only.util;

import com.only.bean.DatabaseBean;
import java.sql.*;
 

public class JDBCUtil
{

	private static JDBCUtil instance;
	private static DatabaseBean database;

	public static JDBCUtil getInstance(DatabaseBean databaseBean)
	{
		if (instance == null)
		{
			database = databaseBean;
			instance = new JDBCUtil();
		}
		return instance;
	}

 
	private JDBCUtil()
	{
		try
		{

			Class.forName(database.getClassDriverName());
		}
		catch (ClassNotFoundException e)
		{

			e.printStackTrace();
		}
	}

	public Connection getConnection()
	{
		Connection connection = null;
		try
		{
			connection = DriverManager.getConnection(database.getConnectionUrl(), database.getUser(), database.getPwd());
		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}
		return connection;
	}

	public void close(Connection conn, Statement stmt, ResultSet rs)
	{

		try
		{
			if (rs != null)
			{
				rs.close();
			}
			if (stmt != null)
			{
				stmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}

		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}

	}
}
