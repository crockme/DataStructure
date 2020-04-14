package DataStructure;

import java.util.Scanner;

class Data3{
	String key;
	String name;
	int age;
}
class StackType{
	static final int MAXLEN=5;
	Data3[] data=new Data3[MAXLEN+1];    //data[0]不存储
	int top;
	
	StackType STInit() {
		StackType s=new StackType();
			s.top=0;
			return s;
	}
	int Push(StackType s,Data3 data) {
		if(s.top==MAXLEN) {
			System.out.println("栈溢出");
			return 0;
		}
		s.data[++s.top]=data;
		return 1;
	}
	Data3 Pop(StackType s) {
		if(s.top==0) {
			System.out.println("栈已空");
		}
		return s.data[top--];
	}
	void All(StackType s) {
		int i=s.top;
		if(s.top==0) {
			System.out.println("栈已空");
		}
		while(i!=0) {
			System.out.printf("(%s,%s,%d)\n",s.data[i].key,s.data[i].name,s.data[i].age);
			i--;
			}
	}
}
public class Stack {
	public static void main(String[] args) {
	    StackType stack=new StackType();
	    stack=stack.STInit();
	    Scanner sc1=new Scanner(System.in);
	    do {
			System.out.print("输入进栈的元素（学号，姓名，年龄）:");
			Data3 data=new Data3();
			data.key=sc1.next();
			data.name=sc1.next();
			data.age=sc1.nextInt();
			if(data.age!=0) {
				if(stack.Push(stack, data)==0)
					break;
			}
			else {
				break;
			}
		}while(true);
	    
	    System.out.println("栈内元素为");
	    stack.All(stack);
	    
	    while(sc1.next().equals("pop")) {
	    System.out.println("进行一次出栈操作");
	    Data3 data=new Data3();
	    data=stack.Pop(stack);
	    System.out.printf("出栈元素为：(%s,%s,%d)\n",data.key,data.name,data.age);
	    System.out.println("栈内元素为");
	    stack.All(stack);
	    }
	    sc1.close();
	}
}
