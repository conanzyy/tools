package com.only.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileUtil
{

	public static void writeTxt(String path, String fileName, String content)
	{
	 
		File file= new File(path);
		if (!file.exists())
		{
			file.mkdirs();
		}
		try (FileOutputStream out = new FileOutputStream(path+File.separator+fileName);
		// 把字节流转换为字符流
				OutputStreamWriter writer = new OutputStreamWriter(out);
				// 缓存流
				BufferedWriter br = new BufferedWriter(writer);)
		{
			br.write(content);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
