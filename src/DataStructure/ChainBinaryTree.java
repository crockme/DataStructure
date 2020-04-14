package DataStructure;

import java.util.Scanner;

class CBTType{
	String data;
	CBTType left;
	CBTType right;  //����������ʽ�洢
	
	static final int MAXLEN=20;
	Scanner sc=new Scanner(System.in);
	CBTType CBTInit() {
		System.out.println("��������һ�����ڵ�");
		CBTType node=new CBTType();
		node.data=sc.next();
		node.left=null;
		node.right=null;
		if(node!=null) {
			return node;
		}
		else
			return null;
	}
	CBTType TreeFindNode(CBTType TreeNode,String data) {
		CBTType ptr;
		if(TreeNode==null) {
			return null;
		}
		else {
			if(TreeNode.data.equals(data)) {
				return TreeNode;
			}
			else {
				if((ptr=TreeNode.TreeFindNode(TreeNode.left, data))!=null) {      //�ݹ��ѯ
					return ptr;
				}else if((ptr=TreeNode.TreeFindNode(TreeNode.right, data))!=null){
					return ptr;
				}
				else {
					return null;
				}
			}
		}
	}
	void AddTreeNode(CBTType TreeNode){
		CBTType node=new CBTType();
		CBTType parent;
		String data;
		int i;
		System.out.println("����������������");
		node.data=sc.next();
		node.left=null;
		node.right=null;
		System.out.println("����ýڵ�ĸ��ڵ�����");
		data=sc.next();
		parent=TreeFindNode(TreeNode,data);
		if(parent==null) {
			System.out.println("δ�ҵ����ڵ�");
			node=null;
			return;
		}
		System.out.println("1.��Ӹý�㵽������"+"\n"+"2.��Ӹý�㵽������");
			i=sc.nextInt();
			if(i==1||i==2) {
				switch(i) {
				case 1:
					if(parent.left!=null) {
					System.out.println("��������Ϊ��");
					   }
					else {
						parent.left=node;
					}
					break;
				case 2:
					if(parent.right!=null) {
					System.out.println("��������Ϊ��");
					   }
					else {
						parent.right=node;
					}
					break;
				default:{
					System.out.println("��Ч����");
				}
				}
			}
	}
	int TreeDepth(CBTType TreeNode) {
		int depleft,depright;
		if(TreeNode==null) {
			return 0;
		}
		depleft=TreeDepth(TreeNode.left);
		depright=TreeDepth(TreeNode.right);
		if(depleft>depright) {
			return depleft+1;
		}
		else
			return depright+1;
	}
	void LevelTree(CBTType TreeNode) {
		CBTType p;
		CBTType[] q=new CBTType[MAXLEN];
		int head=0,tail=0;
		if(TreeNode!=null) {
			tail=(tail+1)%MAXLEN;        //����ѭ������ �洢���������
			q[tail]=TreeNode;            //ѭ����Ϊ����������ظ�����
		}
		while(head!=tail) {
			head=(head+1)%MAXLEN;
			p=q[head];
			System.out.println(p.data);
			if(p.left!=null) {
				tail=(tail+1)%MAXLEN;
				q[tail]=p.left;
			}
			if(p.right!=null) {
				tail=(tail+1)%MAXLEN;
				q[tail]=p.right;
			}
		}
	}
	void DLRTree(CBTType TreeNode) {   //���������������
		if(TreeNode!=null) {
		System.out.println(TreeNode.data);
		DLRTree(TreeNode.left);
		DLRTree(TreeNode.right);
		}
	}
	void LDRTree(CBTType TreeNode) {    //���������������
		if(TreeNode!=null) {
			LDRTree(TreeNode.left);
			System.out.println(TreeNode.data);
			LDRTree(TreeNode.right);
			}
	}
	void LRDTree(CBTType TreeNode) {    //���������������
		if(TreeNode!=null) {
			LRDTree(TreeNode.left);
			LRDTree(TreeNode.right);
			System.out.println(TreeNode.data);
			}
	}
}
public class ChainBinaryTree {
	public static void main(String[] args) {
		CBTType cbt=new CBTType();
		cbt=cbt.CBTInit();
		do {
			cbt.AddTreeNode(cbt);
			System.out.println("1������ӣ�0�˳�");
		}while(cbt.sc.nextInt()!=0);
		System.out.println("���������");
		cbt.DLRTree(cbt);
		System.out.println("���������");
		cbt.LDRTree(cbt);
		System.out.println("���������");
		cbt.LRDTree(cbt);
		System.out.println("���������");
		cbt.LevelTree(cbt);
	}

}
