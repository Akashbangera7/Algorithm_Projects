import java.util.Random;
import java.util.Scanner;

public class UnionFind {
	public static void main(String args[])
	{
		 Scanner in = new Scanner(System.in);
		 int var;
		 System.out.println("Enter the Number");
	        String s = in.nextLine();
	        double avg=0.0;
	        for(int i=0;i<150;i++)
	        {
	        	var=0;
	        WQUPC w=new WQUPC(Integer.parseInt(s));
	        Random random1 = new Random();
        	Random random2 = new Random();
	        while(w.count()>1)
	        {
	        	int a=random1.nextInt(Integer.parseInt(s));
	        	int b=random2.nextInt(Integer.parseInt(s));
	        	var++;
	        	
	        	while(!(w.connected(a,b)))
	        	{
	        		w.union(a, b);
	        	}
	        	
	        }
	        avg = avg +var;
	        }
	        System.out.println(avg/150);
	        
	        
	        
	       
	        
	}
	  

}
