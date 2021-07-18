package doownload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

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


public class file {
	public String filetype; //�ļ�����
	public long filesize; //�ļ���С
	public String filename; //�ļ�����
	
	public void setfiletype(String Filetype) //��д�ļ�����
	{
		this.filetype=Filetype;
	}
	
	public long setfilesize(long Filesize) //����ļ���С
	{
		this.filesize=Filesize;
		return this.filesize;
	}
	
	public void setfilename(String Filename)//��д�ļ�����
	{
		this.filename=Filename;
	}
	
	
	public void getfile() //����ļ���Ϣ
	{
		System.out.print("�ļ����ǣ�"+this.filename +"\n");
		System.out.print("�ļ������ǣ�"+this.filetype +"\n");
		System.out.print("�ļ���СΪ��"+this.filesize+"KB" +"\n");
	}
	
	
	 public  long getFileLength(String fileUrl) throws IOException {  //��ȡ�ļ���С

	        if (fileUrl == null || "".equals(fileUrl)) {
	            return 0 ;
	        }
	        URL url = new URL(fileUrl);
	        HttpURLConnection conn = null;
	        try {
	            conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("HEAD");
	            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows 7; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.73 Safari/537.36 YNoteCef/5.8.0.1 (Windows)");
	            return (long) conn.getContentLength();
	        } catch (IOException e) {
	            return 0 ;
	        } finally {

	            conn.disconnect();
	        }

	    }
	 
	 

		  
		    /**
		     * �����ļ�
		     * @param fileName  �ļ�����
		     * @param filecontent   �ļ�����
		     * @return  �Ƿ񴴽��ɹ����ɹ��򷵻�true
		     */
		    public boolean createFile(){  //�����ļ�
		    	
		    	  //�����ļ�·��
			    String path = global.depositpath;
			    
			    //�ļ�·��+����
			    String filenameTemp;
		    	String fileName;
		    //	String filecontent;
		    	fileName=global.filename;
		    	
		        Boolean bool = false;
		        filenameTemp = path+'/'+this.filename+'.'+this.filetype;//�ļ�·��+����+�ļ�����
		        File file1 = new File(filenameTemp);
		        try {
		            //����ļ������ڣ��򴴽��µ��ļ�
		            if(!file1.exists()){
		                file1.createNewFile();
		                bool = true;
		                System.out.println("success create file,the file is "+filenameTemp);
		                //�����ļ��ɹ���д�����ݵ��ļ���
		            
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        
		        return bool;
		    }
	 
	
}
