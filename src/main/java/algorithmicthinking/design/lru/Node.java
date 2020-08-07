package algorithmicthinking.design.lru;

/**
 * @Author : usva.zhan
 * @Description : 双链表节点类
 * @Date : 2020/8/7 10:49
 */
public class Node {



    public int key,val;
    public Node next,prev;

    Node(int k,int v) {
        this.key = k;
        this.val = v;
    }


}
