package practice.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @PackgeName: practice.one
 * @ClassName: Solution
 * @Author: XuWen
 * Date: 2020/10/25 20:05
 * Introduce:
 */
class Solution {
    //定义一个类，为car，参数为int初始位置和double时间（到终点需要的时间）
    //然后再根据int类型的初始位置，从大到小的排序，
    //然后根据time来判断，然后如果后面的time<=前面的，说明能追上
    //如果大于，追不上，就是另外一组了
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length==0){
            return 0;
        }
        List<Car> cars = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            cars.add(new Car(position[i],(double)(target-position[i])/speed[i]));
        }
        Collections.sort(cars,(o1, o2)->{
            return o2.startPos-o1.startPos;
        });
        int res=1;
        double time=cars.get(0).time;
        for(int i=0;i<cars.size();i++){
            Car car = cars.get(i);
            if(car.time<=time){
            }else{
                res++;
                time = car.time;
            }
        }
        return res;
    }

    static class Car{
        int startPos;
        double time;

        public Car(int startPos, double time) {
            this.startPos = startPos;
            this.time = time;
        }
    }
}