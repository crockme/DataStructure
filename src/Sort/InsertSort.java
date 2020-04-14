package Sort;

public class InsertSort {
	static final int SIZE=5;
	public static void insertSort(int a[]) {
		int i,j,temp;
		for(i=1;i<a.length;i++) {
			j=i-1;
			temp=a[i];              //需要用temp，因为a[i]后面可能被替换掉
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
		System.out.print("排序前的数组为：");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		insertSort(a);
		System.out.print("排序后的数组为：");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
