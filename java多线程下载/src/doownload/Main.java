package doownload;

import java.io.IOException;
import java.util.Scanner;



public class Main {

	
	public static  Scanner input = new Scanner(System.in);
    
	public static void main(String[] args) throws IOException, InterruptedException {
    // write your code here
    	
    	
    	String Filename; //文件名
    	String Filetype;  //文件类型
    	String Depositpath;  //存放路径
    	String Downloadpath; //下载路径
    	long Filesize;//文件大小
    //	String starttime; //开始时间
    //	String endtime; //结束时间
      //String url="http://127.0.0.1:9001/abc/notice/export?startDate=2017-1-27&endDate=2017-12-31";
       
    	 file file1=new file();
    	 path path1=new path();
    	 time time1 =new time();
    	 speed speed1=new speed();
    System.out.println("请输入下载链接：");
    Downloadpath=input.next();
    path1.setdownloadpath(Downloadpath);
    
    System.out.println("请输入文件名：");
    Filename=input.next();
    file1.setfilename(Filename);
    
    System.out.println("请输入文件类型（后缀名）：");
    Filetype=input.next();
    file1.setfiletype(Filetype);
    
    System.out.println("请输入存放地址：");
    Depositpath=input.next();
    path1.setdepositpath(Depositpath);
    
    global.file =path1.depositpath+"\\"+file1.filename+'.'+file1.filetype;
  System.out.println(global.file);
    Filesize=file1.setfilesize(file1.getFileLength( Downloadpath));
    //  System.out.println(file1.filesize);
    file1.getfile();
    path1.getdownloadpath();
    path1.getdepositpath();
    
    
    global.Speed=speed1;
    global.depositpath=path1.depositpath;
    global.filename=file1.filename;
    global.filetype=file1.filetype;
    
    file1.createFile();
    
    
    
    if(Filesize==0)
    {
    	System.out.println("检测到该文件大小为0，请确认URL是否正确");
    return; //如果文件大小为零，结束程序
    }
    
        String token="v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";
       // String token="SiGBCH6QblUHs7NiouV09rL6uAA3Sv0cGicaSxJiC/78DoWIMzVbW6VCwwkymYsZaxndDkYqkm4=";
        //测试路径"https://dldir1.qq.com/qqtv/TencentVideo11.24.1062.0.exe"，文件为腾讯视频.exe,存放路径为"D:\\360安全浏览器下载"
        
        /*
          HttpRequest.downLoadFromUrl("https://dldir1.qq.com/qqtv/TencentVideo11.24.1062.0.exe","腾讯视频.exe","D:\\360安全浏览器下载",token);
          System.out.println("下载完成");
       */
  

        
        //开始下载
        if(Filename!=null && Filetype!=null && Depositpath!=null && Downloadpath!=null )
        {
        
        time1.setstarttime();//读取开始下载的时间     
        HttpRequest.downLoadFromUrl(path1.downloadpath,file1.filename+'.'+file1.filetype,path1.depositpath,token);
        
       // speed1.getnowSpeed();
        System.out.println("下载完成");
        time1.setendtime(); //读取下载完成的时间
        
        time1.getstarttime();
        time1.getendtime();
        
       
        }
        else
        {
        	System.out.println("请将信息输入完整");
        }

        
    }
}