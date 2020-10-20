package practice.sort;

/**
 * @PackgeName: practice.sort
 * @ClassName: ShellSort
 * @Author: XuWen
 * Date: 2020/10/19 16:57
 * Introduce:
 */
public class ShellSort implements Sort {
    @Override
    public String getName() {
        return "希尔排序";
    }

    @Override
    public void sort(int[] arr) {
        shellSort(arr);
    }
    private void shellSort(int[] arr){
        int group = arr.length/2;
        while (group>0){
            //分组插入排序
            groupInsertSort(arr,group);
            group/=2;
        }
    }
    //分组插入排序
    private void groupInsertSort(int[] arr,int group){
        for(int i=group;i<arr.length;i++){
            int temp = arr[i];  //待插入元素
            int j;
            for(j=i-group;j>=0;j-=group){
                if(arr[j]>temp){    //前面的大于待插入元素，j下标往前移group步
                    arr[j+group] = arr[j];
                }else{  //前面的小于等于待插入元素，break，然后待插入位置为j+group
                    break;
                }
            }
            arr[j+group] = temp;
        }
    }
}
