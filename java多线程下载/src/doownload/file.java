package doownload;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.File;


public class file {
	public String[] filetype=new String[global.quantity]; //文件类型
	public long[] filesize=new long[global.quantity]; //文件大小
	public String[] filename=new String[global.quantity]; //文件名字
	
	public void setfiletype(String[] Filetype) //填写文件类型
	{
		for(int i=0;i<global.downnumber;i++)
		this.filetype[i]=Filetype[i];
	}
	
	public long setfilesize(long Filesize) //检测文件大小
	{
		for(int i=0;i<global.downnumber;i++)
		this.filesize[i]=Filesize;
		
		return Filesize;
	}
	
	public void setfilename(String[] Filename)//填写文件名字
	{
		for(int i=0;i<global.downnumber;i++)
		this.filename[i]=Filename[i];
	}
	
	
	public void getfile() //输出文件信息
	{
		for(int i=0;i<global.downnumber;i++) {
		System.out.print("文件名是："+this.filename[i] +"\n");
		System.out.print("文件类型是："+this.filetype[i] +"\n");
		System.out.print("文件大小为："+this.filesize[i]+"KB" +"\n");
		}
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
		    public void createFile(){  //创建文件
		    	
		    	String[] filenameTemp = new String[global.quantity];
			    String[] fileName=new String[global.quantity];
		    	String[] path=new String[global.quantity];
		    	  //生成文件路径  //文件路径+名称
		    	for(int i=0;i<global.downnumber;i++) {
			     path[i] = global.depositpath[i];
			     fileName[i]=global.filename[i];
		    	}
			   
	       
		        for(int i=0;i<global.downnumber;i++) {
		        filenameTemp[i] = path[i]+File.separator+this.filename[i]+'.'+this.filetype[i];//文件路径+名称+文件类型
		        File file1 = new File(filenameTemp[i]);
		        try {
		            //如果文件不存在，则创建新的文件
		            if(!file1.exists()){
		                file1.createNewFile();
		              
		                System.out.println("success create file,the file is "+filenameTemp[i]);
		                //创建文件成功后，写入内容到文件里
		            
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        }
		        
		    
		    }
	 
	
}
