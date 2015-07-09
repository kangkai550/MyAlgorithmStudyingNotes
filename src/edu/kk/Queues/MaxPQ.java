package edu.kk.Queues;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.kk.utils.StdIn;
import edu.kk.utils.StdOut;

/**
 * ���ڶѵ����ȶ���
 * @author KangKai
 *
 */
public class MaxPQ<Key> implements Iterable<Key>{

	/**
	 * ע�⣡���±�1��ʼ�洢Ԫ��
	 */
	private Key[] pq;
	
	/**
	 * ���ȶ��еĴ�С
	 */
	private int N;
	
	/**
	 * ��ѡ�ıȽ���
	 */
	private Comparator<Key> comparator;
	
	/**
	 * ������0
	 */
	public MaxPQ() {
	      this(1);
	}
	
	/**
	 * ������1
	 * @param initCapacity ���ȶ��е��������
	 */
	public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }
	
	/**
	 * ������2
	 * @param initCapacity ���ȶ��е��������
	 * @param comparator һ��ָ������ıȽ���
	 */
	public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }
	
	/**
	 * ������3
	 * @param comparator һ��ָ������ıȽ���
	 */
	public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }
	
	/**
	 * ������4 ��һ�������Ԫ�ع����һ�����ȶ��У�ʹ��Ԫ���³�������
	 * @param keys һ��keys����
	 */
	public MaxPQ(Key[] keys) {
        N = keys.length;
        pq = (Key[]) new Object[keys.length + 1]; 
        for (int i = 0; i < N; i++)
            pq[i+1] = keys[i];
        for (int k = N/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }
	
	/**
	 * �����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return N == 0;
	}
	
	/**
	 * ���еĴ�С
	 * @return
	 */
	public int size(){
		return N;
	}
	
	/**
	 * ��ö��е����ֵ
	 * @return
	 */
	public Key max(){
		if(isEmpty())
			throw new NoSuchElementException("���ȶ�������");
		return pq[1];
	}
	
	/**
	 * ����/��С��������
	 * @param capacity
	 */
	private void resize(int capacity){
		assert capacity > N;
		Key[] temp = (Key[])new Object[capacity];
		for(int i = 1; i <= N; i++){
			temp[i] = pq[i];
		}
		pq = temp;
	}
	
	/**
	 * �����ȶ����в���һ��Key
	 * @param x
	 */
	public void insert(Key x){
		//�ж϶����Ƿ����������˾�����
		if(N >= pq.length - 1)
			resize(2 * pq.length);
		//��Ԫ�ؼӵ���������һλ
		pq[++N] = x;
		//�ϸ��¼����Ԫ�ص���ȷλ��
		swim(N);
		assert isMaxHeap();
	}
	
	/**
	 * ɾ���������Ԫ��
	 * @return
	 */
	public Key delMax(){
		if(isEmpty()){
			System.out.println("!!SDAASD");
			throw new NoSuchElementException("���ȶ�������");
		}
		//������Ԫ��
		Key max = pq[1];
		//�����Ԫ����������һ��Ԫ�ؽ���
		exch(1,N--);
		System.out.println(N);
		//�����һ��Ԫ�شӶ�����ʼ�³�����ȷ��λ��
		sink(1);
		//��ɾ����Ԫ���ڶ������ÿգ���ֹ�ڴ�й¶
		pq[N+1] = null;
		//�ж϶����Ƿ��С�����ǣ��Զ�������������������ʡ�ڴ�
		if(N > 0 && (N == (pq.length - 1) / 4))
			resize(pq.length / 2);
		assert isMaxHeap();
		return max;
	}
	
	/**
	 * ���ķ�����Ԫ���ϸ�
	 * @param k
	 */
	private void swim(int k){
		while(k > 1 && less(k / 2, k)){
			exch(k , k / 2);
			k = k / 2;
		}
	}
	
	/**
	 * ���ķ���: Ԫ���³�
	 * @param k
	 */
	private void sink(int k){
		while(2*k <= N){
			int j = 2 * k;
			//�жϵ�ǰԪ�ص�2���¼��ĸ��Ƚϴ�j���α�ָ��ϴ�ģ������ж�
			if(j < N && less(j , j + 1))
				j++;
			//��kС��j��k�������Ԫ�أ�������³�
			if(!less(k , j))
				break;
			//������Ԫ��λ��
			exch(k , j);
			//k��λ���������λ�ã������´��³�
			k = j;
		}
	}
	
	/**
	 * �Ƚ�����Ԫ�ش�С
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean less(int i, int j){
		if(comparator == null){
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
		}
		else{
			return comparator.compare(pq[i], pq[j]) < 0;
		}
	}
	
	/**
	 * ��������Ԫ��
	 * @param i
	 * @param j
	 */
	private void exch(int i, int j){
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	
	/**
	 * �ж��Ƿ���һ������
	 * @return
	 */
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }
    private boolean isMaxHeap(int k) {
        if (k > N) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= N && less(k, left))  return false;
        if (right <= N && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }
    
    
	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) StdOut.print(pq.delMax() + " ");
        }
        StdOut.println("(" + pq.size() + " left on pq)");
    }
	
}
