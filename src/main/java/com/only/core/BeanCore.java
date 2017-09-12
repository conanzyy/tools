package com.only.core;

import com.only.bean.ColumnsBean;
import com.only.bean.DatabaseBean;
import com.only.bean.TableBean;
import com.only.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanCore {

    public static void main(String[] args)  throws Exception{
       // DatabaseBean databaseBean= new DatabaseBean("selffabu","x3WUaIsvD3","fwpsit1","10.37.153.65");
        DatabaseBean databaseBean= new DatabaseBean("selffabu","asssssit","asssssit","10.27.175.90");
        List<TableBean> tableBeanList= DbUtil.getTables(databaseBean);
        for ( TableBean tableBean:tableBeanList)
        {
            if (!tableBean.getTableName().equals("suc_handle_organization_conf")){
                continue;
            }
            List<ColumnsBean> columnsBeanList= DbUtil.getColumns(databaseBean,tableBean.getTableName());
            Map<String,Object> root= new HashMap<>();
            root.put("tableDesc",tableBean.getTableComment());
            root.put("tableName",tableBean.getTableName());
            root.put("beanName", CoreUtil.getBeanName(tableBean.getTableName()));
            List<Map<String,Object>> columnMapList= new ArrayList<>();
            for (ColumnsBean columnsBean:columnsBeanList)
            {
                Map<String,Object> columnMap= new HashMap<>();
                String fieldDesc=columnsBean.getColumnComment();
                String fieldName=columnsBean.getColumnName();
                String fieldType=columnsBean.getColumnType();
                String fieldNullState=columnsBean.getIsNull();
                String propertyType= DataJavaTypeUtil.getJavaType(columnsBean.getDataType());
                String propertyName=CoreUtil.getPropertyName(fieldName);
                String propertyNameFirstUpperCase= StringUtil.toUpperCase(propertyName);
                String propertyNameFullUpperCase=propertyName.toUpperCase();
                columnMap.put("fieldDesc",fieldDesc);
                columnMap.put("fieldName",fieldName);
                columnMap.put("fieldType",fieldType);
                columnMap.put("fieldNullState",fieldNullState);
                columnMap.put("propertyType",propertyType);
                columnMap.put("propertyName",propertyName);
                columnMap.put("propertyNameFirstUpperCase",propertyNameFirstUpperCase);
                columnMap.put("propertyNameFullUpperCase",propertyNameFullUpperCase);
                columnMapList.add(columnMap);

            }
            root.put("columnMapList",columnMapList);
            String conent=FreeMarkerUtil.print("bean.ftl",root);
           // System.out.println(FreeMarkerUtil.print("bean.ftl",root));
            FileUtil.writeTxt("F:\\aa",(String) root.get("beanName")+".java",conent);
        }
    
        
        
        
 



 
  
 
        
    }
    
    
   
}

