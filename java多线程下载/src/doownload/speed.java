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
		 * ��������ļ���ǰ��С����ǰ��С-ǰ1��Ĵ�С�����ж�ÿ��������ٶ�
		 */
		//while(true) {
		//TimeUnit.MILLISECONDS.sleep(1000);
		File file1 =new File(global.file);
		this.nowSize=getFileLength3(file1);
		this.nowSpeed=this.nowSize-this.upnowSize;
		this.upnowSize=this.nowSize;
		System.out.print("�����ٶ�Ϊ��"+this.nowSpeed +"byte"+ "/s" +'\n');
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
        System.out.println("�ļ�"+file.getName()+"�Ĵ�СΪ:"+fileChannel.size()+"byte");
        return fileChannel.size();
    }
    
    
}



