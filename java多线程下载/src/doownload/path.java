package doownload;

public class path {
	public String downloadpath; //下载路径
	public String depositpath; //存放路径
	
	public void setdownloadpath(String Downloadpath) //填写下载路径
	{
		this.downloadpath=Downloadpath;
	}
	
	public void setdepositpath(String Depositpath) //填写存放路径
	{
		this.depositpath=Depositpath;
	}
	
	public void getdownloadpath() //打印下载路径
	{
		System.out.print("下载使用的URL是："+this.downloadpath +"\n");
	}
	
	public void getdepositpath() //打印存放路径
	{
		System.out.print("存放路径是："+this.depositpath +"\n");
	}
	

}
