package doownload;

public class path {
	public String[] downloadpath=new String[10]; //����·��
	public String[] depositpath=new String[10]; //���·��
		
	public void setdownloadpath(String[] Downloadpath) //��д����·��
	{
		for(int i=0;i<global.downnumber;i++)
		this.downloadpath[i]=Downloadpath[i];
	}
	
	public void setdepositpath(String[] Depositpath) //��д���·��
	{
		for(int i=0;i<global.downnumber;i++)
		this.depositpath[i]=Depositpath[i];
	}
	
	public void getdownloadpath() //��ӡ����·��
	{
		for(int i=0;i<global.downnumber;i++)
		System.out.print(global.filename[i]+'.'+global.filetype[i]+"����ʹ�õ�URL�ǣ�"+this.downloadpath[i] +"\n");
	}
	
	public void getdepositpath() //��ӡ���·��
	{
		for(int i=0;i<global.downnumber;i++)
		System.out.print(global.filename[i]+'.'+global.filetype[i]+"���·���ǣ�"+this.depositpath[i] +"\n");
	}
	

}
