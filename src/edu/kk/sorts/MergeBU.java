package edu.kk.sorts;

/**
 * �Ե����ϵĹ鲢���򣨹鲢����ķǵݹ�ʵ�֣�
 * @author KangKai
 *
 */
public class MergeBU extends Sort{


	/**
	 * �鲢����ĸ�������,�����ľ�̬���鲢���׵�����Ϊ���ܻ��ж������ͬʱ���������
	 */
	//private static Comparable[] aux;
	
	@Override
	public Sort sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a,aux);
		return this;
	}
	
	/**
	 * ������a[lo..hi]����
	 * 
	 */
	
	public void sort(Comparable[] a,Comparable[] aux) {
		//����lgN�������鲢
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1; sz < N; sz = sz+sz) //sz:�������С,ÿ�μӱ�
			for(int lo = 0; lo < N - sz; lo += (sz+sz))//lo:����������,lo=lo+2sz����˼��lo�ƶ�����һ����������λ
				merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));//��ֹ���鳤��NΪ����ʱ����Խ��
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
		Sort mergeBU = new MergeBU();
		mergeBU.sort(a).showCount();
		if(!mergeBU.isSorted(a)){
			System.out.println("����ʧ�ܣ������д�");
		}
		mergeBU.show(a);
	}

}
