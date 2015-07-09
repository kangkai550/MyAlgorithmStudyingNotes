package edu.kk.search;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import edu.kk.utils.StdDraw;
import edu.kk.utils.StdIn;

/**
 * �������ң����Բв���
 * @author KangKai
 *
 */
public class BruteForceSearch {
	public static void main(String[] args) throws IOException {
		int[] whitelist = getWhitelist();//��ȡ������

		System.out.println("------��ʼ����100W������-----");
		long start = System.currentTimeMillis();
		
		Arrays.sort(whitelist);//�԰�������������
		long end = System.currentTimeMillis();
		System.out.println("����:" +(end-start)+"����");

		while(!StdIn.isEmpty()){
			//��ȡ��ֵ������������ڰ������������ӡ
			int key = StdIn.readInt();
			System.out.println("���ֲ��ҿ�ʼ----key="+ key);
			 start = System.currentTimeMillis();
			if(rank(key,whitelist) < 0){
				System.out.println("key=" + key + ",�������ڰ�������");
			}
			 end = System.currentTimeMillis();
			System.out.println("���ֲ��ҽ���������:" +(end-start)+"����");
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
		
		System.out.println("------��ʼ��ȡ100W������-----");
		long start = System.currentTimeMillis();
		File whitelistFile = new File("largeW.txt");
		DataInputStream isr = new DataInputStream(new FileInputStream(whitelistFile));
		do{
			String x = isr.readLine().trim();
			int i = Integer.parseInt(x);
			a[count++] = i;
		}while(isr.read() > 0);
		long end = System.currentTimeMillis();
		System.out.println("�ɹ���ȡ"+ count + "������");
		System.out.println("����:" +(end-start)/1000+"��");
		return a;
	}
}
