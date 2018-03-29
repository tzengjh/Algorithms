
public class Kendalltau{

	public static int distance(int[] a, int[] b){
		if(a == null || b == null)
			throw new IllegalArgumentException("Array is null!");
		if(a.length != b.length)
			throw new IllegalArgumentException();

		int[] map = new int[a.length];  // describe the map a -> {0,1,2,3,4,5,6,7,8,9,...}
		int[] prob = new int[b.length]; // reconstruct b from map
		for(int i = 0; i < a.length;i++)
			map[a[i]] = i;
		for(int i = 0; i < b.length;i++)
			prob[i] = map[b[i]];
		return sortCount(prob);
	}

	public static int sortCount(int[] a){
		int count = 0;
		for(int i = 1; i < a.length; i++)
			for(int j = i; j > 0 && a[j] < a[j - 1]; j--){
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				count ++;
			}
		return count;
	}

	public static void main(String[] args) {
		int[] a = {0,3,1,6,2,5,4};
		int[] b = {1,0,3,6,4,2,5};
		for(int i = 0; i < a.length; i ++){
			System.out.println(a[i] + " "  + b[i]);
		}
		System.out.println("Kendall tau:" + distance(a, b));
	}
}