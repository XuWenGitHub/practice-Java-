package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: MyPriorityQueue
 * @Author: XuWen
 * Date: 2020/10/15 14:26
 * Introduce:自己用小顶堆实现优先级队列
 */
public class MyPriorityQueue {
    private Integer[] array;
    private int size;   //元素个数

    public MyPriorityQueue(){
        //简单起见，不考虑扩容了
        array = new Integer[100];
        size = 0;
    }

    //显示第一个元素
    public Integer element(){
        if(size==0){
            throw new RuntimeException("空了");
        }
        return array[0];
    }

    //每次拿堆中最后一个元素，然后替换第一个元素
    //然后再对第一个元素进行向下调整,时间复杂度：O(log n)
    public Integer remove(){
        if(size==0){
            throw new RuntimeException("空了");
        }
        int e = array[0];
        array[0] = array[size-1];
        size--;

        adjustDown(0);
        return e;
    }

    //插入元素
    //就是直接插入到二叉树的队尾，然后让它向上调整
    public void add(Integer e){
        array[size] = e;
        size++;
        adjustUp(size-1);
    }

    //向上调整方法


    //向下调整方法
    private void adjustDown(int index){
        while (true){
            int leftIndex = index*2+1;
            if(leftIndex>=size){
                return;
            }
            //找到最小孩子
            int rightIndex = leftIndex+1;
            int minIndex = leftIndex;
            if(rightIndex<size&&array[rightIndex]<array[leftIndex]){
                minIndex = rightIndex;
            }
            //作比较，看是否满足堆的性质
            if(array[index]<=array[minIndex]){
                return;
            }
            //不满足就交换
            int temp=array[index];
            array[index] = array[minIndex];
            array[minIndex] = temp;
            //交换后，把最小孩子的index赋值给index，循环，继续重复上面的操作
            index = minIndex;
        }
    }

    //小顶堆向上调整
    private void adjustUp(int index){
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
            if(array[parentIndex]<=array[index]){
                return;
            }
            //说明父节点比index位置的节点大，两个交换
            Integer t = array[parentIndex];
            array[parentIndex] = array[index];
            array[index] = t;
            //再把父节点位置的下标去做向上调整
            index = parentIndex;
        }
    }

}
