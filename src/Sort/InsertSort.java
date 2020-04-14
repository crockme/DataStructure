package Sort;

public class InsertSort {
	static final int SIZE=5;
	public static void insertSort(int a[]) {
		int i,j,temp;
		for(i=1;i<a.length;i++) {
			j=i-1;
			temp=a[i];              //��Ҫ��temp����Ϊa[i]������ܱ��滻��
			while(j>=0&&a[j]>a[i]) {
				a[j+1]=a[j];
				j--;	
			}
			a[j+1]=temp;
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
		insertSort(a);
		System.out.print("����������Ϊ��");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
