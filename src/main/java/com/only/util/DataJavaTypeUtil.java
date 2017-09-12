package com.only.util;

public class DataJavaTypeUtil
{
	public static String getJavaType(String dbColumnType)
	{
		String resut = JavaDataType.stringDataType;
		if (dbColumnType.equalsIgnoreCase("int"))
		{
			resut = JavaDataType.intDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("mediumint"))
		{
			resut = JavaDataType.intDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("smallint"))
		{
			resut = JavaDataType.intDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("tinyint"))
		{
			resut = JavaDataType.shortanDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("bigint"))
		{
			resut = JavaDataType.longDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("double"))
		{
			resut = JavaDataType.doubleDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("float"))
		{
			resut = JavaDataType.floatDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("decimal"))
		{
			resut = JavaDataType.doubleDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("datetime"))
		{
			resut = JavaDataType.dateDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("date"))
		{
			resut = JavaDataType.dateDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("time"))
		{
			resut =JavaDataType.dateDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("timestamp"))
		{
			resut = JavaDataType.dateDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("year"))
		{
			resut =JavaDataType.dateDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("blob"))
		{
			resut = JavaDataType.byteArrayDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("binary"))
		{
			resut = JavaDataType.byteArrayDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("longblob"))
		{
			resut = JavaDataType.byteArrayDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("mediumblob"))
		{
			resut = JavaDataType.byteArrayDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("tinyblob"))
		{
			resut = JavaDataType.byteArrayDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("varbinary"))
		{
			resut = JavaDataType.byteArrayDataType;
		}
		else if (dbColumnType.equalsIgnoreCase("bit"))
		{
			resut = JavaDataType.booleanDataType;
		}
		return resut;

	}
}
