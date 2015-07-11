package edu.kk.utils;

/*************************************************************************
 *  Compilation:  javac SortCompare.java
 *  Execution:    java SortCompare alg1 alg2 N T
 *  
 *  Sort N random real numbers, T times using the two
 *  algorithms specified on the command line.
 * 
 *  % java SortCompare Insertion Selection 1000 100 
 *  For 1000 random Doubles 
 *    Insertion is 1.7 times faster than Selection
 *
 *  Note: this program is designed to compare two sorting algorithms with
 *  roughly the same order of growth, e,g., insertion sort vs. selection
 *  sort or mergesort vs. quicksort. Otherwise, various system effects
 *  (such as just-in-time compiliation) may have a significant effect.
 *  One alternative is to execute with "java -Xint", which forces the JVM
 *  to use interpreted execution mode only.
 *
 *************************************************************************/
import java.util.Arrays;

import edu.kk.sorts.Heap;
import edu.kk.sorts.Insertion;
import edu.kk.sorts.InsertionX;
import edu.kk.sorts.Merge;
import edu.kk.sorts.MergeBU;
import edu.kk.sorts.Quick;
import edu.kk.sorts.Selection;
import edu.kk.sorts.Shell;
import edu.kk.sorts.Sort;

public class SortCompare { 

    public static double time(String alg, Double[] a) { 
        Stopwatch sw = new Stopwatch(); 
        //使用反射动态加载，减少代码量与稳定性
        try {
			//获得动态加载的类类型
        	Class c = Class.forName("edu.kk.sorts." + alg);
        	//获得实例
        	Sort sort = (Sort) c.newInstance();
        	sort.sort(a);
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid algorithm: " + alg);
		}
//        if (alg.equals("Insertion"))      new Insertion().sort(a);
//        else if (alg.equals("Selection"))  new Selection().sort(a);
//        else if (alg.equals("InsertionX")) new InsertionX().sort(a);  
//        else if (alg.equals("Shell"))      new Shell().sort(a); 
//        else if (alg.equals("Merge"))      new Merge().sort(a); 
////        else if (alg.equals("MergeX"))     new MergeX().sort(a); 
//        else if (alg.equals("MergeBU"))    new MergeBU().sort(a); 
//        else if (alg.equals("Quick"))      new Quick().sort(a); 
////        else if (alg.equals("Quick3way"))  new Quick3way().sort(a); 
////        else if (alg.equals("QuickX"))     new QuickX().sort(a); 
//        else if (alg.equals("Heap"))       new Heap().sort(a); 
//        else if (alg.equals("System"))     Arrays.sort(a); 
//        else throw new IllegalArgumentException("Invalid algorithm: " + alg);
        return sw.elapsedTime(); 
    } 

    // Use alg to sort T random arrays of length N. 
    public static double timeRandomInput(String alg, int N, int T)  {
        double total = 0.0; 
        Double[] a = new Double[N]; 
        // Perform one experiment (generate and sort an array). 
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) 
                a[i] = StdRandom.uniform(); 
            total += time(alg, a); 
        } 
        return total; 
    } 

    public static void main(String[] args) { 
    	
    	System.out.println("");
        String alg1 = "Quick"; 
        String alg2 = "Heap"; 
        int N = Integer.parseInt("1000");
        int T = Integer.parseInt("100"); 
        double time1 = timeRandomInput(alg1, N, T); // Total for alg1. 
        double time2 = timeRandomInput(alg2, N, T); // Total for alg2. 
        StdOut.print(alg1 + " cost " + time1 + "s\n" + alg2 + " cost " + time2 + "s\n"); 
        if(time1 > time2){
        	StdOut.printf("-------------------------------------------------\n");
        	StdOut.printf("%s is faster, cost %fs   \n", alg2, time2);
        	StdOut.printf("-------------------------------------------------\n");
        	StdOut.printf("For %d random Doubles\n    %s is", N, alg2);
        	StdOut.printf(" %.1f times faster than %s\n", time1/time2, alg1); 
        }
        else{
        	StdOut.printf("-------------------------------------------------\n");
        	StdOut.printf("%s is faster, cost %fs   \n", alg1, time1);
        	StdOut.printf("-------------------------------------------------\n");
        	StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
        	StdOut.printf(" %.1f times faster than %s\n", time2/time1, alg2); 
        }
    } 
} 