package edu.kk.sorts;

/**
 * 自底向上的归并排序（归并排序的非递归实现）
 * @author KangKai
 *
 */
public class MergeBU extends Sort{


	/**
	 * 归并所需的辅助数组,这样的静态数组并不妥当，因为可能会有多个程序同时调用这个类
	 */
	//private static Comparable[] aux;
	
	@Override
	public Sort sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a,aux);
		return this;
	}
	
	/**
	 * 将数组a[lo..hi]排序
	 * 
	 */
	
	public void sort(Comparable[] a,Comparable[] aux) {
		//进行lgN次两两归并
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1; sz < N; sz = sz+sz) //sz:子数组大小,每次加倍
			for(int lo = 0; lo < N - sz; lo += (sz+sz))//lo:子数组索引,lo=lo+2sz的意思是lo移动到下一个数组的最低位
				merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));//防止数组长度N为基数时数组越界
	}

	/**
	 * //将a[lo..mid]和a[mid+1..hi]归并
	 * @param a 数组索引
	 * @param lo 最低位
	 * @param mid 中间位
	 * @param hi 最高位
	 */
	private void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
		//选择merge实现的开关，默认为true，即使用优化的merge,当N很大时优化的merge会比较快
		boolean flag = true;
		
		if(!flag){
			//未改进的merge实现
			int i = lo;
			int j = mid + 1;
			
			for(int k = lo; k <= hi; k++){
				//将a[lo..hi]复制到aux[lo..hi]
				aux[k] = a[k];
			}
			
			for(int k = lo; k <= hi; k++){
				//归并回到a[lo..hi]
				if(i > mid)
					//左半边用尽
					a[k] = aux[j++];
				else if(j > hi)
					//右半边用尽
					a[k] = aux[i++];
				else if(less(aux[j],aux[i]))
					//右半边当前元素小于左半边当前元素
					a[k] = aux[j++];
				else
					//右半边当前元素大于左半边当前元素
					a[k] = aux[i++];
			}
		}
		else{
			//改进的merge方法实现，减少了一次内循环的2次elseif判断，但是增加了一次线性循环
			for (int i = lo; i <= mid; i++)
			      aux[i] = a[i]; 
			   
			   for (int j = mid+1; j <= hi; j++)
			      aux[j] = a[hi-j+mid+1];
			  
			   int i = lo, j = hi; 
			   for (int k = lo; k <= hi; k++) 
			      if (less(aux[j], aux[i])) a[k] = aux[j--];
			      else                      a[k] = aux[i++];
		}
	}
	public static void main(String[] args) {
		Sort mergeBU = new MergeBU();
		mergeBU.sort(a).showCount();
		if(!mergeBU.isSorted(a)){
			System.out.println("排序失败，代码有错！");
		}
		mergeBU.show(a);
	}

}
