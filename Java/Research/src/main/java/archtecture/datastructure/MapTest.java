package archtecture.datastructure;

/**
 * Created by yjw on 18-6-8.
 */

import java.util.*;

/***
 * @link {https://baike.xsoftlab.net/view/250.html}
 */
public class MapTest {

    public static void testSortHashMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("b", "b");
        map.put("a", "c");
        map.put("c", "a");

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + " : " + mapping.getValue());
        }
    }

    public static void testTreeMap() {
        Map<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        map.put("b", "b");
        map.put("a", "c");
        map.put("c", "a");
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }


}
