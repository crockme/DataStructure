package DataStructure;

import java.util.Scanner;

class Data2{
	String key;
	String name;
	int age;
}
class LLType{
	Data2 data=new Data2();
	LLType nextNode;
	
	LLType LLAdd(LLType head,Data2 data) {
		LLType node=new LLType();
		LLType temp;
	    	node.data=data;
	    	node.nextNode=null;  //初始化结点 node
	    	if(head.nextNode==null) {
	    		head.nextNode=node;
	    		return head;
	    	}
	    	temp=head.nextNode;
	    	while(temp.nextNode!=null) {
	    		temp=temp.nextNode;
	    	}
	    	temp.nextNode=node;
	    	return head;
	}
	LLType LLFindNode(LLType head,String key) {           //找到目标节点的前一个
		LLType temp;
		temp=head;
		while(temp!=null) {
			if(temp.nextNode.data.key.equals(key)) {
				return temp;
			}
			temp=temp.nextNode;
		}
		return null;
	}
	LLType LLInsert(LLType head,String key,Data2 data) {
		LLType node =new LLType(),temp;
		 node.data=data;
		 temp=LLFindNode(head,key);
		 if(temp!=null) {
			 node.nextNode=temp.nextNode;
			 temp.nextNode=node;
		 }
		 else {
			 System.out.println("未找到正确位置");
		 }
		 return head;
	}
	int LLDeleteNode(LLType head,String key) {
		LLType node=new LLType(),temp;
		temp=head.nextNode;
		node=head.nextNode;
		while(temp!=null) {
			if(temp.data.key.equals(key)) {
				node.nextNode=temp.nextNode;       //node是前一结点，temp是当前结点
				return 1;
		    }
			else {
				node=temp;
				temp=temp.nextNode;
			}
		}
	return 0;
	}
	int LLLength(LLType head) {
		LLType temp;
		int Len=0;
		temp=head;
		while(temp!=null) {
			Len++;
			temp=temp.nextNode;
		}
		return Len;
	}
	void LLALL(LLType head) {
		LLType temp;
		temp=head.nextNode;
		while(temp!=null) {
			System.out.printf("(%s,%s,%d)\n", temp.data.key,temp.data.name,temp.data.age);
			temp=temp.nextNode;
		}
	}
}
	


public class LinkList {
	public static void main(String[] args) {
		LLType head=new LLType();
		head.nextNode=null;
		Scanner sc1=new Scanner(System.in);
		do {
			System.out.print("输入添加的结点（学号，姓名，年龄）:");
			Data2 data=new Data2();
			data.key=sc1.next();
			data.name=sc1.next();
			data.age=sc1.nextInt();
			if(data.age==0) {
					break;
			}
			else {
				head=head.LLAdd(head, data);
			}
		}while(true);
		System.out.println("链表中的结点为");
		head.LLALL(head);
		
		System.out.println("输入插入结点关键字");
		String findkey=sc1.next();
		System.out.print("输入添加的结点（学号，姓名，年龄）:");
		Data2 data=new Data2();
		data.key=sc1.next();
		data.name=sc1.next();
		data.age=sc1.nextInt();
		head.LLInsert(head, findkey, data);
		System.out.println("链表中的结点为");
		head.LLALL(head);
		
		System.out.println("输入删除结点关键字");
		findkey=sc1.next();
		head.LLDeleteNode(head, findkey);
		System.out.println("链表中的结点为");
		head.LLALL(head);
		sc1.close();
	}
}

