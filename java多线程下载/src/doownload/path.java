package doownload;

public class path {
	public String downloadpath; //����·��
	public String depositpath; //���·��
	
	public void setdownloadpath(String Downloadpath) //��д����·��
	{
		this.downloadpath=Downloadpath;
	}
	
	public void setdepositpath(String Depositpath) //��д���·��
	{
		this.depositpath=Depositpath;
	}
	
	public void getdownloadpath() //��ӡ����·��
	{
		System.out.print("����ʹ�õ�URL�ǣ�"+this.downloadpath +"\n");
	}
	
	public void getdepositpath() //��ӡ���·��
	{
		System.out.print("���·���ǣ�"+this.depositpath +"\n");
	}
	

}
