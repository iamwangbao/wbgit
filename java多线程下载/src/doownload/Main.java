package doownload;

import java.io.IOException;
import java.util.Scanner;



public class Main {

	
	public static  Scanner input = new Scanner(System.in);
    
	public static void main(String[] args) throws IOException, InterruptedException {
    // write your code here
    	
    	
    	String Filename; //�ļ���
    	String Filetype;  //�ļ�����
    	String Depositpath;  //���·��
    	String Downloadpath; //����·��
    	long Filesize;//�ļ���С
    //	String starttime; //��ʼʱ��
    //	String endtime; //����ʱ��
      //String url="http://127.0.0.1:9001/abc/notice/export?startDate=2017-1-27&endDate=2017-12-31";
       
    	 file file1=new file();
    	 path path1=new path();
    	 time time1 =new time();
    	 speed speed1=new speed();
    System.out.println("�������������ӣ�");
    Downloadpath=input.next();
    path1.setdownloadpath(Downloadpath);
    
    System.out.println("�������ļ�����");
    Filename=input.next();
    file1.setfilename(Filename);
    
    System.out.println("�������ļ����ͣ���׺������");
    Filetype=input.next();
    file1.setfiletype(Filetype);
    
    System.out.println("�������ŵ�ַ��");
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
    	System.out.println("��⵽���ļ���СΪ0����ȷ��URL�Ƿ���ȷ");
    return; //����ļ���СΪ�㣬��������
    }
    
        String token="v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";
       // String token="SiGBCH6QblUHs7NiouV09rL6uAA3Sv0cGicaSxJiC/78DoWIMzVbW6VCwwkymYsZaxndDkYqkm4=";
        //����·��"https://dldir1.qq.com/qqtv/TencentVideo11.24.1062.0.exe"���ļ�Ϊ��Ѷ��Ƶ.exe,���·��Ϊ"D:\\360��ȫ���������"
        
        /*
          HttpRequest.downLoadFromUrl("https://dldir1.qq.com/qqtv/TencentVideo11.24.1062.0.exe","��Ѷ��Ƶ.exe","D:\\360��ȫ���������",token);
          System.out.println("�������");
       */
  

        
        //��ʼ����
        if(Filename!=null && Filetype!=null && Depositpath!=null && Downloadpath!=null )
        {
        
        time1.setstarttime();//��ȡ��ʼ���ص�ʱ��     
        HttpRequest.downLoadFromUrl(path1.downloadpath,file1.filename+'.'+file1.filetype,path1.depositpath,token);
        
       // speed1.getnowSpeed();
        System.out.println("�������");
        time1.setendtime(); //��ȡ������ɵ�ʱ��
        
        time1.getstarttime();
        time1.getendtime();
        
       
        }
        else
        {
        	System.out.println("�뽫��Ϣ��������");
        }

        
    }
}