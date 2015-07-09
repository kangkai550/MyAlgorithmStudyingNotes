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
 * �������key���ж��ֲ��ң����������ڰ������У���������key
 * @author KangKai
 *
 */
public class BinarySearch {
	public static void main(String[] args) throws IOException {
		int[] whitelist = getWhitelist();//��ȡ������
		
		System.out.println("------��ʼ����100W������-----");
		long start = System.currentTimeMillis();
		Arrays.sort(whitelist);//�԰�������������
		long end = System.currentTimeMillis();
		System.out.println("����:" +(end-start)/1000+"��");
		
		while(!StdIn.isEmpty()){
			//��ȡ��ֵ������������ڰ������������ӡ
			int key = StdIn.readInt();
			 start = System.currentTimeMillis();
			if(rank(key,whitelist) < 0){
				System.out.println("key=" + key + ",�������ڰ�������");
			}
			 end = System.currentTimeMillis();
			System.out.println("���ֲ��ҽ���������:" +(end-start)+"����");
		}
	}

	public static int rank(int key, int[] a) {
		int low = 0;
		int high = a.length - 1;
		
		while(low <= high){
			//�����ҵļ�Ҫô�����ڣ�Ҫô������a[low...high]��
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
		
		System.out.println("------��ʼ��ȡ"+ N +"������-----");
		long start = System.currentTimeMillis();
		File whitelistFile = new File("largeW.txt");
		DataInputStream isr = new DataInputStream(new FileInputStream(whitelistFile));
		do{
			String x = isr.readLine().trim();
			int i = Integer.parseInt(x);
			a[count++] = i;
		}while(isr.read() > 0 && count < N);
		long end = System.currentTimeMillis();
		System.out.println("�ɹ���ȡ"+ count + "������");
		System.out.println("��ȡ���ݻ���:" +(end-start)/1000+"��");
		return a;
	}
}
