package edu.kk.utils;

public class Stopwatch {
	private final long start;
	
	public Stopwatch(){
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime(){
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
	
	public void printTime(String str){
		System.out.println(str + "所花费的时间:" + elapsedTime() + "秒");
	}
}
