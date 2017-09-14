package com.only.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

 
public class FwpBeanUtils {
    
    public static Map<String,Object> beanToMap(Object object) throws IllegalAccessException {
        Class clazz= object.getClass();
        Field[] fields=clazz.getDeclaredFields();
        Map<String,Object> map= new HashMap<>();
        for (Field field:fields)
        {
            field.setAccessible(true);
            Object val=field.get(object);
            if (null!=val)
            {
                if (val instanceof Date)
                {
                    Date date=(Date)val;
                    val=DateUtils.formatDate(date);
                }
                map.put(field.getName(),val);
            }


        }
        return map;
    }

    /**
     * 实体类转map参数拼接
     * @param object
     * @return
     */
    public static String beanToMapString(Object object)
    {
        StringBuilder sb= new StringBuilder();
        Class clazz= object.getClass();
        //sb.append(clazz.getSimpleName()+" entity= new "+clazz.getSimpleName()+"();\r\n");
        sb.append(" Map<String,Object> paramMap= new HashMap<>();\r\n");
        Field[] fields=clazz.getDeclaredFields();
        for (Field field:fields)
        {
            if (!field.getName().equals("serialVersionUID"))
            {
                //paramMap.put("updateTime",DateUtils.formatDate(entity.getUpdateTime()));
                //paramMap.put("updateTime",entity.getUpdateTime().getValue());
                if (field.getType().equals(Date.class))
                {
                    sb.append("paramMap.put(\""+field.getName()+"\",DateUtils.formatDate(entity.get"+ StringUtil.toUpperCase(field.getName())+"()));\r\n");
                }
                else if (field.getType().isEnum())
                {
                    sb.append("paramMap.put(\""+field.getName()+"\",entity.get"+ StringUtil.toUpperCase(field.getName())+"().getValue());\r\n");
                }
                else
                {
                    sb.append("paramMap.put(\""+field.getName()+"\",entity.get"+ StringUtil.toUpperCase(field.getName())+"());\r\n");
                }
            }
      
        }
        return sb.toString();
    }

 



}
