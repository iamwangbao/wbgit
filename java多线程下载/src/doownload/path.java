package doownload;

public class path {
	public String[] downloadpath=new String[10]; //下载路径
	public String[] depositpath=new String[10]; //存放路径
		
	public void setdownloadpath(String[] Downloadpath) //填写下载路径
	{
		for(int i=0;i<global.downnumber;i++)
		this.downloadpath[i]=Downloadpath[i];
	}
	
	public void setdepositpath(String[] Depositpath) //填写存放路径
	{
		for(int i=0;i<global.downnumber;i++)
		this.depositpath[i]=Depositpath[i];
	}
	
	public void getdownloadpath() //打印下载路径
	{
		for(int i=0;i<global.downnumber;i++)
		System.out.print(global.filename[i]+'.'+global.filetype[i]+"下载使用的URL是："+this.downloadpath[i] +"\n");
	}
	
	public void getdepositpath() //打印存放路径
	{
		for(int i=0;i<global.downnumber;i++)
		System.out.print(global.filename[i]+'.'+global.filetype[i]+"存放路径是："+this.depositpath[i] +"\n");
	}
	

}
