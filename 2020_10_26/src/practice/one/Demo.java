package practice.one;

import java.util.*;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/25 17:48
 * Introduce:
 */
public class Demo {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for(int i=0;i<position.length;i++){
            cars.add(new Car(position[i],(target-position[i])/speed[i]));
        }
        Collections.sort(cars,(o1,o2)->{
            return o2.startPos-o1.startPos;
        });
        int res=1;
        int time=cars.get(0).time;
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
        int time;

        public Car(int startPos, int time) {
            this.startPos = startPos;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return startPos == car.startPos;
        }

        @Override
        public int hashCode() {
            return Objects.hash(startPos);
        }
    }
}
