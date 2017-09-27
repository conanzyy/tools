package com.only.core;

import com.only.bean.ColumnsBean;
import com.only.bean.DatabaseBean;
import com.only.bean.TableBean;
import com.only.util.CoreUtil;
import com.only.util.DbUtil;
import com.only.util.FileUtil;
import com.only.util.FreeMarkerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlMapCore {
    public static void main(String[] args)  throws  Exception{
        //DatabaseBean databaseBean= new DatabaseBean("selffabu","x3WUaIsvD3","fwpsit1","10.37.153.65");
        DatabaseBean databaseBean= new DatabaseBean("selffabu","asssssit","asssssit","10.27.175.90");
        List<TableBean> tableBeanList= DbUtil.getTables(databaseBean);
        for (  TableBean tableBean:tableBeanList)
        {
            if (!tableBean.getTableName().equals("suc_data_class_brand")){
                continue;
            }
            List<ColumnsBean> columnsBeanList= DbUtil.getColumns(databaseBean,tableBean.getTableName());
            Map<String,Object> root= new HashMap<>();
            root.put("tableName",tableBean.getTableName());
            List<Map<String,Object>> columnMapList= new ArrayList<>();
            for (ColumnsBean columnsBean:columnsBeanList)
            {
                Map<String,Object> columnMap= new HashMap<>();
                String propertyName= CoreUtil.getPropertyName(columnsBean.getColumnName());
                columnMap.put("propertyName",propertyName);
                columnMap.put("columnName",columnsBean.getColumnName());
                columnMapList.add(columnMap);

            }
            root.put("columnMapList",columnMapList);
            String content=FreeMarkerUtil.print("sqlmap.ftl",root);
            FileUtil.writeTxt("F:\\aa\\map","sqlMap_"+tableBean.getTableName()+".xml",content);
 
        }
 
        
        
        
        
    }
}
