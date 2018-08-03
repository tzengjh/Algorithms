import java.util.*;
import java.lang.*;

public class FeaturesCombine{

    public static List<String> combine(Map<String, List<Integer>> map,  List<String> features){
        List<String> list = new ArrayList<String>();
        String prefix = "comb";
        for(String feature: features){
            prefix = prefix + "_" + feature;
        }

        List<String> afters = combine(map, 0, features);
        for(String after: afters){
            list.add(prefix + after);
        }
        return list;
    }

    private static List<String> combine(Map<String, List<Integer>> map, int lo, List<String> features){
        List<String> list = new ArrayList<String>();
        if(lo == features.size() - 1){
            List<Integer> values = map.get(features.get(lo));
            for(int i = 0; i < values.size(); i ++){
                list.add("_"+values.get(i));
            }
        }else{
            List<String> afters = combine(map, lo + 1, features);
            List<Integer> values = map.get(features.get(lo));
            for(int i = 0; i < values.size(); i ++){
                for(String s: afters){
                    list.add("_" + values.get(i) + s);
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        List<Integer> gender = new ArrayList<Integer>();
        gender.add(0);
        gender.add(1);

        List<Integer> age = new ArrayList<Integer>();
        age.add(1);
        age.add(2);
        age.add(3);

        List<Integer> city = new ArrayList<Integer>();
        city.add(1);
        city.add(2);
        city.add(3);
        city.add(10);

        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        map.put("gender", gender);
        map.put("age", age);
        map.put("city", city);

        List<String> features = new ArrayList<String>();
        features.add("gender");
        features.add("age");

        List<String> comb = combine(map, features);
        for(String str: comb){
            System.out.println(str);
        }
    }
}
