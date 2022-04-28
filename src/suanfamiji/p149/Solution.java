package suanfamiji.p149;

/**
 * 本文件的功能，是教会你如何写LRU算法（粗略的知道）
 * LRU 算法的核⼼数据结构是使⽤哈希链表 LinkedHashMap，⾸先借助链表的有序性使得链表元素维持插⼊
 * 顺序，同时借助哈希映射的快速访问能⼒使得我们可以在 O(1) 时间访问链表的任意元素。
 */

import java.util.HashMap;
import java.util.Hashtable;

public class Solution {
    //尝试自己实现一个双向链表

    public class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    public class DoubleList {
        private Node start, tail;
        private int size;

        DoubleList() {
            start = new Node(0, 0);
            tail = new Node(0, 0);
            start.next = tail;
            tail.prev = start;
            size = 0;
        }

        /**
         * 在链表的尾部中添加数据
         *
         * @param node
         */
        public void addLast(Node node) {
            Node pre = tail.prev;
            pre.next = node;
            node.prev = pre;
            node.next = tail;
            tail.prev = node;
            size++;
        }

        /**
         * 删除指定节点，因为是双向链表，可以直接删除了
         *
         * @param x
         */
        public void remove(Node x) {

            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst() {
            //删除数组的时候，先进行判定，是否存在该内容
            //看吧，已经错了，如果该列表是空的话，直接就报错了
            if (size == 0) {
                return null;
            }
            Node x = start.next;
            remove(x);
            return x;
        }

        public int size() {
            return size;
        }
    }

    class LRUCache {
        // key -> Node(key, val)
        private HashMap<Integer, Node> map;
        // Node(k1, v1) <-> Node(k2, v2)...
        private DoubleList cache;
        // 最⼤容量
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }
        /**
         * 为了保证运行的效率，始终是用map进行key的查找，找到具体的对象以后，对对象进行操作
         *  操作多重数据的时候，抽象一层API，避免让LRU的主方法get和put直接操作map和cache中的细节，可以实现这样的函数
         * 将某个Key提升为最常使用的
         */
        private void makeRecently(int key){
            Node node = map.get(key);
            cache.remove(node);
            cache.addLast(node);
        }
        private void addRecently(int key,int val){
            Node node = new Node(key,val);
            map.put(key,node);
            cache.addLast(node);
        }
        private void removeKey(int key){
            if(cache.size ==0) return ;
            Node node = map.get(key);
            map.remove(key);
            cache.remove(node);
        }

        private void removeLeastRecently(){
            Node node = cache.removeFirst();
            if(node ==null) return ;
            int deleteNodeKey = node.key;
            map.remove(deleteNodeKey);
        }

        public int get(int key){
            if(!map.containsKey(key)){
                return -1;
            }
            makeRecently(key);
            Node node = map.get(key);
            return node.val;
        }
        public void put(int key,int val){
            if(map.containsKey(key)){
                removeKey(key);
                addRecently(key, val);
            }
            else{
                if(cap<=map.size()){
                    removeLeastRecently();
                }
                addRecently(key, val);
            }
        }


    }


}