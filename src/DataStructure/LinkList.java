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
	    	node.nextNode=null;  //��ʼ����� node
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
	LLType LLFindNode(LLType head,String key) {           //�ҵ�Ŀ��ڵ��ǰһ��
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
			 System.out.println("δ�ҵ���ȷλ��");
		 }
		 return head;
	}
	int LLDeleteNode(LLType head,String key) {
		LLType node=new LLType(),temp;
		temp=head.nextNode;
		node=head.nextNode;
		while(temp!=null) {
			if(temp.data.key.equals(key)) {
				node.nextNode=temp.nextNode;       //node��ǰһ��㣬temp�ǵ�ǰ���
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
			System.out.print("������ӵĽ�㣨ѧ�ţ����������䣩:");
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
		System.out.println("�����еĽ��Ϊ");
		head.LLALL(head);
		
		System.out.println("���������ؼ���");
		String findkey=sc1.next();
		System.out.print("������ӵĽ�㣨ѧ�ţ����������䣩:");
		Data2 data=new Data2();
		data.key=sc1.next();
		data.name=sc1.next();
		data.age=sc1.nextInt();
		head.LLInsert(head, findkey, data);
		System.out.println("�����еĽ��Ϊ");
		head.LLALL(head);
		
		System.out.println("����ɾ�����ؼ���");
		findkey=sc1.next();
		head.LLDeleteNode(head, findkey);
		System.out.println("�����еĽ��Ϊ");
		head.LLALL(head);
		sc1.close();
	}
}

