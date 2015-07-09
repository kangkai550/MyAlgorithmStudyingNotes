package edu.kk.sorts;

/**
 * 希尔排序，是在插入排序的基础上优化
 * 		把插入排序循环体中的1改成h增量就行
 * @author KangKai
 *
 */
public class Shell extends Sort{

	@Override
	public Sort sort(Comparable[] a) {
		 int N = a.length;

	        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
	        int h = 1;
	        while (h < N/3) h = 3*h + 1; //选定初始h

	        while (h >= 1) {
	            // h-sort the array
	            for (int i = h; i < N; i++) {
	                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
	                    exch(a, j, j-h);
	                }
	            }
	            h /= 3;
	        }
		return this;
	}

}
