package edu.kk.sorts;

/**
 * �Զ����µĹ鲢���򣨵ݹ鷽ʽ�Ĺ鲢����ʵ�֣�
 * @author KangKai
 *
 */
public class Merge extends Sort{

	/**
	 * �鲢����ĸ�������,�����ľ�̬���鲢���׵�����Ϊ���ܻ��ж������ͬʱ���������
	 */
	//private static Comparable[] aux;
	
	@Override
	public Sort sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a,aux,0,a.length-1);
		return this;
	}

	/**
	 * ������a[lo..hi]����
	 * @param a ��������
	 * @param lo ���λ
	 * @param hi ���λ
	 */
	private void sort(Comparable[] a,Comparable[] aux, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a,aux,lo,mid);		//����������
		sort(a,aux,mid + 1,hi); //���Ұ������
		if(less(a[mid] ,a[mid+1])) return;//����Ľ�����������������������㷨������ʱ��������
		merge(a,aux,lo,mid,hi); //�鲢���
	}

	/**
	 * //��a[lo..mid]��a[mid+1..hi]�鲢
	 * @param a ��������
	 * @param lo ���λ
	 * @param mid �м�λ
	 * @param hi ���λ
	 */
	private void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
		//ѡ��mergeʵ�ֵĿ��أ�Ĭ��Ϊtrue����ʹ���Ż���merge,��N�ܴ�ʱ�Ż���merge��ȽϿ�
		boolean flag = true;
		
		if(!flag){
			//δ�Ľ���mergeʵ��
			int i = lo;
			int j = mid + 1;
			
			for(int k = lo; k <= hi; k++){
				//��a[lo..hi]���Ƶ�aux[lo..hi]
				aux[k] = a[k];
			}
			
			for(int k = lo; k <= hi; k++){
				//�鲢�ص�a[lo..hi]
				if(i > mid)
					//�����þ�
					a[k] = aux[j++];
				else if(j > hi)
					//�Ұ���þ�
					a[k] = aux[i++];
				else if(less(aux[j],aux[i]))
					//�Ұ�ߵ�ǰԪ��С�����ߵ�ǰԪ��
					a[k] = aux[j++];
				else
					//�Ұ�ߵ�ǰԪ�ش������ߵ�ǰԪ��
					a[k] = aux[i++];
			}
		}
		else{
			//�Ľ���merge����ʵ�֣�������һ����ѭ����2��elseif�жϣ�����������һ������ѭ��
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
			System.out.println("����ʧ�ܣ������д�");
		}
		merge.show(a);
	}

}
