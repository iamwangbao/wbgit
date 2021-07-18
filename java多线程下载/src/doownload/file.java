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
	public String filetype; //文件类型
	public long filesize; //文件大小
	public String filename; //文件名字
	
	public void setfiletype(String Filetype) //填写文件类型
	{
		this.filetype=Filetype;
	}
	
	public long setfilesize(long Filesize) //检测文件大小
	{
		this.filesize=Filesize;
		return this.filesize;
	}
	
	public void setfilename(String Filename)//填写文件名字
	{
		this.filename=Filename;
	}
	
	
	public void getfile() //输出文件信息
	{
		System.out.print("文件名是："+this.filename +"\n");
		System.out.print("文件类型是："+this.filetype +"\n");
		System.out.print("文件大小为："+this.filesize+"KB" +"\n");
	}
	
	
	 public  long getFileLength(String fileUrl) throws IOException {  //获取文件大小

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
		     * 创建文件
		     * @param fileName  文件名称
		     * @param filecontent   文件内容
		     * @return  是否创建成功，成功则返回true
		     */
		    public boolean createFile(){  //创建文件
		    	
		    	  //生成文件路径
			    String path = global.depositpath;
			    
			    //文件路径+名称
			    String filenameTemp;
		    	String fileName;
		    //	String filecontent;
		    	fileName=global.filename;
		    	
		        Boolean bool = false;
		        filenameTemp = path+'/'+this.filename+'.'+this.filetype;//文件路径+名称+文件类型
		        File file1 = new File(filenameTemp);
		        try {
		            //如果文件不存在，则创建新的文件
		            if(!file1.exists()){
		                file1.createNewFile();
		                bool = true;
		                System.out.println("success create file,the file is "+filenameTemp);
		                //创建文件成功后，写入内容到文件里
		            
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        
		        return bool;
		    }
	 
	
}
