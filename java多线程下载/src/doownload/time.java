package doownload;
import java.text.SimpleDateFormat;
import java.util.Date; //����ʱ���
public class time {
	public  String[] starttime=new String[global.quantity]; //��ʼʱ��
	public  String[] endtime=new String[global.quantity]; //����ʱ��
	public  String[] estimatetime=new String[global.quantity]; //Ԥ��ʱ��
	
	   public String formattime(Date dNow) { //��ʽ��ʱ���ʽΪ��-��-��-ʱ-��-��
		   
		     SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		 
		     // System.out.println("��ǰʱ��Ϊ: " + ft.format(dNow));
		      return ft.format(dNow);
		   }
	
	
	public void setstarttime() //ʱ��
	{
		 Date date = new Date();
		 //����ʼ����ʱ����ȡһ��ʱ����Ϊ��ʼʱ��
		 for(int i=0;i<global.downnumber;i++)
		 this.starttime[i]=formattime(date);

				 
	}
	
	public void setendtime() //ʱ��
	{
		 Date date = new Date();
	
		//����������ʱ����ȡһ��ʱ����Ϊ����ʱ��
		 for(int i=0;i<global.downnumber;i++)
		 this.endtime[i] =formattime(date);
		 //Ԥ��ʱ��=ʣ���ļ���С/��ǰ�����ٶ�
		 
	}
	
	public void getstarttime(int i) //��ӡ��ʼʱ��
	{
		
	 System.out.print(global.filename[i]+'.'+global.filetype[i]+"��ʼʱ���ǣ�"+this.starttime[i] +'\n');
	}
	
	public void getendtime(int i) //��ӡ����ʱ��
	{
		
	 System.out.print(global.filename[i]+'.'+global.filetype[i]+"����ʱ���ǣ�"+this.endtime[i] +'\n');
	}
}
