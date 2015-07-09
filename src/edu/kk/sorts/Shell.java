package edu.kk.sorts;

/**
 * ϣ���������ڲ�������Ļ������Ż�
 * 		�Ѳ�������ѭ�����е�1�ĳ�h��������
 * @author KangKai
 *
 */
public class Shell extends Sort{

	@Override
	public Sort sort(Comparable[] a) {
		 int N = a.length;

	        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
	        int h = 1;
	        while (h < N/3) h = 3*h + 1; //ѡ����ʼh

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
