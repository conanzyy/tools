package com.only.util;

public class StringUtil
{
	/**
	 * 将单词的首字母大写
	 * @param old
	 * @return
	 */
	public static String toUpperCase(String old){ 
		String str = old.substring(0,1).toUpperCase() + old.substring(1) ;
		return str ;
	}
	
	/**
	 * 将单词的首字母小写
	 * @param old
	 * @return
	 */
	public static String toLowerCase(String old){ 
		String str = old.substring(0,1).toLowerCase() + old.substring(1) ;
		return str;
	}

	/**
	 * 将数据库中的表名转换为java bean名称
	 * @param table
	 * @return
	 */
	public static String getModelNameByTable(String table)
	{
		String[] tableArr=table.split("_");
		StringBuffer sb= new StringBuffer();
		for (String t:tableArr)
		{
			sb.append(toUpperCase(t));
		}
		return sb.toString();
	}

}
