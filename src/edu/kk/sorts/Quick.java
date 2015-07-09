package edu.kk.sorts;

public class Quick extends Sort{

	@Override
	public Sort sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
		return this;
	}

	private void sort(Comparable[] a, int lo, int hi) {
		//δ����С�����Ż�
//		if(hi <= lo) return; 
		//����С���飬��������Ȳ���������
		if(hi <= lo + 10){
			new Insertion().sort(a,lo,hi);
			return;
		}
		int j = partition(a, lo, hi);//�з�
		sort(a, lo, j - 1);//����벿������
		sort(a, j+1, hi);//���Ұ벿������
	}

	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while(true){
			//��λv��ߵ������б�v����±�
			while(less(a[++i],v)) if(i == hi) break;
			//��λv�ұߵ������б�vС���±�
			while(less(v,a[--j])) if(j == lo) break;
			//��i,j���������˳�ѭ������Ϊ���ҵ��зֵ㣨j��
			if(i >= j) break;
			//����ij��ʹ������������a[lo...j-1]<=a[j]<=a[j+1...hi]
			exch(a, i, j);
		}
		//ȷ����һ��Ԫ�ص�����λ��j
		exch(a, lo, j);
		return j;
	}
	public static void main(String[] args) {
		Sort quick = new Quick();
		quick.sort(a).showCount();
		if(!quick.isSorted(a)){
			System.out.println("����ʧ�ܣ������д�");
		}
		quick.show(a);
	}
}
