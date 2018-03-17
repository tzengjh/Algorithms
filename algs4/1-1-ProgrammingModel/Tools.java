import java.util.Arrays;
import java.lang.Math;
import java.lang.Double;
public class Tools{
	public static int gcd(int p ,int q){
		if (q==0) return p;
		int r = p % q;
		return gcd(q,r);
	}

	public static int binarySearch(int key, int[] a){
		if(a == null || a.length == 0)
			throw new IllegalArgumentException();
		int low = 0, high = a.length - 1;
		int mid = low + (high - low) / 2;
		while(low <= high){
			if(a[mid] < key)
				low = mid + 1;
			else if(a[mid] > key)
				high = mid - 1;
			else
				return mid;
			mid = low + (high - low) / 2;
		}
		return -1;
	}

	public static int rank(int key, int[] a){
		return rank(key, a, 0, a.length - 1);
	}

	public static int rank(int key, int[] a, int lo, int hi){
		if(lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if(a[mid] < key)
			return rank(key, a, mid + 1, hi);
		else if(a[mid] > key)
			return rank(key, a, lo, mid - 1);
		else
			return mid;
	}

	public static boolean isPrime(int N){
		if(N <= 2)
			return false;
		for(int i = 2; i * i <= N; i ++)
			if(N % i == 0) return false;
		return true;
	}

	public static double sqrt(double n){
		if(n<0) return Double.NaN;
		double eps = 1e-9;
		double x = n;
		while(Math.abs(n/x - x) > eps * x)
			x = (n/x + x) / 2.0;
		return x;
	}

	public static void pln(Object s){
		System.out.println(s);
	}

	public static void printArray(int[] a){
		System.out.print("[ ");
		for(int i = 0; i < a.length;i ++)
			System.out.print(a[i] + " ");
		System.out.println("]");
	}


	public static void main(String[] args) {
		pln("Gcd(18, 12): " + gcd(18, 12));
		pln("3 is Prime? " +  isPrime(3));
		pln("4 is Prime? " + isPrime(4));
		pln("sqrt(9): " + sqrt(9));
		pln("sqrt(2): " + sqrt(2));

		int [] a = new int[]{12,3,4,5,1,9,0};
		Arrays.sort(a);
		pln("Array a is:");
		printArray(a);
		pln("Find 8 in a: " + binarySearch(8, a));
		pln("Find 3 in a: " + binarySearch(3, a));
		pln("Find 8 in a using rank: " + rank(8, a));
		pln("Find 3 in a using rank: " + rank(3, a));
		pln("Random[0,1) in Math:" + Math.random());
		System.out.printf("%15e",2.0e-6 * 100000000.1);
	}

}