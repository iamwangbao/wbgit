package doownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class speed {

	public long nowSpeed;
	public long nowSize;
	public long upnowSize;
	public void getnowSpeed(int i) throws IOException, InterruptedException
	{

		int k=0;
		File[] file1 = new File[10];
		
		/*
		 * 检测下载文件当前大小（当前大小-前1秒的大小）来判断每秒的下载速度
		 */

	
		if(k!=i) //当下载下一个文件时，将上一次得到的文件大小清0
		{
			this.nowSize=0;
			this.upnowSize=0;
			k=i;
		}
		
		 file1[i] =new File(global.file[i]);
			
		this.nowSize=getFileLength3(file1[i]);
		
		this.nowSpeed=this.nowSize-this.upnowSize;
		this.upnowSize=this.nowSize;
		
	
		System.out.print(global.filename[i]+'.'+global.filetype[i]+"下载速度为："+this.nowSpeed +"KB"+ "/s" +'\n');
		System.out.print(global.filename[i]+'.'+global.filetype[i]+"当前下载进度为："+String.format("%.2f",((this.nowSize*1.0)/(global.filesize[i]*1.0))*100) +"%" +'\n');
		
	/*	
		if(this.nowSpeed==0)
		{
		 break;
		}
		*/
	//}
	}

	/**
     * 根据java.io.*的流获取文件大小
     * @param file
     */
	
	
	/**
     * 获取文件大小
     * 方式一：FileInputStream.getChannel()
     * @throws IOException
     */
    public long getFileLength3(File file) throws IOException{
        FileInputStream fis = null;
        FileChannel fileChannel = null;
        if(file.exists() && file.isFile()){
            fis = new FileInputStream(file);
            fileChannel = fis.getChannel();
        }
        System.out.println("文件"+file.getName()+"的大小为:"+fileChannel.size()+"KB");
        return fileChannel.size();
    }
    
    
}



