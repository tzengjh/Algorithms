/**
* Get K th maximal or minimal value in a unsorted array
* For example, getQuick(a, a.length / 2) return the median of array.
*/
import java.util.PriorityQueue;
import java.util.Queue;
import edu.princeton.cs.algs4.StdRandom;

public class GetK{

	// using quick sort partition: O(n)
	public static int getQuick(int[] a, int k){
		StdRandom.shuffle(a);
		return find(a, k - 1, 0, a.length - 1);
	}

	public static int find(int[] a, int k, int lo, int hi){
		if(lo > hi) return -1;
		if(lo == hi && k == hi) return a[lo];
		int j = partition(a, lo, hi);
		if(j == k) return a[j];
		else if(j < k) return find(a, k, j + 1, hi);
		else return find(a, k, lo, j - 1);
	}

	public static int partition(int[] a, int lo, int hi){
		int i = lo, j = hi + 1;
		int cmp = a[lo];
		while(true){
			while(cmp > a[++i]) if(i == hi) break;
			while(a[--j] > cmp) if(j == lo) break;
			if(i >= j) break; // i >= j
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		a[lo] = a[j];
		a[j] = cmp;
		return j;
	}

	// using priority queue: O(nlogk)
	public static int get(int[] a, int k){
		Queue<Integer> pq = new PriorityQueue<Integer>(k); // min queue
		for(int i = 0; i < a.length; i ++){
			pq.add(a[i]);
			if(pq.size() > k){
				pq.poll();
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] a = {12,4,5,6,2,1,113,4,42,34};
		int k = Integer.parseInt(args[0]);
		for(int i = 0; i < a.length; i ++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.println("The " + k + "th element in array is " + get(a, k));

		System.out.println("The " + k + "th minimal element in array is " + getQuick(a, k));
	}
}