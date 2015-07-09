package edu.kk.sorts;

/**
 * 
 * 无交换的插入排序
 * @author KangKai
 *
 */
public class Insertion extends Sort{

	@Override
	public Sort sort(Comparable[] a) {
		int N = a.length;
		for(int i = 1; i < N; i++){
			Comparable t = a[i];
			int j = 0;
			for(j = i; j > 0 && less(t,a[j-1]); j--){
//			for(int j = i; j > 0 && less(a[j],a[j-1]); j--){
//				exch(a, j, j-1);
				a[j] = a[j-1];//向右移动
			}
			a[j] = t;
		}
		return this;
	}
	
	public static void main(String[] args) {
		Sort insertion = new Insertion();
		insertion.sort(a).showCount();
		if(!insertion.isSorted(a)){
			System.out.println("排序失败，代码有错！");
		}
		insertion.show(a);
	}

	//为优化快速排序添加的方法
	public void sort(Comparable[] a, int lo, int hi) {
		int N = hi+1;
		for(int i = lo; i < N; i++){
			Comparable t = a[i];
			int j = lo;
			for(j = i; j > lo && less(t,a[j-1]); j--){
//			for(int j = i; j > 0 && less(a[j],a[j-1]); j--){
//				exch(a, j, j-1);
				a[j] = a[j-1];//向右移动
			}
			a[j] = t;
		}
	}

}
