package doownload;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

public class MyThread { 
	  public static final int subsection= 5; //�ֶ�����
    
    /**
     * ������ʼλ��
     */
    public long[][] startIndex=new long[global.quantity][global.quantity];
    /**
     * ���ؽ���λ��
     */
    public long[][] endIndex=new long[global.quantity][global.quantity];
   

 
    
  //���ص����ļ��Ĳ�ͬ���֣�˳�����ض���ļ�
    public void SegmentDownload()
    {
    	int[] partSize=new int[global.quantity];
  
    
        int partCount = subsection;
        int partCount2=partCount;
        
        for(int i=0;i<global.downnumber;i++) {
        	
         partSize[i] = (int)(global.filesize[i] / partCount);
        }
        
        for(int i=0;i<global.downnumber;i++) {
        	partCount2=partCount;
        	for(int j=0;j<partCount;j++) {
        		partCount2=partCount2-1;
        		
                // ���صĿ�ʼλ��
                startIndex[i][j] = (partCount2) * partSize[i];
               // ���صĽ���λ��
                endIndex[i][j] = startIndex[i][j] + partSize[i] - 1;
           
        	}
 
        }
        
        for(int i=0;i<global.downnumber;i++) {
        	for(int j=0;j<partCount;j++) {
        		//���һ�����صĳ�����΢��һ��
        	     endIndex[i][partCount-1] = endIndex[i][partCount-1] + 1;
        System.out.print(global.filename[i]  + "����:" + startIndex[i][j] + "�ֽ�~" + endIndex[i][j] + "�ֽ�"+"\n");
        }
        }
        
        
    }
    

    public void run() throws IOException, InterruptedException{ 
       
        	time time1=new time();
        	SegmentDownload();
        	
        	
        	URL[] url=new URL[global.quantity];
        	HttpURLConnection[] conn=new HttpURLConnection[global.quantity];
        
        	
        	InputStream[] is=new InputStream[global.quantity];
        	int[] code=new int[global.quantity];	
        	RandomAccessFile[] raf= new RandomAccessFile[global.quantity];
        	//time time1 =new time();
        	
        	for(int i=0;i<global.downnumber;i++) {
        		System.out.print( global.filename[i]+"��������...\n");
        		time1.setstarttime();//��ȡ��ʼ���ص�ʱ��  
        		for(int j=0;j<subsection;j++) {
            url[i] = new URL(global.downloadpath[i]);
            conn[i] = (HttpURLConnection)url[i].openConnection();
      
            //��ֹ���γ���ץȡ������403����
            conn[i].setRequestProperty("Connection", "Keep-Alive");
            conn[i].setRequestMethod("GET");
            //������������ز��ֵ��ļ���ָ��λ��
            conn[i].setRequestProperty("Range", "bytes=" + startIndex[i][j] + "-" + endIndex[i][j]);
          //���ó�ʱ��Ϊ5��
            conn[i].setConnectTimeout(5000);
             code[i] = conn[i].getResponseCode(); //����״̬�룬��ʶhttp״̬����
            System.out.print( global.filename[i]+ "���󷵻�code=" + code[i]+"\n");
            is[i] = conn[i].getInputStream();//������Դ
            raf[i] = new RandomAccessFile(global.file[i], "rwd");
            //���д�ļ���ʱ����ĸ�λ�ÿ�ʼд
          
            raf[i].seek(startIndex[i][j]);//��λ�ļ�
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is[i].read(buffer)) != -1) {
                raf[i].write(buffer, 0, len);               
            }
       
        	}
        	     is[i].close();
                 raf[i].close();
                 System.out.print(i + "�������"+"\n");
                global.Speed.getnowSpeed(i);
                System.out.println(global.filename[i]+'.'+global.filetype[i]+"�������");
                time1.setendtime(); //��ȡ������ɵ�ʱ��
                
                time1.getstarttime(i);
                time1.getendtime(i);   
        	}
        	
    }
        	
   
 

    
    
    
};
