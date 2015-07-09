package edu.kk.sorts;

public class Quick3way extends Sort{

	
	@Override
	public Sort sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
		return this;
	}
	
	public void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo)
			return;
		int lt = lo, i = lo+1, gt = hi;
		Comparable v = a[lo];
	}
}
