package Sort;

public class SelectSort {
	static final int SIZE=5;
	public static void selectSort(int a[]) {
		int index;
		int temp;
		for(int i=0;i<a.length-1;i++) {
			index=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j]<a[index]) {
					index=j;
				}
			}
			if(index!=i) {
				temp=a[i];
				a[i]=a[index];
				a[index]=temp;
			}
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
		selectSort(a);
		System.out.print("排序后的数组为：");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}


}
