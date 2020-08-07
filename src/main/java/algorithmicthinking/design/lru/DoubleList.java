package algorithmicthinking.design.lru;

/**
 * @Author : usva.zhan
 * @Description : 双链表
 * @Date : 2020/8/7 10:54
 */
public class DoubleList {


    private Node head,tail;
    private int size;

    public void addFirst(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            Node n = head;
            n.prev = node;
            node.next = n;
            head = node;
        }
        size++;
    }

    public void remove (Node node) {
        if (head == node && tail == node) {
            head = null;
            tail = null;
        } else if (tail == node) {
            node.prev.next = null;
            tail = node.prev;
        } else if (head == node) {
            node.next.prev = null;
            head = node.next;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }


    public Node removeLast(){
        Node node = tail;
        remove(tail);
        return node;
    }

    public int size(){
        return size;
    }



}
