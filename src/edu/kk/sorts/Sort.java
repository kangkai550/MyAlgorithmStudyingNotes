package edu.kk.sorts;

import edu.kk.utils.StdOut;

/**
 * ����һ�������㷨�ĳ�����ģ�棬������������Լ̳д��࣬��дsortʵ�ֲ�ͬ����
 * �������κ�ʵ����Comparable�ӿڵ���������
 * @author KangKai
 *
 */
public abstract class Sort {
	
	public  long compareCount = 0;
	public  long exchCount = 0;
	
	public static String[] a = {"S","O","R","T","E","X","A","M","P","L","E"};//�����
//	public static String[] a = {"M","N","L","K","J","I","H","G","F","E","D","C","B","A"};//�����������
//	public static String[] a = {"D","C","B","A"};
//	public static String[] a = {"A","A","A","A","A","A","A","A","A","A"};//������ͬ����
//	public static String[] a = {"A","B","A","A","B","A","B","B","B","A","B","A","B","B","A","A","B","A","A","B"};//ֻ�������������У��ҳ��ָ�����ͬ	
	/**
	 * ��������򷽷����ɼ̳д����������д
	 * @param a
	 */
	public abstract Sort sort(Comparable[] a);
	
	/**
	 * ����һ���ȽϺ���
	 * ���v��wС�ͷ���true
	 * @param v
	 * @param w
	 * @return
	 */
	public  boolean less(Comparable v, Comparable w){
		compareCount++;
		return v.compareTo(w) < 0;
	}
	
	/**
	 * ����һ���ȽϺ���
	 * @param pq
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }
	
	/**
	 * ����������ڽ�Ԫ�ؽ���λ��
	 * @param a
	 * @param i
	 * @param j
	 */
	public  void exch(Comparable[] a,int i ,int j){
		exchCount++;
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/**
	 * ����������ڽ�����������Ԫ��λ��,ר���ڶ���
	 * @param pq
	 * @param i
	 * @param j
	 */
	public void exch(Object[] pq, int i, int j,int flag) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
	
	/**
	 * �������
	 * @param a
	 */
	public  void show(Comparable[] a){
		//�ڵ����д�ӡ����
		for(int i = 0; i < a.length; i++){
			StdOut.print(a[i] + "");
		}
	}
	
	/**
	 * ����Ԫ���Ƿ�����
	 * @param a
	 * @return
	 */
	public  boolean isSorted(Comparable[] a){
		for(int i = 1; i < a.length; i++){
			if(less(a[i],a[i-1])){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ��ý����ͱȽϵĴ���
	 */
	public void showCount(){
		System.out.println(this.getClass().getSimpleName()+"���򣺽�����" + exchCount + "�Σ��Ƚ���" + compareCount + "��");
	}
}
