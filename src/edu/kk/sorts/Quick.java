package edu.kk.sorts;

public class Quick extends Sort{

	@Override
	public Sort sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
		return this;
	}

	private void sort(Comparable[] a, int lo, int hi) {
		//未进行小数组优化
//		if(hi <= lo) return; 
		//对于小数组，快速排序比插入排序慢
		if(hi <= lo + 10){
			new Insertion().sort(a,lo,hi);
			return;
		}
		int j = partition(a, lo, hi);//切分
		sort(a, lo, j - 1);//将左半部分排序
		sort(a, j+1, hi);//将右半部分排序
	}

	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while(true){
			//定位v左边的序列中比v大的下标
			while(less(a[++i],v)) if(i == hi) break;
			//定位v右边的序列中比v小的下标
			while(less(v,a[--j])) if(j == lo) break;
			//若i,j相遇，则退出循环，因为已找到切分点（j）
			if(i >= j) break;
			//交换ij，使序列满足条件a[lo...j-1]<=a[j]<=a[j+1...hi]
			exch(a, i, j);
		}
		//确定了一个元素的最终位置j
		exch(a, lo, j);
		return j;
	}
	public static void main(String[] args) {
		Sort quick = new Quick();
		quick.sort(a).showCount();
		if(!quick.isSorted(a)){
			System.out.println("排序失败，代码有错！");
		}
		quick.show(a);
	}
}
