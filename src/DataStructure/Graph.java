package DataStructure;

import java.util.Scanner;

class GraphMatrix{
	static final int MAXNUM=20;
	int GType;  //ͼ�����ͣ�0����ͼ��1����ͼ
	char[] Vertex=new char[MAXNUM];   //���涥����Ϣ;
	int VertexNum;      //������
	int EdgeNum;        //����
	int[][]EdgeWeight=new int[MAXNUM][MAXNUM];  //����ߵ�Ȩֵ
	int[]isTrav=new int[MAXNUM];    //������־
	
	void CreateGragh(GraphMatrix GM) {
		char EstartV,EendV;
		int weight;
		int i,j;
		Scanner sc=new Scanner(System.in);
		System.out.println("��������ͼ������");
		GM.GType=sc.nextInt();
		System.out.println("����ͼ�Ķ�����");
		GM.VertexNum=sc.nextInt();
		System.out.println("����ͼ�ı���");
		GM.EdgeNum=sc.nextInt();
		System.out.println("����ͼ�и�������Ϣ");
		for(int k=0;k<GM.VertexNum;k++) {
			System.out.printf("��%d�����㣺",k+1);
			Vertex[k]=sc.next().charAt(0);
		}
		System.out.println("������߶��㼰��Ȩֵ");
		for(int k=1;k<=GM.EdgeNum;k++) {
			System.out.printf("��%d���ߣ�",k);
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
		System.out.println("��ͼ���ڽӾ�����ֵ���£�");
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
		System.out.println("������ȱ�����");
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
