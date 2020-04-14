package DataStructure;

import java.util.Scanner;

class Data{
	String key;
	String name;
	int age;
}
class SLType{
	static final int MAXLEN = 3;
	Data[] ListData=new Data[MAXLEN+1];            //为了方便，数组[0]不保存数据
	int ListLen;
	void SLInit(SLType SL) {
		SL.ListLen=0;
	}
	int SLLength(SLType SL) {
		return SL.ListLen;
	}
	int SLInsert(SLType SL,int n,Data data) {      //n为插入序号
		if(SL.ListLen==MAXLEN) {                   
			System.out.println("顺序表已满，不能插入结点");
			return 0;
		}
		if(n<1||n>SL.ListLen+1) {                 //可以在末尾插入
			System.out.println("插入结点序号错误");
			return 0;
		}
		for(int i=n;i<=SL.ListLen;i++) {
			ListData[i+1]=ListData[i];      //不可使用ListData[++i]=ListData[i] 因为java语句都是从左到右运行 左右两边数组下标相等
			
		}
		SL.ListData[n]=data;
		SL.ListLen++;
		return 1;
	}
	int SLAdd(SLType SL,Data data) {
		if(SL.ListLen>=MAXLEN) {
			System.out.println("顺序表已满，不能插入结点");
			return 0;
		}
		SL.ListData[++SL.ListLen]=data;
		return 1;
	}
	int SLDelete(SLType SL,int n) {
		if(n<1||n>SL.ListLen) {
			System.out.println("插入结点序号错误");
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
			System.out.println("插入结点序号错误");
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
		System.out.println("顺序表操作演示:");
		SL.SLInit(SL);
		Scanner sc1=new Scanner(System.in);
		do {
			System.out.print("输入添加的结点（学号，姓名，年龄）:");
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
		System.out.println("顺序表中的结点：");
		SL.SLAll(SL);
		
		System.out.println("输入要插入的结点序号：");
		Data data=new Data();
		int n=sc1.nextInt();
		data.key=sc1.next();
		data.name=sc1.next();
		data.age=sc1.nextInt();
		SL.SLInsert(SL, n, data);
		System.out.println("顺序表中的结点：");
		SL.SLAll(SL);
		
		System.out.println("输入要删除的结点序号：");
	    n=sc1.nextInt();
	    sc1.close();
		SL.SLDelete(SL, n);
		System.out.println("顺序表中的结点：");
		SL.SLAll(SL);
	}

}
