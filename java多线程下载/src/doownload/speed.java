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
		 * ��������ļ���ǰ��С����ǰ��С-ǰ1��Ĵ�С�����ж�ÿ��������ٶ�
		 */

	
		if(k!=i) //��������һ���ļ�ʱ������һ�εõ����ļ���С��0
		{
			this.nowSize=0;
			this.upnowSize=0;
			k=i;
		}
		
		 file1[i] =new File(global.file[i]);
			
		this.nowSize=getFileLength3(file1[i]);
		
		this.nowSpeed=this.nowSize-this.upnowSize;
		this.upnowSize=this.nowSize;
		
	
		System.out.print(global.filename[i]+'.'+global.filetype[i]+"�����ٶ�Ϊ��"+this.nowSpeed +"KB"+ "/s" +'\n');
		System.out.print(global.filename[i]+'.'+global.filetype[i]+"��ǰ���ؽ���Ϊ��"+String.format("%.2f",((this.nowSize*1.0)/(global.filesize[i]*1.0))*100) +"%" +'\n');
		
	/*	
		if(this.nowSpeed==0)
		{
		 break;
		}
		*/
	//}
	}

	/**
     * ����java.io.*������ȡ�ļ���С
     * @param file
     */
	
	
	/**
     * ��ȡ�ļ���С
     * ��ʽһ��FileInputStream.getChannel()
     * @throws IOException
     */
    public long getFileLength3(File file) throws IOException{
        FileInputStream fis = null;
        FileChannel fileChannel = null;
        if(file.exists() && file.isFile()){
            fis = new FileInputStream(file);
            fileChannel = fis.getChannel();
        }
        System.out.println("�ļ�"+file.getName()+"�Ĵ�СΪ:"+fileChannel.size()+"KB");
        return fileChannel.size();
    }
    
    
}



