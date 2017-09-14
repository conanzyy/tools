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

}
