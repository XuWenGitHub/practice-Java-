package practice.three;
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/20 18:33
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }



    /*
    合并两个有序的链表，合成一个新的链表
    分析；创建一个新的链表，然后遍历l1和l2，然后往新的链表后面添加，最后返回新的链表
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        ListNode puppet = new ListNode(-1);
        ListNode puppetCur = puppet;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                puppetCur.next = l1;
                l1 = l1.next;
            }else{
                puppetCur.next = l2;
                l2 = l2.next;
            }
            puppetCur = puppetCur.next;
        }
        if(l1==null){
            puppetCur.next = l2;
        }else{
            puppetCur.next = l1;
        }
        return puppet.next;
    }

    //让一个数组中的奇数位于偶数前面
    public int[] exchange(int[] nums) {
        int left=0;
        int right = nums.length-1;
        while(left<right){
            while(left<nums.length&&nums[left]%2==1){
                left++;
            }
            while(right>=0&&nums[right]%2==0){
                right--;
            }
            if(left<right){
                nums[left]^=nums[right];
                nums[right]^=nums[left];
                nums[left]^=nums[right];
            }
        }
        return nums;
    }
}
