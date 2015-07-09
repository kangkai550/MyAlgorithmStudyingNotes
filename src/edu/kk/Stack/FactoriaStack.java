package edu.kk.Stack;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 使用递归和BigDecimal类计算阶乘
 * 		数字过大会引发StackOverflowError异常，因为一般情况下一个程序的栈深度大于在1000~2000左右
 * 
 * @author KangKai
 *
 */
public class FactoriaStack {  
	public static int STACK_DEPTH = 0;
    public static BigDecimal factorial(BigDecimal n){  
        BigDecimal bd1 = new BigDecimal(1);//1  
        if(n.equals(new BigDecimal(1))){  
            return bd1;  
        }  
        else  
        	FactoriaStack.STACK_DEPTH++;
            return n.multiply(factorial(n.subtract(bd1)));//n*f(n-1)  
    }  
    public static void main(String[] arguments){  
    	
        Scanner sc = new Scanner(System.in);  
        BigDecimal a = sc.nextBigDecimal();  
        BigDecimal result = factorial(a);     
        System.out.println(a + "!=" +result);  
        System.out.println("the depth of stack is " + FactoriaStack.STACK_DEPTH);
    }  
  
}  
