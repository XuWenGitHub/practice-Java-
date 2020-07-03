package task.two;
/*
计算器:传入两个数字，然后进行运算
 */
public class Calc {
    private int left;
    private int right;
    public Calc(){
        throw new RuntimeException("需要两个操作数");
    }
    public Calc(int left,int right){
        this.left=left;
        this.right=right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int add(){
        return left+right;
    }
    public int sub(){
        return left-right;
    }
    public int mul(){
        return left*right;
    }
    public int div(){
        if(right==0){
            throw new RuntimeException("除数不能为0");
        }
        return left/right;
    }
}
