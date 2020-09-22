package practice.seven;

import java.util.*;

class Employee{
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
/**
 * @PackgeName: practice.seven
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/21 21:03
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {

    }
    //查询子员工的所有重要值
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null||employees.size()==0){
            return 0;
        }
        //因为id不会重复,我们用个map<Integer,Employee>,就可以直接通过id查找员工
        //不然还要通过employee去找id，太慢了
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee employee:employees){
            map.put(employee.id,employee);
        }
        //我们通过广度优先遍历，来算出res，因为这个就可以看成一个图or树
        int res=0;
        Queue<Integer> queue = new LinkedList<>();  //这个队列来帮助广度优先遍历，存员工id
        queue.offer(id);
        while(!queue.isEmpty()){
            Employee employee = map.get(queue.poll());
            res+=employee.importance;   //添加重要值
            //添加当前员工的下属员工id
            for(Integer subordinate:employee.subordinates){
                queue.offer(subordinate);
            }
        }
        return res;
    }


    /*
    法官不相信任何人，说明法官不存在投票
    所有人都信任法官，说明法官的收到的票为N-1
    那么法官的投票数加收到的票为N-1
    */
    public int findJudge(int N, int[][] trust) {
        //下标就是第几个人,arr[0]我们不用，
        int[] person = new int[N+1];   //记录一个人的收到票和投的票
        for(int[] array:trust){
            person[array[1]]++; //被别人投票
            person[array[0]]--; //自己投票了，那么--，那么就不可能构成N-1
        }
        for(int i=1;i<person.length;i++){
            if(person[i]==N-1){
                return i;
            }
        }
        return -1;

        //被其他所有人信任却不信任何人的人是法官
        //用map<Integer,List<Integer>>,表示几号被哪些人信任
    /*
    小镇的法官不相信任何人。
    每个人（除了小镇法官外）都信任小镇的法官。
    只有一个人同时满足属性 1 和属性 2
    */
        // if(N==1){
        //     return 1;
        // }
        // if(trust.length==1){
        //     return trust[0][1];
        // }
        // if(N==trust.length){
        //     return -1;
        // }
        // //用map数组来存储，第key个人，被value集合中的人投了票
        // Map<Integer,List<Integer>> map = new HashMap<>();

        // for(int i=0;i<trust.length;i++){
        //     int believe = trust[i][0];  //信任的人id
        //     int personId = trust[i][1]; //被信任的人
        //     if(!map.containsKey(personId)){
        //         List<Integer> list = new ArrayList<>();
        //         list.add(believe);
        //         map.put(personId,list);
        //     }else{
        //         List<Integer> list = map.get(personId);
        //         list.add(believe);
        //         map.put(personId,list);
        //     }

        // }
        // //现在所有被信任的人在map的key里面，value是那些人信任了他
        // int id = -1;
        // int count=0;
        // for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
        //     List<Integer> list = entry.getValue();
        //     if(list.size()==N-1){
        //         count++;
        //         id=entry.getKey();
        //     }
        // }
        // if(count>1){
        //     return -1;
        // }

        // boolean flag = false;  //表示当前id的人没有信任别人
        // //判断当前id的人信任别人没有
        // for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
        //     List<Integer> list = entry.getValue();
        //     if(list.contains(id)){
        //         flag=true;
        //     }
        // }
        // if(flag){
        //     return -1;
        // }
        // return id;
    }

    //要能把一个数组划分为，连续的三部分，然后和等于数组的和/3
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;    //求出A数组的和
        for(int i:A){
            sum+=i;
        }
        if(sum%3!=0){
            return false;
        }
        sum/=3; //这是每次要凑的数
        int res = 0;    //这是当前和
        int count=0;    //表示凑够sum的个数
        for(int i=0;i<A.length;i++){
            res+=A[i];
            if(res==sum){
                count++;
                res=0;
            }
        }
        if(count>=3){
            return true;
        }else{
            return false;
        }
    }
}
