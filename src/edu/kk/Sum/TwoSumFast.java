package edu.kk.Sum;

import java.io.IOException;
import java.util.Arrays;

import edu.kk.search.BinarySearch;
import edu.kk.utils.StdOut;
import edu.kk.utils.Stopwatch;



/**
 * 计算一组数组内和为零的整数对
 * 
 * @author KangKai
 *
 */
public class TwoSumFast {
	public static int count(int[] a){
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for(int i = 0; i < N;i++){
			if(BinarySearch.rank(-a[i], a) > i){
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		//获得100W个整数
		int[] a = BinarySearch.getWhitelist();
		Stopwatch sw = new Stopwatch();
		StdOut.println(count(a));
		System.out.println("查找整数对程序运行时间：" + sw.elapsedTime());
	}
}
