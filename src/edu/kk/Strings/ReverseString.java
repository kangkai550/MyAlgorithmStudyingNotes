package edu.kk.Strings;

import edu.kk.utils.StdIn;

/**
 * 用递归的方法生成一个字符串的倒叙
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
		System.out.println("左String:" + a + ",右String:" + b);
		
		return getReverseString(b) + getReverseString(a);
	}
	
	
}
