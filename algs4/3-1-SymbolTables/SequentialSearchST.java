import java.util.Set;
import java.util.HashSet;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SequentialSearchST<Key, Value>{

	private class Node{
		Key key;
		Value value;
		Node next;
		Node(Key key, Value value, Node next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private Node first;
	private int N;

	public void put(Key key, Value value){
		for(Node pointer = first; pointer != null; pointer = pointer.next)
			if(key.equals(pointer.key)){
				pointer.value = value;
				return;
			}
		first = new Node(key, value, first);
		N++;
	}

	public Value get(Key key){
		for(Node pointer = first; pointer != null; pointer = pointer.next){
			if(key.equals(pointer.key)){
				return pointer.value;
			}
		}
		return null;
	}

	public int size(Key key){
		return N;
	}

	public Iterable<Key> keys(){
		Set<Key> keySet = new HashSet<Key>();
		for(Node pointer = first; pointer != null; pointer = pointer.next)
			keySet.add(pointer.key);
		return keySet;
	}

	public void delete(Key key){
		Node prePointer = first;
		for(Node pointer = first; pointer != null; pointer = pointer.next){
			if(key.equals(pointer.key)){
				if(pointer == first){
					first = first.next;
					pointer.next = null;
					N --;
					return;
				}else{
					prePointer.next = pointer.next;
					pointer.next = null;
					N --;
					return;
				}
			}
			prePointer = pointer;
		}
	}

	public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {  //!StdIn.isEmpty()  using control + z to end the input process.
            String key = StdIn.readString();
            st.put(key, i);
        }
        st.delete("A");
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}