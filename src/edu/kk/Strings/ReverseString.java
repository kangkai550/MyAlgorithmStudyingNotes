package edu.kk.Strings;

import edu.kk.utils.StdIn;

/**
 * �õݹ�ķ�������һ���ַ����ĵ���
 * @author KangKai
 *
 */
public class ReverseString {
	public static void main(String[] args) {
		String s = StdIn.readString();
		
		String sReverse = getReverseString(s);
		System.out.println(sReverse);
	}

	private static String getReverseString(String s) {
		int N = s.length();
		if(N <= 1)
			return s;
		
		String a = s.substring(0, N/2);
		String b = s.substring(N/2, N);
		System.out.println("��String:" + a + ",��String:" + b);
		
		return getReverseString(b) + getReverseString(a);
	}
	
	
}
