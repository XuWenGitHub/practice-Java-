package practice.two;

import java.util.*;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/15 12:57
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.add(3);
        queue.add(2);
        queue.add(7);
        queue.add(5);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        PriorityQueue<List<Integer>> queue1 = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> integers, List<Integer> t1) {
                return integers.get(0)+integers.get(1)-t1.get(0)-t1.get(1);
            }
        });

        PriorityQueue<List<Integer>> queue2 = new PriorityQueue<>((o1,o2)->{
            return o2.get(0)+o2.get(1)-o1.get(0)-o1.get(1);
        });
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(4);
        queue1.add(list1);
        queue1.add(list2);
        System.out.println(queue1.poll());
    }
    //建堆
    public static void create(int[] array,int size){
        //找到层序遍历的最后一个节点下标
        int lastIndex = size-1;
        //找到最后一个节点的父节点的下标
        int lastParentIndex = (lastIndex-1)/2;
        //从[lastParentIndex,0] 不断的向下调整
        for(int i=lastParentIndex;i>=0;i--){
            downAdjust(array,size,i);
        }
    }

    /**
     * 小顶堆的向下调整操作
     * @param array 完全二叉树数组形式表示
     * @param size  数组的长度
     * @param index 需要向下调整的位置
     */
    public static void downAdjust(int[] array,int size,int index){
        while (true) {
            //先判断index对应的下标是不是叶子结点，如果是叶子结点，直接return
            //因为叶子结点说明满足小顶堆的特征了，向下调整不了了
            int leftIndex = index * 2 + 1;  //左孩子的下标
            if (leftIndex >= size) {    //如果左孩子都越界了，右孩子一定越界
                return; //说明到叶子结点了
            }

            //走到这里一定有左孩子，因为上面判断了
            //找到两个孩子中最小的
            int minIndex = leftIndex;   //假设最小孩子是左孩子节点
            int rightIndex = leftIndex + 1; //右孩子的下标
            if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
                minIndex = rightIndex;
            }


            //3.最小孩子的值和index对应的位置进行比较
            //如果minVal>=index对应的值，说明满足堆的性质，return
            if (array[minIndex] >= array[index]) {
                return;
            }

            //4.说明最小孩子的值小于index对应的位置的值
            //那么交换小孩子的值和index位置的值
            array[minIndex] ^= array[index];
            array[index] ^= array[minIndex];
            array[minIndex] ^= array[index];

            //5.把最小的孩子视为index，循环回去
            index = minIndex;
        }
    }

    //小顶堆向上调整
    public static void adjustUp(int[] arr,int size,int index){
        //1.判断index是不是树的根，如果是根调整结束
        //2.找到index的父节点
        //3.比较父节点的值和index的值
        //4.只要父节点的值<=index的值，调整结束
        //5.交换父节点和index位置的值
        //6.把父节点看做index，继续这个大循环
        while (true){
            //如果是根节点直接返回，就说明向上调整结束
            if(index<=0){   //<0说明给的数据有误
                return;
            }
            //找到父节点
            int parentIndex = (index-1)/2;
            //判断父节点是否比index位置的节点大，如果大交换
            //如果小于或者等于就说明满足堆的性质了
            if(arr[parentIndex]<=arr[index]){
                return;
            }
            //说明父节点比index位置的节点大，两个交换
            int t = arr[parentIndex];
            arr[parentIndex] = arr[index];
            arr[index] = arr[parentIndex];
            //再把父节点位置的下标去做向上调整
            index = parentIndex;
        }
    }
}
