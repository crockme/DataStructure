package DataStructure;

import java.util.Scanner;

class Data{
	String key;
	String name;
	int age;
}
class SLType{
	static final int MAXLEN = 3;
	Data[] ListData=new Data[MAXLEN+1];            //Ϊ�˷��㣬����[0]����������
	int ListLen;
	void SLInit(SLType SL) {
		SL.ListLen=0;
	}
	int SLLength(SLType SL) {
		return SL.ListLen;
	}
	int SLInsert(SLType SL,int n,Data data) {      //nΪ�������
		if(SL.ListLen==MAXLEN) {                   
			System.out.println("˳������������ܲ�����");
			return 0;
		}
		if(n<1||n>SL.ListLen+1) {                 //������ĩβ����
			System.out.println("��������Ŵ���");
			return 0;
		}
		for(int i=n;i<=SL.ListLen;i++) {
			ListData[i+1]=ListData[i];      //����ʹ��ListData[++i]=ListData[i] ��Ϊjava��䶼�Ǵ��������� �������������±����
			
		}
		SL.ListData[n]=data;
		SL.ListLen++;
		return 1;
	}
	int SLAdd(SLType SL,Data data) {
		if(SL.ListLen>=MAXLEN) {
			System.out.println("˳������������ܲ�����");
			return 0;
		}
		SL.ListData[++SL.ListLen]=data;
		return 1;
	}
	int SLDelete(SLType SL,int n) {
		if(n<1||n>SL.ListLen) {
			System.out.println("��������Ŵ���");
			return 0;
		}
		for(int i=n;i<SL.ListLen;i++) {
			SL.ListData[i]=SL.ListData[i++];
		}
		SL.ListLen--;
		return 1;	
	}
	Data SLFindByNum(SLType SL,int n) {
		if(n<1||n>SL.ListLen) {
			System.out.println("��������Ŵ���");
			return null;
		}
		return ListData[n];
	}
	int SLFindByKey(SLType SL,String key) {
		for(int i=1;i<=SL.ListLen;i++) {
			if(SL.ListData[i].key==key) {
				return i;
			}
		}
		return 0;
	}
	int SLAll(SLType SL) {
		for(int i=1;i<=SL.ListLen;i++) {
			System.out.printf("(%s,%s,%d)\n",SL.ListData[i].key,SL.ListData[i].name,SL.ListData[i].age);
			}
		return 0;
	}
}
public class SequentialList {
	public static void main(String[] args) {
		SLType SL=new SLType();
		System.out.println("˳��������ʾ:");
		SL.SLInit(SL);
		Scanner sc1=new Scanner(System.in);
		do {
			System.out.print("������ӵĽ�㣨ѧ�ţ����������䣩:");
			Data data=new Data();
			data.key=sc1.next();
			data.name=sc1.next();
			data.age=sc1.nextInt();
			if(data.age!=0) {
				if(SL.SLAdd(SL, data)==0) {
					break;
				}
			}
			else {
				break;
			}
		}while(true);
		System.out.println("˳����еĽ�㣺");
		SL.SLAll(SL);
		
		System.out.println("����Ҫ����Ľ����ţ�");
		Data data=new Data();
		int n=sc1.nextInt();
		data.key=sc1.next();
		data.name=sc1.next();
		data.age=sc1.nextInt();
		SL.SLInsert(SL, n, data);
		System.out.println("˳����еĽ�㣺");
		SL.SLAll(SL);
		
		System.out.println("����Ҫɾ���Ľ����ţ�");
	    n=sc1.nextInt();
	    sc1.close();
		SL.SLDelete(SL, n);
		System.out.println("˳����еĽ�㣺");
		SL.SLAll(SL);
	}

}
