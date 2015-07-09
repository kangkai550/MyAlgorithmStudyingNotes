package edu.kk.Strings;

import edu.kk.utils.StdIn;


/**
 * 判断字符串s是否是t字符串的“回环变位”
 * 
 * 什么是“回环变位”？
 * 	   即字符串s中的字符循环移动任意位置之后能得到另一字符串t
 * 
 * @author KangKai
 *
 */
public class CircularRotation {
	public static void main(String[] args) {
		String s = null;
		String t = null;
		
		System.out.println("INPUT s AND t：");
		s = StdIn.readString();
		t = StdIn.readString();
		
		//一行代码即可判断是否为回环变位
		if(s.length() == t.length() && s.concat(s).indexOf(t) >= 0){
			System.out.println("串s:"+ s +"与串t:"+ t +"互为回环变位");
		}else{
			System.out.println("串s:"+ s +"与串t:"+ t +"并不能互为回环变位");
		}
	}
}
