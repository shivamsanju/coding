package test;

import hashmap.HashMap;
import hashmap.KeyValuePair;

public class HashMapTest {
    public static void main(String[] args) {
        // Test Case 1: Basic operations with default capacity
        System.out.println("Test Case 1: Basic operations with default capacity");
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.set("one", 1);
        map.set("two", 2);
        map.set("three", 3);

        assert map.get("one") == 1 : "Expected 1 for key 'one'";
        assert map.get("two") == 2 : "Expected 2 for key 'two'";
        assert map.get("three") == 3 : "Expected 3 for key 'three'";
        assert map.get("four") == null : "Expected null for key 'four'";

        map.remove("two");
        assert map.get("two") == null : "Expected null for removed key 'two'";
        assert map.contains("one") : "Expected 'one' to be in the map";
        assert !map.contains("two") : "Expected 'two' not to be in the map";

        KeyValuePair<String, Integer>[] entries = map.entries();
        assert entries.length == 2 : "Expected 2 entries in the map";

        // Test Case 2: Operations with custom capacity
        System.out.println("\nTest Case 2: Operations with custom capacity");
        HashMap<String, String> map2 = new HashMap<String, String>(32);

        map2.set("apple", "fruit");
        map2.set("carrot", "vegetable");
        map2.set("spinach", "vegetable");

        assert map2.get("apple").equals("fruit") : "Expected 'fruit' for key 'apple'";
        assert map2.get("carrot").equals("vegetable") : "Expected 'vegetable' for key 'carrot'";
        assert map2.get("spinach").equals("vegetable") : "Expected 'vegetable' for key 'spinach'";

        map2.remove("carrot");
        assert map2.get("carrot") == null : "Expected null for removed key 'carrot'";
        assert map2.contains("apple") : "Expected 'apple' to be in the map";
        assert !map2.contains("carrot") : "Expected 'carrot' not to be in the map";

        KeyValuePair<String, String>[] entries2 = map2.entries();
        assert entries2.length == 2 : "Expected 2 entries in the map";

        // Test Case 3: Remove non-existing key
        System.out.println("\nTest Case 3: Remove non-existing key");
        HashMap<String, Integer> map3 = new HashMap<String, Integer>();
        map3.set("a", 1);
        map3.remove("b"); // Non-existing key
        assert map3.get("a") == 1 : "Expected 1 for key 'a'";

        // Test Case 4: Adding duplicate keys
        System.out.println("\nTest Case 4: Adding duplicate keys");
        HashMap<String, String> map4 = new HashMap<String, String>();
        map4.set("key1", "value1");
        map4.set("key1", "value2"); // Update value for existing key
        assert map4.get("key1").equals("value2") : "Expected 'value2' for key 'key1'";

        // Test Case 5: Checking map size
        System.out.println("\nTest Case 5: Checking map size");
        HashMap<Integer, Integer> map5 = new HashMap<Integer, Integer>(10);
        assert map5.size == 0 : "Expected size 0 initially";
        map5.set(1, 10);
        map5.set(2, 20);
        assert map5.size == 2 : "Expected size 2 after adding 2 entries";
        map5.remove(1);
        assert map5.size == 1 : "Expected size 1 after removing 1 entry";

        // Test Case 6: Handle null keys and values
        System.out.println("\nTest Case 6: Handle null keys and values");
        HashMap<String, String> map6 = new HashMap<String, String>();
        map6.set(null, "nullKey");
        map6.set("key", null);

        assert map6.get(null).equals("nullKey") : "Expected 'nullKey' for null key";
        assert map6.get("key") == null : "Expected null for key 'key'";

        map6.remove(null);
        assert map6.get(null) == null : "Expected null for removed null key";

        System.out.println("All test cases passed.");
    }
}
