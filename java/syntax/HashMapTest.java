import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
public class HashMapTest{
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i = 0; i < 10; i ++)
			map.put(i, "HashMap order " + i);
		System.out.println("HashMap.size():" + map.size());
		System.out.println("HashMap.get(1):" + map.get(1));

		System.out.println("Travel in hashmap via entryset");
		Set<Map.Entry<Integer, String>> entryset = map.entrySet();
		for(Map.Entry<Integer, String> entry: entryset){
			System.out.println("Entry.getKey(): " + entry.getKey() + ", Entry.getValue(): " + entry.getValue());
		}

		for(Integer ir: map.keySet()){
			System.out.println("Key: " + ir + ", HashMap.get(): " + map.get(ir));
		}

		Iterator<Map.Entry<Integer, String>> iterator =  map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer, String> entry = iterator.next();
			System.out.println("Iterator key: " + entry.getKey() + ", Iterator value: " + entry.getValue());
		}

		Iterator<Integer> iter = map.keySet().iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			System.out.println("Integer Iterator key: " + key + ", Integer Iterator value: " + map.get(key));
		}
	}
}