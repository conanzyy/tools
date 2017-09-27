package com.only.util;
import org.apache.commons.lang3.StringUtils;
 
public class StringUtil extends StringUtils {
    
    private StringUtil() {
    }
    /**
     * 将单词的首字母大写
     * @param old
     * @return
     */
    public static String toUpperCase(String old){
        return  old.substring(0,1).toUpperCase() + old.substring(1) ;
    }

    /**
     * 将单词的首字母小写
     * @param old
     * @return
     */
    public static String toLowerCase(String old){
        return old.substring(0,1).toLowerCase() + old.substring(1) ;
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
