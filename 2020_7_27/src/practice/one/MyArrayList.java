package practice.one;

import java.util.Arrays;

public class MyArrayList {
    private int[] elem;
    private int useSize;    //表示当前有效元素个数

    //构造器
    public MyArrayList(int len) {
        elem=new int[len];
    }

    //打印顺序表
    public void display(){
        System.out.print("[");
        for(int i=0;i<this.useSize;i++){
            if(i==this.useSize-1){
                System.out.print(elem[i]+"]");
            }else{
                System.out.print(elem[i]+", ");
            }
        }
        System.out.println();
    }

    //判断是否包含某个元素
    public boolean contains(int findValue){
        boolean flag=false;
        for(int i=0;i<useSize;i++){
            if(elem[i]==findValue){
                flag=true;
                break;
            }
        }
        return flag;
    }

    //去查找某个对应的位置，找不到返回-1
    public int search(int value){
        for(int i=0;i<useSize;i++){
            if(elem[i]==value){
                return i;
            }
        }
        return -1;
    }

    //获取pos位置的元素getpos
    public int getPos(int pos){
        if(pos<0||pos>=useSize){
            return -1;
        }
        return elem[pos];
    }

    //给pos位置的元素设为value
    public void setPosValue(int pos,int value){
        if(pos<0||pos>=useSize){
            System.out.println("pos位置有误");
            return;
        }
        elem[pos]=value;
    }

    //删除第一次出现的关键字key
    public void delKey(int key){
        int index=search(key);   //第一次出现key关键字的索引，如果最后还是没有出现，就是-1
        if(index==-1){
            System.out.println("没有找到关键字key");
        }else{
            for(int i=index+1;i<useSize;i++){
                elem[i-1]=elem[i];
            }
            this.useSize--;
        }
    }

    //获取长度
    public int length(){
        return useSize;
    }

    /**
     * 如果数组里面的元素是引用类型，一定要用for循环来给元素置空
     * 不然垃圾回收器回收不了，就会造成内存泄漏
     */
    //清空顺序表
    public void clear(){
        this.useSize=0;
    }

    //在pos位置新增元素
    //每次放都要确定前面都有元素
    //如果放的位置有元素，把pos位置原有的元素后移
    public void add(int pos,int data){
        //判断pos前面都有元素
        if(pos>useSize||pos<0){
            System.out.println("当前位置不合法");
            return;
        }
        //扩容
        if(useSize==elem.length){
            this.elem=Arrays.copyOf(elem,2*elem.length);
        }
        //现在判断当前位置是否有元素
        boolean flag=false;
        if(pos<useSize){
            flag=true;  //表示前面有元素了
        }
        //现在根据flag，判断是直接添加，还是需要后移前面的元素
        if(flag){
            //表示前面有元素，把前面元素后移
            for(int i=useSize-1;i>=pos;i--){
                elem[i+1]=elem[i];
            }
            //添加元素
            elem[pos]=data;
            useSize++;
        }else{
            elem[pos]=data;
            useSize++;
        }
    }
}
