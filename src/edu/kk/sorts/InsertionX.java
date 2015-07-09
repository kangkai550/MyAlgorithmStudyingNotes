package edu.kk.sorts;

/**
 * 带哨兵的插入排序，这是一种常见的规避边界测试的方法
 * @author KangKai
 *
 */
public class InsertionX extends Sort{

	@Override
	public Sort sort(Comparable[] a) {
		int N = a.length;

        // put smallest element in position to serve as sentinel
        for (int i = N-1; i > 0; i--)
            if (less(a[i], a[i-1])) exch(a, i, i-1);

        // insertion sort with half-exchanges
        for (int i = 2; i < N; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j-1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }
		return this;
	}

}
