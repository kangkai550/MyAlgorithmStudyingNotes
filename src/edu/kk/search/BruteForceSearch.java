package edu.kk.search;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import edu.kk.utils.StdDraw;
import edu.kk.utils.StdIn;

/**
 * 暴力查找，即脑残查找
 * @author KangKai
 *
 */
public class BruteForceSearch {
	public static void main(String[] args) throws IOException {
		int[] whitelist = getWhitelist();//获取白名单

		System.out.println("------开始排序100W个整数-----");
		long start = System.currentTimeMillis();
		
		Arrays.sort(whitelist);//对白名单进行排序
		long end = System.currentTimeMillis();
		System.out.println("花费:" +(end-start)+"毫秒");

		while(!StdIn.isEmpty()){
			//读取键值，如果不存在于白名单中则将其打印
			int key = StdIn.readInt();
			System.out.println("二分查找开始----key="+ key);
			 start = System.currentTimeMillis();
			if(rank(key,whitelist) < 0){
				System.out.println("key=" + key + ",不存在于白名单中");
			}
			 end = System.currentTimeMillis();
			System.out.println("二分查找结束，花费:" +(end-start)+"毫秒");
		}
	}

	private static int rank(int key, int[] a) {
		for(int i = 0; i < a.length; i++){
			if(a[i] == key) 
				return i;
		}
		return -1;
	}

	private static int[] getWhitelist() throws IOException {
		int[] a = new int[1000000];
		int count = 0;
		
		System.out.println("------开始读取100W个整数-----");
		long start = System.currentTimeMillis();
		File whitelistFile = new File("largeW.txt");
		DataInputStream isr = new DataInputStream(new FileInputStream(whitelistFile));
		do{
			String x = isr.readLine().trim();
			int i = Integer.parseInt(x);
			a[count++] = i;
		}while(isr.read() > 0);
		long end = System.currentTimeMillis();
		System.out.println("成功读取"+ count + "个整数");
		System.out.println("花费:" +(end-start)/1000+"秒");
		return a;
	}
}
