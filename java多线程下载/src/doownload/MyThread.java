package doownload;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{  // 继承Thread类，作为线程的实现类
    
    /**
     * 线程下载成功标志
     */
    public static int flag = 0;
    /**
     * 线程ID
     */
    public String threadId;
    /**
     * 下载起始位置
     */
    public long[][] startIndex=new long[10][10];
    /**
     * 下载结束位置
     */
    public long[][] endIndex=new long[10][10];
   

    /**
     * 线程计数同步辅助
     */
    public CountDownLatch latch;
 
    public MyThread(String name){  // name表示线程的名称
    	// 通过将name赋值给线程ID命名 
    	         threadId=name;
    	      } 
    
  //多个线程下载单个文件的不同部分，顺序下载多个文件
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
        		
                // 每一个线程下载的开始位置
                startIndex[i][j] = (partCount2) * partSize[i];
               // 每一个线程下载的开始位置
                endIndex[i][j] = startIndex[i][j] + partSize[i] - 1;
           
        	}
 
        }
        
        for(int i=0;i<global.downnumber;i++) {
        	for(int j=0;j<partCount;j++) {
        		//最后一个线程下载的长度稍微长一点
        	     endIndex[i][partCount-1] = endIndex[i][partCount-1] + 1;
        System.out.print("线程" + threadId + "下载:" + startIndex[i][j] + "字节~" + endIndex[i][j] + "字节"+"\n");
        }
        }
        
        
    }
    

    public void run(){  // 覆写run()方法，作为线程 的操作主体
        try {
  
        	time time1=new time();
        	SegmentDownload();
        	System.out.print("线程" + threadId + "正在下载...");
        	
        	URL[] url=new URL[10];
        	HttpURLConnection[] conn=new HttpURLConnection[10];
        
        	
        	InputStream[] is=new InputStream[10];
        	int[] code=new int[10];	
        	RandomAccessFile[] raf= new RandomAccessFile[10];
        	//time time1 =new time();
        	
        	for(int i=0;i<global.downnumber;i++) {
        		time1.setstarttime();//读取开始下载的时间  
        		for(int j=0;j<Constans.MAX_THREAD_COUNT;j++) {
            url[i] = new URL(global.downloadpath[i]);
            conn[i] = (HttpURLConnection)url[i].openConnection();
      
            //防止屏蔽程序抓取而返回403错误
            conn[i].setRequestProperty("Connection", "Keep-Alive");
            conn[i].setRequestMethod("GET");
            //请求服务器下载部分的文件的指定位置
            conn[i].setRequestProperty("Range", "bytes=" + startIndex[i][j] + "-" + endIndex[i][j]);
          //设置超时间为5秒
            conn[i].setConnectTimeout(5000);
             code[i] = conn[i].getResponseCode(); //返回状态码，标识http状态返回
            System.out.print("线程" + threadId + "请求返回code=" + code[i]+"\n");
            is[i] = conn[i].getInputStream();//返回资源
            raf[i] = new RandomAccessFile(global.file[i], "rwd");
            //随机写文件的时候从哪个位置开始写
          
            raf[i].seek(startIndex[i][j]);//定位文件
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is[i].read(buffer)) != -1) {
                raf[i].write(buffer, 0, len);               
            }
       
        	}
        	     is[i].close();
                 raf[i].close();
                 System.out.print("线程" + threadId + "下载完毕"+"\n");
                global.Speed.getnowSpeed(i);
                System.out.println(global.filename[i]+'.'+global.filetype[i]+"下载完成");
                time1.setendtime(); //读取下载完成的时间
                
                time1.getstarttime(i);
                time1.getendtime(i);   
        	}
        	
        } catch (Exception e) {
                 //线程下载出错
                 MyThread.flag = 1;
                 System.out.printf(e.getMessage(),e);
             } finally {
                 //计数值减一
             //    latch.countDown();
             }
        	
   
 

    
    }
    
};
