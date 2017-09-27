package com.only.util;

 
public class CoreUtil {
    public static String getBeanName(String tableName)
    {
 
        if (tableName.startsWith("fwp_"))
        {
            tableName=tableName.replace("fwp_","");
        }
        else  if (tableName.startsWith("suc_"))
        {
            tableName=tableName.replace("suc_","");
        }
        tableName= tableName.toLowerCase();
        String[] tables= tableName.split("_");
        if (tables.length>0)
        {
            String result="";
            for (String temp:tables)
            {
                result+=StringUtil.toUpperCase(temp);
            }
            return result+"Entity";
        }
        return StringUtil.toUpperCase(tableName)+"Entity";

    }
    
    public static String getJavaTableName(String tableName)
    {
        if (tableName.startsWith("fwp_"))
        {
            tableName=tableName.replace("fwp_","");
        }
        else  if (tableName.startsWith("suc_"))
        {
            tableName=tableName.replace("suc_","");
        }
        tableName= tableName.toLowerCase();
        String[] tables= tableName.split("_");
        if (tables.length>0)
        {
            String result="";
            for (String temp:tables)
            {
                result+=StringUtil.toUpperCase(temp);
            }
            return result;
        }
        return StringUtil.toUpperCase(tableName);
    }
    
    
    public static String getPropertyName(String columnsName)
    {
        columnsName=columnsName.toLowerCase();
        if (columnsName.contains("_"))
        {
            String result="";
            String[] columnsNames=columnsName.split("_");
            for (String temp:columnsNames)
            {
                result+=StringUtil.toUpperCase(temp);
            }
            return StringUtil.toLowerCase(result);
            
        }
        else
        {
            return columnsName;
        }
    }
}
