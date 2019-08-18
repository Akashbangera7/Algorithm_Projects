package Assignment_3;

import static Assignment_3.Helper.*;

public class InsertionSort<X extends Comparable<X>> implements Sort<X> {
    @Override
    public void sort(X[] xs, int from, int to) {
        // TODO implement insertionSort
    	int N = xs.length;
		for(int i =0; i< N; i++) 
		{
			for(int j=i;j>0;j--) 
			{
				if(less(xs[j],xs[j-1])) 
				{
					swap(xs,j,j-1);
					
				}
				else {
					break;
				}
			}
		}

    }
}