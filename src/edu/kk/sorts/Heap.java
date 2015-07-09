package edu.kk.sorts;

/**
 * ������
 * @author KangKai
 *
 */
public class Heap extends Sort{

	@Override
	public Sort sort(Comparable[] pq) {
		//������鳤��
		int N = pq.length;
		
		//����һ�������
		for(int k = N/2; k >=1; k--){
			sink(pq, k, N);
		}
		
		//�Ӷ���ȡ������Ԫ�أ������鰴��С��������
		while(N > 1){
			//��������Ԫ�ص�����ĩβ
			exch(pq, 1, N--,1);
			//�ú󽻻�������Ԫ���³��������λ�ã����޸���
			sink(pq, 1 ,N);
		}
		
		return this;
	}

	private void sink(Comparable[] pq, int k, int N) {
		while(2*k < N){
			//�������Ԫ���±�
			int j = 2 * k;
			//�������Ԫ�صĽϴ���һ�����±�
			if(j < N && less(pq, j, j+1))
				j++;
			//���±�Ϊk�ĸ�Ԫ���Ѿ���������Ԫ�ش����˳��³�
			if(!less(pq, k, j))
				break;
			//������Ԫ�غ���Ԫ�ص�λ��
			exch(pq, k, j, 1);
			//�Ѹ�Ԫ�ض�λ����Ԫ��λ�ã������´��³�
			k = j;
		}
	}
	
	public static void main(String[] args) {
		Sort heap = new Heap();
		heap.sort(a).showCount();
		if(!heap.isSorted(a)){
			System.out.println("����ʧ�ܣ������д�");
		}
		heap.show(a);
	}

}
