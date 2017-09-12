package com.only.bean;

public class ColumnsBean
{
	 private String columnName;
	 private String dataType;
	 private String isNull;
	 private String columnType;
	 private String columnComment;
	 //键类型【PRI表示为主键】
	 private String columnKey;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType()
	{
		return dataType;
	}

	public void setDataType(String dataType)
	{
		this.dataType = dataType;
	}

	public String getIsNull()
	{
		return isNull;
	}

	public void setIsNull(String isNull)
	{
		this.isNull = isNull;
	}

	public String getColumnType()
	{
		return columnType;
	}

	public void setColumnType(String columnType)
	{
		this.columnType = columnType;
	}

	public String getColumnComment()
	{
		return columnComment;
	}

	public void setColumnComment(String columnComment)
	{
		this.columnComment = columnComment;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
}
