package doownload;


import java.io.IOException;
import java.net.URL;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.io.File;
import java.io.FileOutputStream;

public class HttpRequest {
    /**
     * ������Url�������ļ�
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     * @throws InterruptedException 
     */


    
    /**
     * ���������л�ȡ�ֽ�����
     * @param inputStream
     * @return
     * @throws IOException
     * @throws InterruptedException 
     */
    public static  void readInputStream() throws IOException, InterruptedException {
    	URL[] url=new URL[global.quantity];
    	HttpURLConnection[] conn=new HttpURLConnection[global.quantity];
    	InputStream[] inputStream=new InputStream[global.quantity];
    	time time1 =new time();
    	for(int i=0;i<global.downnumber;i++) {
        url[i] = new URL(global.downloadpath[i]);
        conn[i] = (HttpURLConnection)url[i].openConnection();
        //���ó�ʱ��Ϊ3��
        conn[i].setConnectTimeout(3*1000);
        //��ֹ���γ���ץȡ������403����
        conn[i].setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        conn[i].setRequestProperty("lfwywxqyh_token",global.token);
        inputStream[i] = conn[i].getInputStream();
    	}
    	
        
      

        //�õ�������
       
    	
    	//����ļ������߳�����
    	///////////////
        byte[] buffer = new byte[1024];
      
        
        File[] saveDir = new File[global.quantity];
        File[] file = new File[global.quantity];
        FileOutputStream[] fos = new FileOutputStream[global.quantity];
        
        for(int i=0;i<global.downnumber;i++) {
         saveDir[i] = new File(global.depositpath[i]);
         file[i] = new File(saveDir[i]+File.separator+global.filename[i]+'.'+global.filetype[i]);
        
         fos[i] = new FileOutputStream(file[i]);
        }
        
        long time_s =System.currentTimeMillis()/1000;
        long time_s2 =System.currentTimeMillis()/1000;
        int len = 0;
        
        for(int i=0;i<global.downnumber;i++) {
            time1.setstarttime();//��ȡ��ʼ���ص�ʱ��  
        while((len = inputStream[i].read(buffer)) != -1) {
            
            fos[i].write(buffer); //������д���ļ�
            
            
            time_s2 =System.currentTimeMillis()/1000;
            
            if(time_s2-time_s>=1)
            {
            global.Speed.getnowSpeed(i);
            time_s=time_s2;
            }
        }
        global.Speed.getnowSpeed(i);
        System.out.println(global.filename[i]+'.'+global.filetype[i]+"�������");
        time1.setendtime(); //��ȡ������ɵ�ʱ��
        
        time1.getstarttime(i);
        time1.getendtime(i);   
        
      //  TimeUnit.MILLISECONDS.sleep(3000);//MILLISECONDS��ʾ�Ժ���Ϊ��λ��ʱ
       
        }
 
        
        for(int i=0;i<global.downnumber;i++) {
        if(fos[i]!=null){
            fos[i].close();
        }
        if(inputStream[i]!=null){
            inputStream[i].close();
        }
        }
    }
    

}