package edu.kk.sorts;

/**
 * 堆排序
 * @author KangKai
 *
 */
public class Heap extends Sort{

	@Override
	public Sort sort(Comparable[] pq) {
		//获得数组长度
		int N = pq.length;
		
		//构造一个有序堆
		for(int k = N/2; k >=1; k--){
			sink(pq, k, N);
		}
		
		//从堆里取出最大的元素，让数组按从小到大排序
		while(N > 1){
			//交换最大的元素到数组末尾
			exch(pq, 1, N--,1);
			//让后交换上来的元素下沉到合理的位置，即修复堆
			sink(pq, 1 ,N);
		}
		
		return this;
	}

	private void sink(Comparable[] pq, int k, int N) {
		while(2*k < N){
			//获得左子元素下标
			int j = 2 * k;
			//获得两个元素的较大那一个的下标
			if(j < N && less(pq, j, j+1))
				j++;
			//若下标为k的父元素已经比所有子元素大，则退出下沉
			if(!less(pq, k, j))
				break;
			//交换父元素和子元素的位置
			exch(pq, k, j, 1);
			//把父元素定位到子元素位置，继续下次下沉
			k = j;
		}
	}
	
	public static void main(String[] args) {
		Sort heap = new Heap();
		heap.sort(a).showCount();
		if(!heap.isSorted(a)){
			System.out.println("排序失败，代码有错！");
		}
		heap.show(a);
	}

}
