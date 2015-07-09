package edu.kk.sorts;

import edu.kk.utils.StdOut;

/**
 * 这是一个排序算法的抽象类模版，所有排序类可以继承此类，重写sort实现不同排序
 * 适用于任何实现了Comparable接口的数据类型
 * @author KangKai
 *
 */
public abstract class Sort {
	
	public  long compareCount = 0;
	public  long exchCount = 0;
	
	public static String[] a = {"S","O","R","T","E","X","A","M","P","L","E"};//随机序
//	public static String[] a = {"M","N","L","K","J","I","H","G","F","E","D","C","B","A"};//逆序测试数据
//	public static String[] a = {"D","C","B","A"};
//	public static String[] a = {"A","A","A","A","A","A","A","A","A","A"};//主键相同序列
//	public static String[] a = {"A","B","A","A","B","A","B","B","B","A","B","A","B","B","A","A","B","A","A","B"};//只有两种主键序列，且出现概率相同	
	/**
	 * 抽象的排序方法，由继承此类的子类重写
	 * @param a
	 */
	public abstract Sort sort(Comparable[] a);
	
	/**
	 * 这是一个比较函数
	 * 如果v比w小就返回true
	 * @param v
	 * @param w
	 * @return
	 */
	public  boolean less(Comparable v, Comparable w){
		compareCount++;
		return v.compareTo(w) < 0;
	}
	
	/**
	 * 这是一个比较函数
	 * @param pq
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }
	
	/**
	 * 这个函数用于将元素交换位置
	 * @param a
	 * @param i
	 * @param j
	 */
	public  void exch(Comparable[] a,int i ,int j){
		exchCount++;
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/**
	 * 这个函数用于交换数组内两元素位置,专用于堆排
	 * @param pq
	 * @param i
	 * @param j
	 */
	public void exch(Object[] pq, int i, int j,int flag) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
	
	/**
	 * 输出数组
	 * @param a
	 */
	public  void show(Comparable[] a){
		//在单行中打印数组
		for(int i = 0; i < a.length; i++){
			StdOut.print(a[i] + "");
		}
	}
	
	/**
	 * 测试元素是否有序
	 * @param a
	 * @return
	 */
	public  boolean isSorted(Comparable[] a){
		for(int i = 1; i < a.length; i++){
			if(less(a[i],a[i-1])){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 获得交换和比较的次数
	 */
	public void showCount(){
		System.out.println(this.getClass().getSimpleName()+"排序：交换了" + exchCount + "次，比较了" + compareCount + "次");
	}
}
