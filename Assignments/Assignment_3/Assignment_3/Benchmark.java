package Assignment_3;

/*
 * Copyright (c) 2018. Phasmid Software
 */


import Assignment_3.InsertionSort;
import Assignment_3.SelectionSort;
import Assignment_3.Sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.function.Function;

public class Benchmark<T> {

    public Benchmark(Function<T, Void> f) {
        this.f = f;
    }

    public double run(T t, int n) {
    	int totalTime=0;
    	//System.out.println(n);
    	for(int k=0;k<n;k++){
        long startTime = System.nanoTime();
        f.apply(t);
        long timeTaken = System.nanoTime()-startTime;
        totalTime+=timeTaken;
        }
    	return totalTime/n;
        
        
    }

    private final Function<T, Void> f;

    public static void main(String[] args) {
        int m = 100; // This is the number of repetitions: sufficient to give a good mean value of timing
        int n = 2400;
        Integer[] array = new Integer[n];
       
        Random rand=new Random();
       
        //for (int i = 0; i < n; i++) 
       
        	for (int i = n-1 ; i >=0 ; i--)
        {
//       	int randNumber = rand.nextInt(100);
//       	array[i] = randNumber;
    	   
        	array[i]=i;
        	
        System.out.println(array[i]);	
        }
       
        
        
         // TODO populate the array with real random data
        
        // TODO You need to apply doubling to n
        benchmarkSort(array, n, "SelectionSort", new SelectionSort<>(), m);
        benchmarkSort(array, n, "InsertionSort", new InsertionSort<>(), m);
        
        
    }

    private static void benchmarkSort(Integer[] xs, Integer n, String name, Sort<Integer> sorter, int m) {
        Function<Integer, Void> sortFunction = (x) -> {
        	Integer []temp = Arrays.copyOf(xs, xs.length);
            sorter.sort(temp, 0, x);
//            for(int i=0;i<temp.length;i++){
//            System.out.println(temp[i]);
//            }
            return null;	
        };
        Benchmark<Integer> bm = new Benchmark<>(sortFunction);
        double x = bm.run(n, m);
        System.out.println(name + ": " + x + " nanoseconds for n=" + n);
        
    }
}