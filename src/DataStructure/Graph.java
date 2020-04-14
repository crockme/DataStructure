package DataStructure;

import java.util.Scanner;

class GraphMatrix{
	static final int MAXNUM=20;
	int GType;  //图的类型，0无向图，1有向图
	char[] Vertex=new char[MAXNUM];   //保存顶点信息;
	int VertexNum;      //顶点数
	int EdgeNum;        //边数
	int[][]EdgeWeight=new int[MAXNUM][MAXNUM];  //保存边的权值
	int[]isTrav=new int[MAXNUM];    //遍历标志
	
	void CreateGragh(GraphMatrix GM) {
		char EstartV,EendV;
		int weight;
		int i,j;
		Scanner sc=new Scanner(System.in);
		System.out.println("输入生成图的类型");
		GM.GType=sc.nextInt();
		System.out.println("输入图的顶点数");
		GM.VertexNum=sc.nextInt();
		System.out.println("输入图的边数");
		GM.EdgeNum=sc.nextInt();
		System.out.println("输入图中各顶点信息");
		for(int k=0;k<GM.VertexNum;k++) {
			System.out.printf("第%d个顶点：",k+1);
			Vertex[k]=sc.next().charAt(0);
		}
		System.out.println("输入各边顶点及其权值");
		for(int k=1;k<=GM.EdgeNum;k++) {
			System.out.printf("第%d条边：",k);
			EstartV=sc.next().charAt(0);
			EendV=sc.next().charAt(0);
			weight=sc.nextInt();
			for(i=0;EstartV!=GM.Vertex[i];i++) {
			}
			for(j=0;EendV!=GM.Vertex[j];j++) {
			}
			GM.EdgeWeight[i][j]=weight;
			if(GM.GType==0) {
				GM.EdgeWeight[j][i]=weight;
			}
		}
	}
	void PrintGraph(GraphMatrix GM) {
		System.out.println("该图的邻接矩阵数值如下：");
		for(int i=0;i<GM.VertexNum;i++) {
			System.out.printf("\t%c",Vertex[i]);
		}
		System.out.println();
		for(int i=0;i<GM.VertexNum;i++) {
			System.out.print(GM.Vertex[i]);
			for(int j=0;j<GM.VertexNum;j++) {
			System.out.printf("\t%d",GM.EdgeWeight[i][j]);
			}
			System.out.println();
		}
		
	}
	void DeepTraOne(GraphMatrix GM,int n) {
		GM.isTrav[n]=1;
		System.out.print("->"+GM.Vertex[n]);
		for(int i=0;i<GM.VertexNum;i++) {
			if(GM.EdgeWeight[n][i]!=0&&GM.isTrav[i]==0) {
					DeepTraOne(GM, i);
			}
		}
	}
	void DeepTraGraph(GraphMatrix GM) {
		System.out.println("深度优先遍历：");
		for(int i=0;i<GM.VertexNum;i++) {
			GM.isTrav[i]=0;
		}
		for(int i=0;i<GM.VertexNum;i++) {
			if(GM.isTrav[i]==0) {
			DeepTraOne(GM, i);
			}
		}
	}
}
public class Graph {
	public static void main(String[] args) {
		GraphMatrix GM=new GraphMatrix();
		GM.CreateGragh(GM);
		GM.PrintGraph(GM);
		GM.DeepTraGraph(GM);
	}

}
