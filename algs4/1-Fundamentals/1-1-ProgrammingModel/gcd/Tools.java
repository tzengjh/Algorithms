public class Tools{
	public static int gcd(int p ,int q){
		if (q==0) return p;
		int r = p % q;
		return gcd(q,r);
	}
}
