import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class MergeBottomUp{
	private static Comparable[] aux;

	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		for(int hlen = 1; hlen < a.length; hlen += hlen){
			for(int lo = 0; lo + hlen - 1 < a.length - 1; lo += 2*hlen){
				merge(a, lo, lo + hlen - 1, Math.min(a.length - 1, lo + 2*hlen - 1));
			}
		}
	}	

	public static void merge(Comparable[] a, int lo, int mid, int hi){
		// join a[lo..mid] and a[mid+1..hi]
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++)
			aux[k] = a[k];

		for(int k = lo; k <= hi; k++){
			if(i > mid) 	a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less(aux[i], aux[j]))	a[k] = aux[i++]; // less(aux[i], aux[j])
			else	a[k] = aux[j++];
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
