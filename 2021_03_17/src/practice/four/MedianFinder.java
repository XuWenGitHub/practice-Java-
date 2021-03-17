package practice.four;

import java.util.PriorityQueue;

public class MedianFinder {
    /*
    小顶堆A，存储数值较大的一半
    大顶堆B，存储较小的一半
    如果元素总个数为奇数，要维持，小顶堆中，元素数大于大顶堆，这样中位数，就是小顶堆的堆顶
    如果元素个数为偶数，那么中位数，就是大顶堆堆顶和小顶堆堆顶元素和/2
    当a和b中元素个数不同，那么一定是小顶堆中数值较大的多一个，所以需要往大顶堆中添加一个数值较小的
    那么将新元素添加到小顶堆，然后再把小顶堆堆顶元素poll出来添加到大顶堆中
    当a和b中元素个数相同的时候，那么需要往小顶堆中扔一个比较大的元素
    那么将新元素添加到大顶堆，再将大顶堆堆顶元素poll出来添加到小顶堆中
    */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
        minHeap = new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });
    }

    //添加数
    public void addNum(int num) {
        if(minHeap.size()!=maxHeap.size()){ //表示目前小顶堆多一个
            //将当前元素，加入小顶堆，然后从拿出小顶堆堆顶元素加入到大顶堆中
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }else{  //表示目前小顶堆和大顶堆一样多
            //将当前元素，加入大顶堆，然后拿出堆顶元素放入小顶堆
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    //查找当前数据中的中位数
    public double findMedian() {
        return maxHeap.size()!=minHeap.size()?minHeap.peek()*1.0:(minHeap.peek()+maxHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
