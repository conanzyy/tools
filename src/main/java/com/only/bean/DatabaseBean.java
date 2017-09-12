package com.only.bean;

public class DatabaseBean
{

	private String user;
	private String pwd;
	private String dbName;
	private String ip;
	
	
	public DatabaseBean(String user, String pwd, String dbName, String ip)
	{
		super();
		this.user = user;
		this.pwd = pwd;
		this.dbName = dbName;
		if (ip != null && ip.length() > 0)
		{
			this.ip = ip;
		}
		else
		{
			this.ip = "localhost";
		}

	}

	public String getUser()
	{
		return user;
	}

	public String getPwd()
	{
		return pwd;
	}

 

	public String getDbName()
	{
		return dbName;
	}

	public String getIp()
	{
		return ip;
	}
	

 

	public String getConnectionUrl()
	{
		return String.format("jdbc:mysql://%s:3306/%s?useUnicode=true&amp;characterEncoding=utf8&amp;autoReconnect=true&amp;autoReconnectForPools=true&amp;connectTimeout=60000&amp;socketTimeout=60000", ip, dbName);
	}

	public String getClassDriverName()
	{
		
		String result = "com.mysql.jdbc.Driver";
		return result;
	}

}
