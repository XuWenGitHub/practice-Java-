package practice.sort;

/**
 * @PackgeName: practice.sort
 * @ClassName: HeapSort
 * @Author: XuWen
 * Date: 2020/10/19 17:05
 * Introduce:
 */
public class HeapSort implements Sort {
    @Override
    public String getName() {
        return "堆排序";
    }

    @Override
    public void sort(int[] arr) {
        heapSort(arr);
    }
    private void heapSort(int[] arr){
        createHeap(arr,arr.length);
        for(int i=0;i<arr.length-1;i++){
            int maxVal = arr[0];    //取出大顶堆的第一个
            arr[0] = arr[arr.length-1-i];
            arr[arr.length-1-i] = maxVal;
            adjustDown(arr,arr.length-1-i,0);
        }
    }
    private void createHeap(int[] arr,int size){
        int lastIndex = size-1;
        int lastIndexParent = (lastIndex-1)/2;
        for(int i=lastIndexParent;i>=0;i--){
            adjustDown(arr,size,i);
        }
    }
    //向下调整index位置
    private void adjustDown(int[] arr,int size,int index){
        while (true){
            int leftIndex = 2*index+1;
            if(leftIndex>=size){
                break;  //该index下标为叶子结点
            }
            int maxIndex = leftIndex;
            if((leftIndex+1)<size&&arr[leftIndex+1]>arr[leftIndex]){
                maxIndex = leftIndex+1;
            }
            //判断是否满足大顶堆
            if(arr[index]>=arr[maxIndex]){
                break;
            }
            //如果走到这里，两者交换，再判断maxIndex是否满足大顶堆
            int t = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = t;
            index = maxIndex;
        }
    }
}
