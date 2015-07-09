package edu.kk.Queues;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.kk.utils.StdIn;
import edu.kk.utils.StdOut;

/**
 * 基于堆得优先队列
 * @author KangKai
 *
 */
public class MaxPQ<Key> implements Iterable<Key>{

	/**
	 * 注意！从下标1开始存储元素
	 */
	private Key[] pq;
	
	/**
	 * 优先队列的大小
	 */
	private int N;
	
	/**
	 * 可选的比较器
	 */
	private Comparator<Key> comparator;
	
	/**
	 * 构造器0
	 */
	public MaxPQ() {
	      this(1);
	}
	
	/**
	 * 构造器1
	 * @param initCapacity 优先队列的最大容量
	 */
	public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }
	
	/**
	 * 构造器2
	 * @param initCapacity 优先队列的最大容量
	 * @param comparator 一个指定规则的比较器
	 */
	public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }
	
	/**
	 * 构造器3
	 * @param comparator 一个指定规则的比较器
	 */
	public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }
	
	/**
	 * 构造器4 把一个数组的元素构造成一个优先队列，使用元素下沉来构造
	 * @param keys 一个keys数组
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
	 * 队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return N == 0;
	}
	
	/**
	 * 队列的大小
	 * @return
	 */
	public int size(){
		return N;
	}
	
	/**
	 * 获得队列的最大值
	 * @return
	 */
	public Key max(){
		if(isEmpty())
			throw new NoSuchElementException("优先队列下溢");
		return pq[1];
	}
	
	/**
	 * 扩充/缩小队列容量
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
	 * 向优先队列中插入一个Key
	 * @param x
	 */
	public void insert(Key x){
		//判断队列是否满，若满了就扩容
		if(N >= pq.length - 1)
			resize(2 * pq.length);
		//把元素加到数组的最后一位
		pq[++N] = x;
		//上浮新加入的元素到正确位置
		swim(N);
		assert isMaxHeap();
	}
	
	/**
	 * 删除队列最大元素
	 * @return
	 */
	public Key delMax(){
		if(isEmpty()){
			System.out.println("!!SDAASD");
			throw new NoSuchElementException("优先队列下溢");
		}
		//获得最大元素
		Key max = pq[1];
		//将最大元素与队列最后一个元素交换
		exch(1,N--);
		System.out.println(N);
		//让最后一个元素从顶部开始下沉到正确的位置
		sink(1);
		//把删除的元素在队列内置空，防止内存泄露
		pq[N+1] = null;
		//判断队列是否过小，若是，对队列容量进行缩减，节省内存
		if(N > 0 && (N == (pq.length - 1) / 4))
			resize(pq.length / 2);
		assert isMaxHeap();
		return max;
	}
	
	/**
	 * 核心方法：元素上浮
	 * @param k
	 */
	private void swim(int k){
		while(k > 1 && less(k / 2, k)){
			exch(k , k / 2);
			k = k / 2;
		}
	}
	
	/**
	 * 核心方法: 元素下沉
	 * @param k
	 */
	private void sink(int k){
		while(2*k <= N){
			int j = 2 * k;
			//判断当前元素的2个下级哪个比较大，j的游标指向较大的，便于判断
			if(j < N && less(j , j + 1))
				j++;
			//若k小于j（k的最大子元素）则继续下沉
			if(!less(k , j))
				break;
			//交换两元素位置
			exch(k , j);
			//k定位到交换后的位置，继续下次下沉
			k = j;
		}
	}
	
	/**
	 * 比较两个元素大小
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
	 * 交换两个元素
	 * @param i
	 * @param j
	 */
	private void exch(int i, int j){
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	
	/**
	 * 判断是否是一个最大堆
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
