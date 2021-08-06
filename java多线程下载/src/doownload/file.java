package doownload;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.File;


public class file {
	public String[] filetype=new String[global.quantity]; //�ļ�����
	public long[] filesize=new long[global.quantity]; //�ļ���С
	public String[] filename=new String[global.quantity]; //�ļ�����
	
	public void setfiletype(String[] Filetype) //��д�ļ�����
	{
		for(int i=0;i<global.downnumber;i++)
		this.filetype[i]=Filetype[i];
	}
	
	public long setfilesize(long Filesize) //����ļ���С
	{
		for(int i=0;i<global.downnumber;i++)
		this.filesize[i]=Filesize;
		
		return Filesize;
	}
	
	public void setfilename(String[] Filename)//��д�ļ�����
	{
		for(int i=0;i<global.downnumber;i++)
		this.filename[i]=Filename[i];
	}
	
	
	public void getfile() //����ļ���Ϣ
	{
		for(int i=0;i<global.downnumber;i++) {
		System.out.print("�ļ����ǣ�"+this.filename[i] +"\n");
		System.out.print("�ļ������ǣ�"+this.filetype[i] +"\n");
		System.out.print("�ļ���СΪ��"+this.filesize[i]+"KB" +"\n");
		}
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
		    public void createFile(){  //�����ļ�
		    	
		    	String[] filenameTemp = new String[global.quantity];
			    String[] fileName=new String[global.quantity];
		    	String[] path=new String[global.quantity];
		    	  //�����ļ�·��  //�ļ�·��+����
		    	for(int i=0;i<global.downnumber;i++) {
			     path[i] = global.depositpath[i];
			     fileName[i]=global.filename[i];
		    	}
			   
	       
		        for(int i=0;i<global.downnumber;i++) {
		        filenameTemp[i] = path[i]+File.separator+this.filename[i]+'.'+this.filetype[i];//�ļ�·��+����+�ļ�����
		        File file1 = new File(filenameTemp[i]);
		        try {
		            //����ļ������ڣ��򴴽��µ��ļ�
		            if(!file1.exists()){
		                file1.createNewFile();
		              
		                System.out.println("success create file,the file is "+filenameTemp[i]);
		                //�����ļ��ɹ���д�����ݵ��ļ���
		            
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        }
		        
		    
		    }
	 
	
}
