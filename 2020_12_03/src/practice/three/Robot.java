package practice.three;

import java.util.*;

//机器人走方格1
public class Robot {
    static int a;
    static int b;
    public int countWays(int x, int y) {
        // write code here
        a = x;
        b = y;
        return way(1,1);
    }
    //当前坐标
    public int way(int x,int y){
        if(x==a&&y==b){
            return 1;
        }
        if(x>a||y>b){
            return 0;
        }
        int down = way(x+1,y);
        int right = way(x,y+1);
        return down+right;
    }
}
