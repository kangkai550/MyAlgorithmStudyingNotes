package edu.kk.Point;

import edu.kk.utils.StdDraw;
import edu.kk.utils.StdOut;
import edu.kk.utils.StdRandom;

/**
 * 可视化累加器
 *    可用来判断生成的随机数波动(黑点代表个体值，红点代表均值)
 * @author KangKai
 *
 */
public class VisualAccumulator {
	
	/**
	 * 全部值的总和
	 */
	private double total;
	
	/**
	 * 点的数量
	 */
	private int N;
	
	/**
	 * 
	 * @param trials 点的个数
	 * @param max 
	 */
	public VisualAccumulator(int trials, double max){
		StdDraw.setXscale(0, trials);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(.005);
	}
	
	/**
	 * 添加一个值
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
	 * 返回平均值
	 */
	public double mean(){
		return total/N;
	}
	
	/**
	 * 重写toString
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
