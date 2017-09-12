package com.only.core;

import com.only.bean.ColumnsBean;
import com.only.bean.DatabaseBean;
import com.only.bean.TableBean;
import com.only.util.DbUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

 
public class ExcelCore
{
	/**
	 * 根据表结构生成xlsx
	 */
	public static void create() throws Exception
	{

		DatabaseBean databaseBean= new DatabaseBean("root","yufei","fwp","127.0.0.1");
		List<TableBean> tableBeanList= DbUtil.getTables(databaseBean);
		for (TableBean tableBean:tableBeanList)
		{
			String tableName=tableBean.getTableName();
			try
			{
				List<ColumnsBean> columnsBeanList= DbUtil.getColumns(databaseBean,tableName);
				String[] title = {"原字段名","是否为空","类型","字段名","备注"};
				XSSFWorkbook workbook = new XSSFWorkbook();
				Sheet sheet = workbook.createSheet();
				Row row = sheet.createRow(0);
				Cell cell = row.createCell(0);
				cell.setCellValue(tableBean.getTableComment()+"("+tableName+")");
				row = sheet.createRow(1);
				for (int i = 0; i < title.length; i++)
				{
					cell = row.createCell(i);
					cell.setCellValue(title[i]);
				}
				for (int i=2;i<columnsBeanList.size()+2;i++)
				{
					ColumnsBean columnsBean=columnsBeanList.get(i-2);
					String columnName=columnsBean.getColumnName();
					Row nextrow = sheet.createRow(i);
					//原字段名
					cell = nextrow.createCell(0);
					cell.setCellValue(columnName);
					//是否为空
					cell = nextrow.createCell(1);
					cell.setCellValue(columnsBean.getIsNull());
					//类型
					cell=nextrow.createCell(2);
					cell.setCellValue(columnsBean.getColumnType());
					//字段名
					cell=nextrow.createCell(3);
					cell.setCellValue(columnName.toLowerCase());
					//注释
					cell=nextrow.createCell(4);
					cell.setCellValue(columnsBean.getColumnComment());
				}

				//创建一个文件
				String fileName=String.format("f:/db/%s.xlsx",tableName);
				File file = new File(fileName);
				try {
					file.createNewFile();
					FileOutputStream stream = FileUtils.openOutputStream(file);
					workbook.write(stream);
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	
	}
}
