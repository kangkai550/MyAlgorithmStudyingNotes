package edu.kk.GCD;

import java.util.Scanner;

/**
 * �ݹ鷽��������p��q�����Լ��
 * @author KangKai
 *
 */
public class Euclid {
	static int count = 1;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("����p��");
		int p = sc.nextInt();
		System.out.println("����q��");
		int q = sc.nextInt();
		
		//����p��q�����Լ��
		int gcd = gcd(p,q);
		System.out.println(p + "��" + q + "�����Լ����:" + gcd);
		
	}

	private static int gcd(int p, int q) {
		System.out.println("��" +(Euclid.count++) +"�ε���:" + "p=" + p + ",q=" +q);
		if(q == 0) 
			return p;
		int r = p % q;
		return gcd(q,r);
	}
}
