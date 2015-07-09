package edu.kk.Point;

import edu.kk.utils.StdDraw;
import edu.kk.utils.StdOut;
import edu.kk.utils.StdRandom;

/**
 * ���ӻ��ۼ���
 *    �������ж����ɵ����������(�ڵ�������ֵ���������ֵ)
 * @author KangKai
 *
 */
public class VisualAccumulator {
	
	/**
	 * ȫ��ֵ���ܺ�
	 */
	private double total;
	
	/**
	 * �������
	 */
	private int N;
	
	/**
	 * 
	 * @param trials ��ĸ���
	 * @param max 
	 */
	public VisualAccumulator(int trials, double max){
		StdDraw.setXscale(0, trials);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(.005);
	}
	
	/**
	 * ���һ��ֵ
	 * @param val
	 */
	public void addDataValue(double val){
		N++;
		total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, total/N);
	}
	
	/**
	 * ����ƽ��ֵ
	 */
	public double mean(){
		return total/N;
	}
	
	/**
	 * ��дtoString
	 */
	public String toString(){
		return "Mean (" + N + " values): " + String.format("%7.5f", mean());
	}
	
	public static void main(String[] args) {
		int T = 10000;
		VisualAccumulator a = new VisualAccumulator(T, 1.0);
		for(int t = 0; t < T; t++){
			a.addDataValue(StdRandom.random());
		}
		StdOut.println(a);
	}
}
