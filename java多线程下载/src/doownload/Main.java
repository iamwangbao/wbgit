package doownload;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class Main {

	
	public static  Scanner input = new Scanner(System.in);
    
	public static void main(String[] args) throws IOException, InterruptedException {

    	
		 MyThread mt1 = new MyThread("�߳�A ") ;    // ʵ��������
	

	        
	        
    	String[] Filename = new String[10]; //�ļ���
    	String[] Filetype = new String[10];;  //�ļ�����
    	String[] Depositpath = new String[10];;  //���·��
    	String[] Downloadpath = new String[10];; //����·��
    	long[] Filesize = new long[10];;//�ļ���С
    	int downnumber=0;
    	 boolean end =false;

       
    	 file file1=new file();
    	 path path1=new path();

    	 speed speed1=new speed();
    	 
    	 do {
    		 int i=downnumber;
    System.out.println("�������������ӣ�");
    Downloadpath[i]=input.next();
   
    
    System.out.println("�������ļ�����");
    Filename[i]=input.next();
    
    
    System.out.println("�������ļ����ͣ���׺������");
    Filetype[i]=input.next();
    
    
    System.out.println("�������ŵ�ַ��");
    Depositpath[i]=input.next();
	  
	  downnumber=downnumber+1;
	  
	  int end1=0;
	  System.out.println("�Ƿ�������룿1/0");
	  end1=input.nextInt();
	  
	  if(end1==1)
	  {
		  end=false;
	  }
	  else
	  {
		  end=true;
	  }
	  
	  if(downnumber>10)
	  {
		  System.out.println("������Ϣ���������ܴ���10�飡");
		  end=false;
	  }
	  
    	 }while(end==true);
    	 
    	 global.downnumber=downnumber;
    	 path1.setdownloadpath(Downloadpath);
    	 file1.setfilename(Filename);
    	 file1.setfiletype(Filetype);
    	 path1.setdepositpath(Depositpath);
    	
   
    	 for(int i=0;i<global.downnumber;i++) {	  
    Filesize[i]=file1.setfilesize(file1.getFileLength( Downloadpath[i]));
    	 }
    	 
    	 for(int i=0;i<global.downnumber;i++) {	 
    		    global.filesize[i]=Filesize[i];
    		    global.Speed=speed1;
    		    global.depositpath[i]=path1.depositpath[i];
    		    global.filename[i]=file1.filename[i];
    		    global.filetype[i]=file1.filetype[i];
    		    global.downloadpath[i]=path1.downloadpath[i];
    		    global.file[i] =path1.depositpath[i]+File.separator+file1.filename[i]+'.'+file1.filetype[i];
    		 	  System.out.println(global.file[i]);
    		    }
    	 
    file1.getfile();
    path1.getdownloadpath();
    path1.getdepositpath();
   
    file1.createFile();
    
    
    for(int i=0;i<global.downnumber;i++) { 
    if(Filesize[i]==0)
    {
    	System.out.println("��⵽��"+i+"���ļ���СΪ0����ȷ��URL�Ƿ���ȷ");
   
    }
    }
    
        String token="v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";
  
        global.token=token;
       
        
        
        //��ʼ����

    //    HttpRequest.readInputStream(); //���߳�����
      
        mt1.start() ;   // ���ö��߳����忪ʼ����
 
        
    }
}