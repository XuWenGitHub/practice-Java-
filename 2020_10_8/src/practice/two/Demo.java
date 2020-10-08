package practice.two;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/8 22:19
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    /*
    给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后      数组的新长度。
    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    */
    //双指针方法
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
