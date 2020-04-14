package DataStructure;

import java.util.Scanner;

class CBTType{
	String data;
	CBTType left;
	CBTType right;  //二叉树的链式存储
	
	static final int MAXLEN=20;
	Scanner sc=new Scanner(System.in);
	CBTType CBTInit() {
		System.out.println("请先输入一个根节点");
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
				if((ptr=TreeNode.TreeFindNode(TreeNode.left, data))!=null) {      //递归查询
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
		System.out.println("输入二叉树结点数据");
		node.data=sc.next();
		node.left=null;
		node.right=null;
		System.out.println("输入该节点的父节点数据");
		data=sc.next();
		parent=TreeFindNode(TreeNode,data);
		if(parent==null) {
			System.out.println("未找到父节点");
			node=null;
			return;
		}
		System.out.println("1.添加该结点到左子树"+"\n"+"2.添加该结点到右子树");
			i=sc.nextInt();
			if(i==1||i==2) {
				switch(i) {
				case 1:
					if(parent.left!=null) {
					System.out.println("左子树不为空");
					   }
					else {
						parent.left=node;
					}
					break;
				case 2:
					if(parent.right!=null) {
					System.out.println("右子树不为空");
					   }
					else {
						parent.right=node;
					}
					break;
				default:{
					System.out.println("无效参数");
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
			tail=(tail+1)%MAXLEN;        //设置循环队列 存储二叉树结点
			q[tail]=TreeNode;            //循环是为了数组可以重复利用
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
	void DLRTree(CBTType TreeNode) {   //先序遍历：中左右
		if(TreeNode!=null) {
		System.out.println(TreeNode.data);
		DLRTree(TreeNode.left);
		DLRTree(TreeNode.right);
		}
	}
	void LDRTree(CBTType TreeNode) {    //中序遍历：左中右
		if(TreeNode!=null) {
			LDRTree(TreeNode.left);
			System.out.println(TreeNode.data);
			LDRTree(TreeNode.right);
			}
	}
	void LRDTree(CBTType TreeNode) {    //后序遍历：左右中
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
			System.out.println("1继续添加，0退出");
		}while(cbt.sc.nextInt()!=0);
		System.out.println("先序遍历：");
		cbt.DLRTree(cbt);
		System.out.println("中序遍历：");
		cbt.LDRTree(cbt);
		System.out.println("后序遍历：");
		cbt.LRDTree(cbt);
		System.out.println("按层遍历：");
		cbt.LevelTree(cbt);
	}

}
