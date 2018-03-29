/**
* Implement a hashmap that has the following methods with O(1) complexity.
* 1. set(key, value)
* 2. get(key, defaultValue)
* 3. setAll(value)
*/
import java.util.HashMap;

public class HashOOne{
  private long setAllSystemTime;
  private int globalValue;
  private HashMap<Integer, Integer> keyValue = new HashMap<Integer, Integer>();
  private HashMap<Integer, Long> keySetTime = new HashMap<Integer, Long>();

  public HashOOne(){
    setAllSystemTime = System.currentTimeMillis();
  }

  public void set(int key, int value){
    keyValue.put(key, value);
    keySetTime.put(key, System.currentTimeMillis());
  }

  public int get(int key, int defaultValue){
    if(keySetTime.get(key) == null)
      return defaultValue;
    if(keySetTime.get(key) < setAllSystemTime)
      return globalValue;
    else
      return keyValue.get(key);
  }
  
  public void setAll(int value){
    setAllSystemTime = System.currentTimeMillis();
    globalValue = value;
  }
    
}