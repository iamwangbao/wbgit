package doownload;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

public class MyThread { 
	  public static final int subsection= 5; //分段数量
    
    /**
     * 下载起始位置
     */
    public long[][] startIndex=new long[global.quantity][global.quantity];
    /**
     * 下载结束位置
     */
    public long[][] endIndex=new long[global.quantity][global.quantity];
   

 
    
  //下载单个文件的不同部分，顺序下载多个文件
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
        		
                // 下载的开始位置
                startIndex[i][j] = (partCount2) * partSize[i];
               // 下载的结束位置
                endIndex[i][j] = startIndex[i][j] + partSize[i] - 1;
           
        	}
 
        }
        
        for(int i=0;i<global.downnumber;i++) {
        	for(int j=0;j<partCount;j++) {
        		//最后一个下载的长度稍微长一点
        	     endIndex[i][partCount-1] = endIndex[i][partCount-1] + 1;
        System.out.print(global.filename[i]  + "下载:" + startIndex[i][j] + "字节~" + endIndex[i][j] + "字节"+"\n");
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
        		System.out.print( global.filename[i]+"正在下载...\n");
        		time1.setstarttime();//读取开始下载的时间  
        		for(int j=0;j<subsection;j++) {
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
            System.out.print( global.filename[i]+ "请求返回code=" + code[i]+"\n");
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
                 System.out.print(i + "下载完毕"+"\n");
                global.Speed.getnowSpeed(i);
                System.out.println(global.filename[i]+'.'+global.filetype[i]+"下载完成");
                time1.setendtime(); //读取下载完成的时间
                
                time1.getstarttime(i);
                time1.getendtime(i);   
        	}
        	
    }
        	
   
 

    
    
    
};
