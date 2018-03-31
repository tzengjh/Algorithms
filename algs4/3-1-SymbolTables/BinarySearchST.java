import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchST<Key extends Comparable<Key>, Value>{

	private Key[] keys;
	private Value[] values;
	private int n;
	public BinarySearchST(int maxCapacity){
		keys = (Key[]) new Comparable[maxCapacity];
		values = (Value[]) new Object[maxCapacity];
	}

	public Value get(Key key){
		int j = rank(key);
		if(j < n && key.compareTo(keys[j]) == 0) return values[j];
		return null;
	}

	public void put(Key key, Value value){
		int j = rank(key);
		if(j < n && key.compareTo(keys[j]) == 0){
			values[j] = value;
			return;
		}
		for(int i = n; i > j; i--){
			keys[i] = keys[i - 1];
			values[i] = values[i - 1];
		}
		keys[j] = key;
		values[j] = value;
		n++;
	}

	public int rank(Key key){
		int lo = 0, hi = n - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp > 0) lo = mid + 1;
			else if(cmp < 0) hi = mid - 1;
			else return mid;
		}
		return lo;
	}

	public int size(){return n;}

	public boolean isEmpty(){return n==0;}

	public void delete(Key key){
		int j = rank(key);
		if(j < n && key.compareTo(keys[j]) == 0){
			for(int i = j; i + 1 < n; i++){
				keys[i] = keys[i + 1];
				values[i] = values[i + 1];
			}
			keys[n - 1] = null;
			values[n - 1] = null;
			n--;
		}
	}

	public Key floor(Key key){
		int j = rank(key);
		if(j < n && key.compareTo(keys[j]) == 0){
			return key;
		}else if(j > 0) return keys[j - 1];
		else return null;
	}

	public Key ceiling(Key key){
		int j = rank(key);
		if(j < n) return keys[j];
		else return null;
	}

	public Key select(int k){
		if(k >= n || k < 0) throw new IllegalArgumentException();
		return keys[k];
	}

	public void deleteMax(){
		delete(max());
	}

	public void deleteMin(){
		delete(min());
	}

	public int size(Key lo, Key hi){
		int i = rank(lo);
		int j = rank(hi);
		if(j < n && hi.compareTo(keys[j]) == 0)
			return j - i + 1;
		else
			return j - i;
	}

	public Iterable<Key> keys(Key lo, Key hi){
		Queue<Key> q = new Queue<Key>();
		int i = rank(lo), j = rank(hi);
		if(j < n && hi.compareTo(keys[j]) == 0) ;
		else j--;
		for(int k = i; k <= j; k++){
			q.enqueue(keys[k]);
		}
		return q;
	}

	public Iterable<Key> keys(){
		Queue<Key> q = new Queue<Key>();
		for(int k = 0; k < n; k++)
			q.enqueue(keys[k]);
		return q;
	}

	public boolean contains(Key key){
		return get(key) != null;
	}

	public Key min(){
		return keys[0];
	}

	public Key max(){
		return keys[n-1];
	}

	public static void main(String[] args) { 
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(15);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        st.delete("A");
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}