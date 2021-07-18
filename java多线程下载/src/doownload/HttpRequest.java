package doownload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HttpRequest {
    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath,String toekn) throws IOException, InterruptedException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        conn.setRequestProperty("lfwywxqyh_token",toekn);

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);
        
        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }


     //   System.out.println("info:"+url+" download success"); 提示该链接下载完成

    }


    
    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     * @throws InterruptedException 
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException, InterruptedException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        File saveDir = new File(global.depositpath);
        File file = new File(saveDir+File.separator+global.filename+'.'+global.filetype);
        FileOutputStream fos = new FileOutputStream(file);
        
        long time_s =System.currentTimeMillis()/1000;
        long time_s2 =System.currentTimeMillis()/1000;
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);  //数据流写入数组，完全下载后再传递，传递的数据将一次性写入文件
            
           
            fos.write(buffer); //数据流写入文件
            
            time_s2 =System.currentTimeMillis()/1000;
            
            if(time_s2-time_s>=1)
            {
            global.Speed.getnowSpeed();
            time_s=time_s2;
            }
        }
               
        fos.close();
        bos.close();
        return bos.toByteArray();
    }


}