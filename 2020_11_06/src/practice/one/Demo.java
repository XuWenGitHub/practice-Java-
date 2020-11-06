package practice.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/11/5 18:35
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        //List<Integer> list = new ArrayList<>();
        System.out.println(('t'-'a'));
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(4);
        binarySearchTree.add(5);
        binarySearchTree.add(1);
        binarySearchTree.add(6);
        binarySearchTree.add(2);
        binarySearchTree.add(0);
        binarySearchTree.add(3);
        binarySearchTree.remove(2);
//        binarySearchTree.remove(3);
        binarySearchTree.remove(1);
        for(int i=0;i<8;i++){
            System.out.println(binarySearchTree.find(i));
        }
        binarySearchTree.infixOrder();

        Map<Character,List<Integer>> sCharToIndex = new HashMap<>();

        
    }

}
