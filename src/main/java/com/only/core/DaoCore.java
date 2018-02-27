package com.only.core;

import com.only.bean.ColumnsBean;
import com.only.bean.DatabaseBean;
import com.only.bean.TableBean;
import com.only.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoCore {
    public static void main(String[] args) throws Exception {
        // DatabaseBean databaseBean= new DatabaseBean("selffabu","x3WUaIsvD3","fwpsit1","10.37.153.65");
        DatabaseBean databaseBean= new DatabaseBean("selffabu","asssssit","asssssit","10.27.175.90");
        List<TableBean> tableBeanList= DbUtil.getTables(databaseBean);
        for ( TableBean tableBean:tableBeanList)
        {
            if (!tableBean.getTableName().equals("suc_return_book_deposit")){
                continue;
            }
            List<ColumnsBean> columnsBeanList= DbUtil.getColumns(databaseBean,tableBean.getTableName());
            Map<String,Object> root= new HashMap<>();
            root.put("tableName",tableBean.getTableName());
            root.put("daoName", CoreUtil.getJavaTableName(tableBean.getTableName()));
            root.put("daoLowName", StringUtil.toLowerCase(CoreUtil.getJavaTableName(tableBean.getTableName())));
            List<Map<String,Object>> columnMapList= new ArrayList<>();
            for (ColumnsBean columnsBean:columnsBeanList)
            {
                Map<String,Object> columnMap= new HashMap<>();
                String propertyType= DataJavaTypeUtil.getJavaType(columnsBean.getDataType());
                String fieldName=columnsBean.getColumnName();
                String propertyName=CoreUtil.getPropertyName(fieldName);
                columnMap.put("key",propertyName);
                if (propertyType.equals(JavaDataType.dateDataType))
                {
                    columnMap.put("value","DateUtils.formatDate(entity.get"+StringUtil.toUpperCase(propertyName)+"())");
          
                }
                else
                {
                    columnMap.put("value","entity.get"+StringUtil.toUpperCase(propertyName)+"()");
                }
                columnMapList.add(columnMap);
      
            }
            root.put("columnMapList",columnMapList);
            String conent=FreeMarkerUtil.print("dao.ftl",root);
            FileUtil.writeTxt("F:\\aa\\dao",(String) root.get("daoName")+"Business.java",conent);
        }
        
    }
}
