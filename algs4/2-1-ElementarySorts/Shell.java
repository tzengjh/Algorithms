import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class Shell{
	public static void sort(Comparable[] a){
		int N = a.length;
		int k = 1;
		while(k < N/3)
			k = 3*k + 1;
		while(k > 0){
			for(int i = k; i < N; i++){
				for(int j = i; j >= k && less(a[j], a[j - k]); j -= k)
					exch(a, j, j-k);
			}
			k /= 3;
		}
	}

	private static boolean less(Comparable v, Comparable w){
	    return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j){
	    Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}

	private static void show(Comparable[] a){
	    for(int i = 0; i < a.length; i++){
	        StdOut.print(a[i] + " ");
	    }
	    StdOut.println();
	}

	public static boolean isSorted(Comparable[] a){
	    for(int i = 1; i < a.length; i++)
	        if(less(a[i], a[i - 1])) return false;
	    return true;
	}

	public static void main(String[] args){
	    String[] a = In.readStrings();
	    sort(a);
	    assert isSorted(a);
	    show(a);
	}
}