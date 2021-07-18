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
	public long nowSize=0;
	public long upnowSize=0;
	public void getnowSpeed() throws IOException, InterruptedException
	{
		
		/*
		 * 检测下载文件当前大小（当前大小-前1秒的大小）来判断每秒的下载速度
		 */
		//while(true) {
		//TimeUnit.MILLISECONDS.sleep(1000);
		File file1 =new File(global.file);
		this.nowSize=getFileLength3(file1);
		this.nowSpeed=this.nowSize-this.upnowSize;
		this.upnowSize=this.nowSize;
		System.out.print("下载速度为："+this.nowSpeed +"byte"+ "/s" +'\n');
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
        System.out.println("文件"+file.getName()+"的大小为:"+fileChannel.size()+"byte");
        return fileChannel.size();
    }
    
    
}



