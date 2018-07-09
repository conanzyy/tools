package com.only;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by 17021690 on 2017/7/10.
 */
public class HttpClientTest {
    public static void main(String[] args) {
        HttpClientTest httpClientTest= new HttpClientTest();
        httpClientTest.initClass();
    }

    public void initClass(){
        String cookie="_device_session_id=p_6b8cd0bf-7af1-4114-a8ac-877e477dd0b3; _cp_dt=0a4d0c88-e293-4c3d-8c44-e37884b6bfd7-15356; _snsr=direct%7Cdirect%7C%7C%7C; __ssar=direct%7Cdirect%7C%7C%7C; _snmc=1; _snma=1%7C149913122949043714%7C1499131229490%7C1499677803670%7C1499682901151%7C39%7C18; _snmp=149968290106647859; _snmb=149968290116163430%7C1499682901164%7C1499682901161%7C1; __ssav=149913122949043714%7C1499131229684%7C1499677803837%7C1499682901514%7C39%7C15%7C0; __ssas=149968290152558042%7C1499682901529%7C1499682901525%7C1; authId=siDD032ADD29ADB477595A6A90FA40DB87; __snuotr=2EF9FCA0%5E0K2NIBCAI%7B338RCK1K4V%3DDH%2593B57; custLevel=161000000130; custno=6007868507; idsLoginUserIdLastTime=18651668461; logonStatus=2; nick=186******61; nick2=186******61; sncnstr=pyEjUNw6GIkw9pHRf9TnlA%3D%3D; _snck=149968290533741956; __utma=64295096.1274220774.1499075641.1499657907.1499682906.27; __utmb=64295096.6.8.1499682913870; __utmc=64295096; __utmz=64295096.1499075641.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)";
        //1:创建一个httpclient对象
        HttpClient httpclient = new DefaultHttpClient();
        Charset charset = Charset.forName("UTF-8");//设置编码
        try {
            //2：创建http的发送方式对象，是GET还是post
            HttpPost httppost = new HttpPost("http://fwpsit.cnssssuung.com/fwp-web/api/user/collegeStudentAuth.do");
            httppost.setHeader("Cookie",cookie);

            //3：创建要发送的实体，就是key-value的这种结构，借助于这个类，可以实现文件和参数同时上传，很简单的。
            MultipartEntity reqEntity = new MultipartEntity();

            FileBody bin = new FileBody(new File("D:\\douya.jpg"));
            FileBody bin1 = new FileBody(new File("D:\\test.jpg"));
 
            ArrayList<FileBody> fileBodys = new ArrayList<>();
            fileBodys.add(bin);
            fileBodys.add(bin1);
            //        reqEntity.addPart(paramName,iteam);
            addFileBodyPart("studentIdImages", fileBodys, reqEntity);
            reqEntity.addPart("collegeCode",new StringBody("001",charset));
            reqEntity.addPart("educational",new StringBody("大专",charset));
            reqEntity.addPart("graduationDate",new StringBody("2010-12-03",charset));
            reqEntity.addPart("major",new StringBody("计算机",charset));
            reqEntity.addPart("studentId",new StringBody("1234",charset));
            httppost.setEntity(reqEntity);

            //4：执行httppost对象，从而获得信息
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity resEntity = response.getEntity();

            //获得返回来的信息，转化为字符串string
            String resString = EntityUtils.toString(resEntity);
            System.out.println(resString);

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try { httpclient.getConnectionManager().shutdown(); } catch (Exception ignore) {}
        }
    }

    //当多个文件需要上传时，对文件进行组装
    public void addFileBodyPart(String paramName, ArrayList<FileBody> fileBodys, MultipartEntity reqEntity){
        if(fileBodys == null || fileBodys.size() < 1 || reqEntity == null || paramName == null){
            return;
        }
        for(FileBody iteam : fileBodys){
            reqEntity.addPart(paramName,iteam);
        }
    }

  
}
