package com.only.core;

import com.only.bean.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;

public class TestCore
{
    public static void main(String[] args)  throws  Exception{
        //DatabaseBean databaseBean= new DatabaseBean("selffabu","x3WUaIsvD3","fwpsit1","10.37.153.65");
		InputStream is= null;
		OutputStream os= null;
		ObjectInputStream ois= null;
		try
		{
			File file=new File("F:\\test.txt");
			File file2=new File("F:\\test2.txt");
			is = new FileInputStream(file);
			os = new FileOutputStream(file2,true);
			Reader r=new InputStreamReader(is);

			Reader ir=new InputStreamReader(System.in);
			PrintStream a=System.out;
			byte[] b=new byte[4];
			int temp=0;
			String tem=null;

			//while((temp=is.read(b))!=-1){
			//	//System.out.print(new String(b));
			//	a.print(b);
			//	os.write(b);
			//}

			//BufferedReader br=new BufferedReader(r);
			//while((tem=br.readLine())!=null){
			//	System.out.println(new String(tem));
			//}

			User user=new User();
			user.setName("aaaaaaaas");
			user.setId("11111111111");

			//ObjectOutputStream osb=new ObjectOutputStream(os);
			//osb.writeObject(user);

			ois = new ObjectInputStream(new FileInputStream("F:\\test2.txt"));
			User s=(User)ois.readObject();
			System.out.print(s.getId());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
		}

		ois.close();
		os.close();
		is.close();

        //String a=ir.read();
    }
}
