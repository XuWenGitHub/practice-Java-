package practice.one;

import java.util.Arrays;

public class ArrayList {
    private int[] elem; //存顺序表的数组
    private int len;    //有效个数

    //构造器
    public ArrayList(int length){
        this.elem=new int[length];
    }
    //添加元素
    //如果有3个元素，只能添加到第四个元素位置或者前面，已有的位置
    public void add(int pos,int date){
        if(pos<0||pos>len){
            System.out.println("pos位置有误");
            return;
        }
        //扩容
        if(this.len==this.elem.length){
            this.elem= Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //先添加的位置是最后一个，还是已经有元素了
        if (pos != len) {
            //表示需要后移
            for (int i = this.len-1; i>=pos; i--) {
                this.elem[i+1] = this.elem[i];
            }
        }
        this.elem[pos]=date;
        this.len++;
    }
    //遍历顺序表
    public void list(){
        for(int i=0;i<this.len;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //根据关键字查找下标，没有找到返回-1
    public int search(int value){
        for(int i=0;i<this.len;i++){
            if(this.elem[i]==value){
                return i;
            }
        }
        return -1;
    }
    //删除第一次出现的关键字key
    public void del(int key){
        int index=search(key);
        if(index==-1){
            System.out.println("没有找到"+key);
        }else{
            for(int i=index+1;i<this.len;i++){
                this.elem[i-1]=this.elem[i];
            }
            this.len--;
        }
    }
}
