package Sort;

public class BubbleSort {
	static final int SIZE=5;
	public static void bubbleSort(int a[]) {
		int temp;
		for(int i=1;i<a.length;i++) {         //����SIZE-1�Σ���Ϊ���һ���Զ��ź�
			for(int j=0;j<a.length-1;j++) {   
				if(a[j]>a[j+1]) {
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] a=new int[SIZE];
		for(int i=0;i<a.length;i++) {
			a[i]=(int)(Math.random()*100);
		}
		System.out.print("����ǰ������Ϊ��");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		bubbleSort(a);
		System.out.print("����������Ϊ��");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
