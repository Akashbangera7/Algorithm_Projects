package main;


import java.util.Arrays;
import java.util.Random;

public class Coupon_Collector {
	public static int x;
    public static int[] array;
    static int result[];
    static double itertation_count = 500.0;

    public static void main(String[] args) 
    	{
    	 	x=100;
           double averageC = 0.0;
           double averageB = 0.0;
           for (int i = 0; i < itertation_count; i++)
           {
                  array = new int[x];
                  Arrays.fill(array, -1);
                  result = new int[2];
                  hash();
                  averageC = averageC + result[0];
                  averageB = averageB + result[1];
           }
           
           System.out.println("Collision prog :"+averageC/itertation_count);
           System.out.println("Collision theory :"+Math.sqrt(Math.PI * x / 2));
           System.out.println("Completed Array prog :"+averageB/itertation_count);
           System.out.println("Completed Array theory :"+x*Math.log(x));
           
           
    }

    public static void hash() 
    {
           boolean checkForFirstitertation_count = true;
           boolean checkAllElements = false;
           while(true) 
           {
                  if(checkForFirstitertation_count) 
                  {
                        initializearrayay(true);
                        checkForFirstitertation_count = false;
                        continue;
                  }
                  else 
                  {
                        checkAllElements = false;
                        for(int i=0;i<x;i++) 
                        {
                               if(array[i]==-1) 
                               {
                                      initializearrayay2();
                                      checkAllElements = true;
                               }
                        }
                   }
                        if(checkAllElements) 
                        {
                               continue;
                        }else 
                        {
                               break;
                        }
           }
    }
   
    static void initializearrayay(boolean firstTime) {
           int count = 0;
           for (int i = 0; i < x; i++) {
                  Random r = new Random();
                  int value = r.nextInt(x);
                  int mod = value % x;
                  if (array[mod] == -1) {
                        array[mod] = value;
                        result[1]++;
                        count++;
                  } else if(firstTime){
                        result[0] = count;
                        break;
                  }
           }
    }
   
    static void initializearrayay2() {
           for (int i = 0; i < x; i++) {
                  Random r = new Random();
                  int val = r.nextInt(x);
                  int mod = val % x;
                        array[mod] = value;
                        result[1]++;
           }
    }
    
    public static void hashtest(int[] array1) 
    {
    		
    		
    		for (int i =0; i<x;i++) {
    			int mod = array1[i]%x;
    			array[mod]=array1[i];
    		}
    		
    }

	
}
