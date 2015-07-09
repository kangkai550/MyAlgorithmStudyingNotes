package edu.kk.Sum;

import java.io.IOException;
import java.util.Arrays;

import edu.kk.search.BinarySearch;
import edu.kk.utils.StdOut;
import edu.kk.utils.Stopwatch;



/**
 * ����һ�������ں�Ϊ���3�����������
 * 
 * @author KangKai
 *
 */
public class ThreeSumFast {
	public static int count(int[] a){
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for(int i = 0; i < N;i++){
			for(int j = i+1; j < N; j++)
				if(BinarySearch.rank(-(a[i]+a[j]), a) > i){
					cnt++;
				}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		//���100W������
		int[] a = BinarySearch.getWhitelist();
		Stopwatch sw = new Stopwatch();
		StdOut.println(count(a));
		System.out.println("���������Գ�������ʱ�䣺" + sw.elapsedTime());
	}
}
