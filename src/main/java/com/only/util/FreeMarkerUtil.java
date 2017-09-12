package com.only.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerUtil
{
	public static String print(String templeate,Map root)
	{
		//负责管理FreeMarker模板文件的Configuration实例
		Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		try
		{
			// 设置FreeMarker的模板文件位置
			cfg.setDirectoryForTemplateLoading(new File("templates"));
			// 使用Configuration实例来加载指定模板
			Template t = cfg.getTemplate(templeate);
			// 处理合并
			try
			{
				if (root==null)
				{
					root= new HashMap<>();
				}
				Writer out = new StringWriter();
				t.process(root, out);
				out.flush();
				return out.toString();
			 
				

			}
			catch (TemplateException e)
			{
				e.printStackTrace();
				return "";
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
			return "";
		}
	}
}
