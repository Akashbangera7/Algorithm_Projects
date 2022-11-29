package Assignment_3;

import static Assignment_3.Helper.less;
import static Assignment_3.Helper.swap;

public class SelectionSort<X extends Comparable<X>> implements Sort<X> {

    @Override
    public void sort(X[] xs, int from, int to) {
        // TODO implement selection sort
    	int N = xs.length;
		for(int i=0;i<N;i++) 
		{
			int min =i;
			for (int j=i+1;j<N;j++) 
			{
				if(less(xs[j],xs[min]))
				{
					min = j;
					swap(xs,i,min);
				}
			}
		}

    }
}