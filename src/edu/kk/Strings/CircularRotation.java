package edu.kk.Strings;

import edu.kk.utils.StdIn;


/**
 * �ж��ַ���s�Ƿ���t�ַ����ġ��ػ���λ��
 * 
 * ʲô�ǡ��ػ���λ����
 * 	   ���ַ���s�е��ַ�ѭ���ƶ�����λ��֮���ܵõ���һ�ַ���t
 * 
 * @author KangKai
 *
 */
public class CircularRotation {
	public static void main(String[] args) {
		String s = null;
		String t = null;
		
		System.out.println("INPUT s AND t��");
		s = StdIn.readString();
		t = StdIn.readString();
		
		//һ�д��뼴���ж��Ƿ�Ϊ�ػ���λ
		if(s.length() == t.length() && s.concat(s).indexOf(t) >= 0){
			System.out.println("��s:"+ s +"�봮t:"+ t +"��Ϊ�ػ���λ");
		}else{
			System.out.println("��s:"+ s +"�봮t:"+ t +"�����ܻ�Ϊ�ػ���λ");
		}
	}
}
