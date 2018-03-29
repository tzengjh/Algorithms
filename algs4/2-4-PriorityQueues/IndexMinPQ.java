
public class IndexMinPQ<Item extends Comparable<Item>>{

	private int[] pq;    // priority-queue of indexs
	private int[] qp;    // pq[qp[i]] = i
	private Item[] keys;
	private int N = 0;

	public IndexMinPQ(int maxN){
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		keys = (Item[]) new Comparable[maxN + 1];  // new Comparable
		for(int i = 0; i < maxN + 1; i ++)
			qp[i] = -1;
	}

	public void insert(int k, Item item){
		keys[k] = item;
		pq[++N] = k;
		qp[k] = N;
		swim(N);
	}

	public void change(int k, Item item){
		keys[k] = item;
		swim(qp[k]);
		sink(qp[k]);
	}

	public boolean contains(int k){
		return qp[k] != -1;
	}

	public void delete(int k){
		int index = qp[k];
		exch(index, N--);
		sink(index);
		swim(index);
		qp[k] = -1;
		keys[k] = null;
	}

	public Item min(){
		return keys[pq[1]];
	}

	public int minIndex(){
		return pq[1];
	}

	public int delMin(){
		int indexOfMin = pq[1];
		exch(1, N--);
		sink(1);
		keys[indexOfMin] = null;
		qp[indexOfMin] = -1;
		pq[N+1] = -1;
		return indexOfMin;
	}

	public boolean isEmpty(){
		return N == 0;
	}

	public int size(){
		return N;
	}

	private void swim(int k){
		while(k > 1 && less(k, k/2)){
			exch(k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k){
		while(2*k <= N){
			int i = 2*k;
			if(i < N && less(i + 1, i)) i++;
			if(!less(i, k)) break;
			exch(k, i);
			k = i;
		}
	}

	private void exch(int i, int j){
		int temp = pq[i]; 
		pq[i] = pq[j]; qp[pq[j]] = i;
		pq[j] = temp; qp[temp] = j;
	}

	private boolean less(int i, int j){
		Item v = keys[pq[i]];
		Item w = keys[pq[j]];
		return v.compareTo(w) < 0;
	}
}