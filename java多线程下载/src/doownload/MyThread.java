package doownload;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{  // �̳�Thread�࣬��Ϊ�̵߳�ʵ����
    
    /**
     * �߳����سɹ���־
     */
    public static int flag = 0;
    /**
     * �߳�ID
     */
    public String threadId;
    /**
     * ������ʼλ��
     */
    public long[][] startIndex=new long[10][10];
    /**
     * ���ؽ���λ��
     */
    public long[][] endIndex=new long[10][10];
   

    /**
     * �̼߳���ͬ������
     */
    public CountDownLatch latch;
 
    public MyThread(String name){  // name��ʾ�̵߳�����
    	// ͨ����name��ֵ���߳�ID���� 
    	         threadId=name;
    	      } 
    
  //����߳����ص����ļ��Ĳ�ͬ���֣�˳�����ض���ļ�
    public void SegmentDownload()
    {
    	int[] partSize=new int[10];
  
    
        int partCount = Constans.MAX_THREAD_COUNT;
        int partCount2=partCount;
        
        for(int i=0;i<global.downnumber;i++) {
        	
         partSize[i] = (int)(global.filesize[i] / partCount);
        }
        
        for(int i=0;i<global.downnumber;i++) {
        	partCount2=partCount;
        	for(int j=0;j<partCount;j++) {
        		partCount2=partCount2-1;
        		
                // ÿһ���߳����صĿ�ʼλ��
                startIndex[i][j] = (partCount2) * partSize[i];
               // ÿһ���߳����صĿ�ʼλ��
                endIndex[i][j] = startIndex[i][j] + partSize[i] - 1;
           
        	}
 
        }
        
        for(int i=0;i<global.downnumber;i++) {
        	for(int j=0;j<partCount;j++) {
        		//���һ���߳����صĳ�����΢��һ��
        	     endIndex[i][partCount-1] = endIndex[i][partCount-1] + 1;
        System.out.print("�߳�" + threadId + "����:" + startIndex[i][j] + "�ֽ�~" + endIndex[i][j] + "�ֽ�"+"\n");
        }
        }
        
        
    }
    

    public void run(){  // ��дrun()��������Ϊ�߳� �Ĳ�������
        try {
  
        	time time1=new time();
        	SegmentDownload();
        	System.out.print("�߳�" + threadId + "��������...");
        	
        	URL[] url=new URL[10];
        	HttpURLConnection[] conn=new HttpURLConnection[10];
        
        	
        	InputStream[] is=new InputStream[10];
        	int[] code=new int[10];	
        	RandomAccessFile[] raf= new RandomAccessFile[10];
        	//time time1 =new time();
        	
        	for(int i=0;i<global.downnumber;i++) {
        		time1.setstarttime();//��ȡ��ʼ���ص�ʱ��  
        		for(int j=0;j<Constans.MAX_THREAD_COUNT;j++) {
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
            System.out.print("�߳�" + threadId + "���󷵻�code=" + code[i]+"\n");
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
                 System.out.print("�߳�" + threadId + "�������"+"\n");
                global.Speed.getnowSpeed(i);
                System.out.println(global.filename[i]+'.'+global.filetype[i]+"�������");
                time1.setendtime(); //��ȡ������ɵ�ʱ��
                
                time1.getstarttime(i);
                time1.getendtime(i);   
        	}
        	
        } catch (Exception e) {
                 //�߳����س���
                 MyThread.flag = 1;
                 System.out.printf(e.getMessage(),e);
             } finally {
                 //����ֵ��һ
             //    latch.countDown();
             }
        	
   
 

    
    }
    
};
