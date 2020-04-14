package DataStructure;

import java.util.Scanner;

class Data4{
	String key;
	String name;
	int age;
}
class QueueType{
	static final int MAXLEN=3;
	Data4[] data=new Data4[MAXLEN];
	int head;
	int tail;
	
	QueueType QueueInit(){
		QueueType q=new QueueType();
		q.head=0;
		q.tail=0;
		return q;
	}
	int QueueIn(QueueType q,Data4 data){
		if(q.tail==MAXLEN) {
			System.out.println("队列已满");
			return 0;
		}
		q.data[tail++]=data;
		return 1;
	}
	Data4 QueueOut(QueueType q) {
		if(q.head==q.tail) {
			System.out.println("队列已空");
			return null;
		}
		return q.data[head++];
	}
	void ALL(QueueType q) {
		int i=q.tail-1;
		if(q.head==q.tail) {
			System.out.println("队列已空");
	    }
		while(i>=q.head) {
			System.out.printf("(%s,%s,%d)\n", q.data[i].key,q.data[i].name,q.data[i].age);
			i--;
		}
	}	
}
public class Queue {
	public static void main(String[] args) {
		QueueType queue=new QueueType();
		queue=queue.QueueInit();
		Scanner sc1=new Scanner(System.in);
		do {
			System.out.print("输入进队的结点（学号，姓名，年龄）:");
			Data4 data=new Data4();
			data.key=sc1.next();
			data.name=sc1.next();
			data.age=sc1.nextInt();
			if(data.age!=0) {
				if(queue.QueueIn(queue, data)==0)
					break;
			}
			else {
				break;
			}
		}while(true);
		System.out.println("队列中的结点为");
		queue.ALL(queue);
		
		while(sc1.next().equals("out")){
	    System.out.println("进行一次出队操作");
	    Data4 data=new Data4();
	    data=queue.QueueOut(queue);
	    System.out.printf("出栈元素为：(%s,%s,%d)\n",data.key,data.name,data.age);
	    System.out.println("栈内元素为");
	    queue.ALL(queue);
		}
	}

}
