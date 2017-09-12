package com.only.util;

import com.only.bean.ColumnsBean;
import com.only.bean.DatabaseBean;
import com.only.bean.TableBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 
public class DbUtil
{
	public static List<TableBean> getTables(DatabaseBean databaseBean) throws SQLException
	{
		List<TableBean> list = new ArrayList<>();
		String sql = String.format("select TABLE_NAME 'tableName',TABLE_COMMENT 'tableComment' from information_schema.tables where table_schema='%s'", databaseBean.getDbName());
		Connection conn = JDBCUtil.getInstance(databaseBean).getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next())
		{
			TableBean tableBean= new TableBean();
			tableBean.setTableName(rs.getString("tableName"));
			tableBean.setTableComment(rs.getString("tableComment"));
			list.add(tableBean);
		}
		JDBCUtil.getInstance(databaseBean).close(conn, stmt, rs);

		return list;
	}

	public static List<ColumnsBean> getColumns(DatabaseBean databaseBean, String tableName) throws SQLException
	{
		List<ColumnsBean> list = new ArrayList<>();
		String sql = String.format("select COLUMN_NAME 'columnName',DATA_TYPE 'dataType',IS_NULLABLE 'isNull', COLUMN_TYPE 'columnType',COLUMN_COMMENT 'columnComment',COLUMN_KEY 'columnKey' from information_schema.columns where table_name='%s' and table_schema='%s'", tableName, databaseBean.getDbName());
		Connection conn = JDBCUtil.getInstance(databaseBean).getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next())
		{
			ColumnsBean columnsBean= new ColumnsBean();
			columnsBean.setColumnName(rs.getString("columnName"));
			columnsBean.setColumnComment(rs.getString("columnComment"));
			columnsBean.setColumnType(rs.getString("columnType"));
			columnsBean.setDataType(rs.getString("dataType"));
			columnsBean.setIsNull(rs.getString("isNull"));
			columnsBean.setColumnKey(rs.getString("columnKey"));
			list.add(columnsBean);
			
		}
		JDBCUtil.getInstance(databaseBean).close(conn, stmt, rs);

		return list;
	}
	
}
