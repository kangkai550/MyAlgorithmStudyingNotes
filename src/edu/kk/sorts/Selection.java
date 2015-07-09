package edu.kk.sorts;

/**
 * ���� N Ԫ�ظ���
 * ѡ��������Ҫ
 * 		�Ƚϣ�N��
 * 		������Nƽ��/2��
 * @author KangKai
 *
 */
public class Selection extends Sort{

	@Override
	public Sort sort(Comparable[] a) {
		//��a[]����������
		int N = a.length;
		for(int i = 0; i < N; i++){
			//��a[i]��a[i+1...N]����С��Ԫ�ؽ���
			int min = i;
			for(int j = i + 1; j < N; j++){
				if(less(a[j],a[min]))
					min = j;
			}
			//�ҵ�������������С��Ԫ�أ���i����
			exch(a, i, min);
		}
		return this;
	}
	public static void main(String[] args) {
		Sort selection = new Selection();
		selection.sort(a).showCount();
		if(!selection.isSorted(a)){
			System.out.println("����ʧ�ܣ������д�");
		}
		selection.show(a);
	}
}
