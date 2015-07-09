package edu.kk.GCD;

import java.util.Scanner;

/**
 * 递归方法求两数p和q的最大公约数
 * @author KangKai
 *
 */
public class Euclid {
	static int count = 1;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("输入p：");
		int p = sc.nextInt();
		System.out.println("输入q：");
		int q = sc.nextInt();
		
		//计算p和q的最大公约数
		int gcd = gcd(p,q);
		System.out.println(p + "和" + q + "的最大公约数是:" + gcd);
		
	}

	private static int gcd(int p, int q) {
		System.out.println("第" +(Euclid.count++) +"次调用:" + "p=" + p + ",q=" +q);
		if(q == 0) 
			return p;
		int r = p % q;
		return gcd(q,r);
	}
}
