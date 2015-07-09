package edu.kk.sorts;

/**
 * 参数 N 元素个数
 * 选择排序需要
 * 		比较：N次
 * 		交换：N平方/2次
 * @author KangKai
 *
 */
public class Selection extends Sort{

	@Override
	public Sort sort(Comparable[] a) {
		//将a[]按升序排序
		int N = a.length;
		for(int i = 0; i < N; i++){
			//将a[i]和a[i+1...N]中最小的元素交换
			int min = i;
			for(int j = i + 1; j < N; j++){
				if(less(a[j],a[min]))
					min = j;
			}
			//找到代排序列中最小的元素，与i交换
			exch(a, i, min);
		}
		return this;
	}
	public static void main(String[] args) {
		Sort selection = new Selection();
		selection.sort(a).showCount();
		if(!selection.isSorted(a)){
			System.out.println("排序失败，代码有错！");
		}
		selection.show(a);
	}
}
