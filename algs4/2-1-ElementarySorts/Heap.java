import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class Heap{

	public static void sort(Comparable[] a){
	    int N = a.length;
	    for(int i = N/2; i>0; i--)
	    	sink(a, i, N);
	    while(N > 1){
	    	exch(a, 1, N--);
	    	sink(a, 1, N);
	    }
	}

	private static void sink(Comparable[] a, int k, int N){
		while(2*k <= N){
			int i = 2*k;
			if(i < N && less(a, i, i+1)) i ++;
			if(!less(a, k, i)) break;
			exch(a, k, i);
			k = i;
		}
	}

	private static void swim(Comparable[] a, int k, int N){
		while(k > 1 && less(a, k / 2, k)){
			exch(a, k / 2, k);
			k = k / 2;
		}
	}

	private static boolean less(Comparable[] a, int v, int w){
	    return a[v-1].compareTo(a[w-1]) < 0;
	}

	private static void exch(Comparable[] a, int i, int j){
	    Comparable t = a[i-1]; a[i-1] = a[j-1]; a[j-1] = t; 
	}

	private static void show(Comparable[] a){
	    for(int i = 0; i < a.length; i++){
	        StdOut.print(a[i] + " ");
	    }
	    StdOut.println();
	}

	public static boolean isSorted(Comparable[] a){
	    for(int i = 1; i < a.length; i++)
	        if(less(a, i + 1, i )) return false;
	    return true;
	}

	public static void main(String[] args){
	    String[] a = In.readStrings();
	    sort(a);
	    assert isSorted(a);
	    show(a);
	}
}