package com.only;

import com.only.bean.ColumnsBean;
import com.only.bean.DatabaseBean;
import com.only.bean.TableBean;
import com.only.core.ExcelCore;
import com.only.util.DbUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ExcelCore.create();
    }

    /**
     * 获取所有的表
     * @throws SQLException
     */
    private static void test01() throws SQLException
    {
        DatabaseBean databaseBean= new DatabaseBean("root","yufei","cnblogs_han_ssm","127.0.0.1");
        List<TableBean> tableBeanList= DbUtil.getTables(databaseBean);
        System.out.println(tableBeanList);
    }

    /**
     * 获取所有的列
     * @throws SQLException
     */
    private static void test02() throws SQLException
    {
        DatabaseBean databaseBean= new DatabaseBean("root","yufei","cnblogs_han_ssm","127.0.0.1");
        List<ColumnsBean> columnsBeanList= DbUtil.getColumns(databaseBean,"suc_reex_audit_report");
        System.out.println(columnsBeanList);
    }

     
}
