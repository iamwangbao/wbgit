package doownload;
import java.text.SimpleDateFormat;
import java.util.Date; //导入时间包
public class time {
	public  String[] starttime=new String[global.quantity]; //开始时间
	public  String[] endtime=new String[global.quantity]; //结束时间
	public  String[] estimatetime=new String[global.quantity]; //预估时间
	
	   public String formattime(Date dNow) { //格式化时间格式为年-月-日-时-分-秒
		   
		     SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		 
		     // System.out.println("当前时间为: " + ft.format(dNow));
		      return ft.format(dNow);
		   }
	
	
	public void setstarttime() //时间
	{
		 Date date = new Date();
		 //当开始下载时，获取一次时间作为开始时间
		 for(int i=0;i<global.downnumber;i++)
		 this.starttime[i]=formattime(date);

				 
	}
	
	public void setendtime() //时间
	{
		 Date date = new Date();
	
		//当结束下载时，获取一次时间作为结束时间
		 for(int i=0;i<global.downnumber;i++)
		 this.endtime[i] =formattime(date);
		 //预估时间=剩余文件大小/当前下载速度
		 
	}
	
	public void getstarttime(int i) //打印开始时间
	{
		
	 System.out.print(global.filename[i]+'.'+global.filetype[i]+"开始时间是："+this.starttime[i] +'\n');
	}
	
	public void getendtime(int i) //打印结束时间
	{
		
	 System.out.print(global.filename[i]+'.'+global.filetype[i]+"结束时间是："+this.endtime[i] +'\n');
	}
}
