package datastructure;

/**
 * @author Richard.Zhan
 * @Description: 节点
 * @date 2020/7/24 14:48
 */
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(){

    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
