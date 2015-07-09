package edu.kk.search;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import edu.kk.utils.StdIn;
import edu.kk.utils.StdOut;

/**
 * 对输入的key进行二分查找，若不存在于白名单中，则输出这个key
 * @author KangKai
 *
 */
public class BinarySearch {
	public static void main(String[] args) throws IOException {
		int[] whitelist = getWhitelist();//获取白名单
		
		System.out.println("------开始排序100W个整数-----");
		long start = System.currentTimeMillis();
		Arrays.sort(whitelist);//对白名单进行排序
		long end = System.currentTimeMillis();
		System.out.println("花费:" +(end-start)/1000+"秒");
		
		while(!StdIn.isEmpty()){
			//读取键值，如果不存在于白名单中则将其打印
			int key = StdIn.readInt();
			 start = System.currentTimeMillis();
			if(rank(key,whitelist) < 0){
				System.out.println("key=" + key + ",不存在于白名单中");
			}
			 end = System.currentTimeMillis();
			System.out.println("二分查找结束，花费:" +(end-start)+"毫秒");
		}
	}

	public static int rank(int key, int[] a) {
		int low = 0;
		int high = a.length - 1;
		
		while(low <= high){
			//被查找的键要么不存在，要么存在于a[low...high]中
			int mid = low + (high - low)/2;
			if(key < a[mid]){
				high = mid - 1;
			}
			else if(key > a[mid]){
				low = mid + 1;
			}else{
				return mid;
			}
				
		}
		return -1;
	}

	public static int[] getWhitelist() throws IOException {
		int N = 100000;
		int[] a = new int[N];
		int count = 0;
		
		System.out.println("------开始读取"+ N +"个整数-----");
		long start = System.currentTimeMillis();
		File whitelistFile = new File("largeW.txt");
		DataInputStream isr = new DataInputStream(new FileInputStream(whitelistFile));
		do{
			String x = isr.readLine().trim();
			int i = Integer.parseInt(x);
			a[count++] = i;
		}while(isr.read() > 0 && count < N);
		long end = System.currentTimeMillis();
		System.out.println("成功读取"+ count + "个整数");
		System.out.println("读取数据花费:" +(end-start)/1000+"秒");
		return a;
	}
}
