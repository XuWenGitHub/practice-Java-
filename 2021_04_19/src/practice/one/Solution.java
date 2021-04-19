package practice.one;

class Solution {
    //接雨水
    //每一列中，获取当前列中左边最高的柱子left，右边最高的柱子right
    //每一列判断其接多少水
    //获取其left（左边最高的柱子）和right（右边最高的柱子）中的最小值min
    //判断当前列的值val，val<min，那么说明可以接(min-val)的雨水
    //val>=min，那么说明接不了雨水
    //leftDp[i]表示第i列，左边最高的柱子高度
    //leftDp[i] = Max(left[i-1],height[i-1]);
    //第i列，左边最高的柱子高度=max(第i-1列左边最高的柱子高度，第i-1列的高度)
    //rightDp同理可得
    public int trap(int[] height) {
        if(height==null||height.length<=1){
            return 0;
        }
        int[] leftDp = new int[height.length];
        int[] rightDp = new int[height.length];
        int res = 0;
        leftDp[0] = 0;
        for(int i=1;i<leftDp.length;i++){
            leftDp[i] = Math.max(leftDp[i-1],height[i-1]);
        }
        rightDp[rightDp.length-1] = 0;
        for(int i=rightDp.length-2;i>=0;i--){
            rightDp[i] = Math.max(rightDp[i+1],height[i+1]);
        }

        for(int i=0;i<height.length;i++){
            int min = Math.min(leftDp[i],rightDp[i]);
            if(min>height[i]){
                res+=(min-height[i]);
            }
        }
        return res;
    }
}
