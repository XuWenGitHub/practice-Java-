package practice.three;

/**
 * @PackgeName: practice.three
 * @ClassName: Node
 * @Author: XuWen
 * Date: 2020/10/14 18:49
 * Introduce:
 */
public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
