package edu.kk.sorts;

/**
 * 自顶向下的归并排序（递归方式的归并排序实现）
 * @author KangKai
 *
 */
public class Merge extends Sort{

	/**
	 * 归并所需的辅助数组,这样的静态数组并不妥当，因为可能会有多个程序同时调用这个类
	 */
	//private static Comparable[] aux;
	
	@Override
	public Sort sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a,aux,0,a.length-1);
		return this;
	}

	/**
	 * 将数组a[lo..hi]排序
	 * @param a 数组索引
	 * @param lo 最低位
	 * @param hi 最高位
	 */
	private void sort(Comparable[] a,Comparable[] aux, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a,aux,lo,mid);		//将左半边排序
		sort(a,aux,mid + 1,hi); //将右半边排序
		if(less(a[mid] ,a[mid+1])) return;//这个改进可以让任意有序的子数组算法的运行时间变成线性
		merge(a,aux,lo,mid,hi); //归并结果
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
		Sort merge = new Merge();
		merge.sort(a).showCount();
		if(!merge.isSorted(a)){
			System.out.println("排序失败，代码有错！");
		}
		merge.show(a);
	}

}
