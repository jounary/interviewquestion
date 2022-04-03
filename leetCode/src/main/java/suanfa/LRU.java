package suanfa;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    //对于LRU算法，需要构建一个节点结构
    class node{
        public int key;
        public int value;
        public node next,prev;
        public node(){};
        public node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,node> dm= new HashMap<>();
    private int size;
    private int capacity;
    private node head,tail;

    public void LRUcache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new node();
        tail = new node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        node node1 = dm.get(key);
        if (node1 == null){
            return -1;
        }
        moveToHead(node1);
        return node1.value;
    }

    private void deleteNode(node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addHeadNode(node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(node node1) {
        deleteNode(node1);
        addHeadNode(node1);
    }

    public void put(int key, int value){
        node m = dm.get(key);
        if(m == null){
            node newNode = new node(key,value);
            dm.put(key,newNode);
            addHeadNode(newNode);
            ++size;
            if(size > capacity){
                node tail = removeTail();
                dm.remove(tail.value);
            }
        } else {
            m.value = value;
            moveToHead(m);
        }
    }

    private node removeTail() {
        node tail1;
        tail1 = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        return tail1;
    }

    public static void main(String[] args) {

    }
}
