package algorithmicthinking.design.lru;

import java.util.HashMap;

/**
 * @Author : usva.zhan
 * @Description : least recently used
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 );/* capacity *
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date : 2020/8/7 10:15
 */
public class _0146_LRU_cache {



    private HashMap<Integer,Node> map;
    private DoubleList cache;
    private int capacity;


    public _0146_LRU_cache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key,val);
        return val;
    }

    public void put(int key,int value) {
        Node x = new Node(key,value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key,x);
        } else {
            if (capacity == cache.size()){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key,x);
        }

    }


    public static void main(String[] args) {
        _0146_LRU_cache instance = new _0146_LRU_cache(2);

        int get = -1;
        System.out.println(get);
        instance.put(1,1);
        instance.put(2,2);
        get = instance.get(1);       // returns 1
        System.out.println(get);
        instance.put(3,3);    // evicts key 2
        get = instance.get(2);       // returns -1 (not found)
        System.out.println(get);
        instance.put(4,4);    // evicts key 1
        get = instance.get(1);       // returns -1 (not found)
        System.out.println(get);
        get = instance.get(3);       // returns 3
        System.out.println(get);
        get = instance.get(4);
        System.out.println(get);


    }


}
