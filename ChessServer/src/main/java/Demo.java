import chess.entity.ChessPoint;
import chess.entity.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Demo {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("xw");
        user.setStatus(User.StatusEnum.LOGIN);
        ChessPoint start = new ChessPoint();
        start.setIconName("asdas");
        user.setStartPoint(start);
        //JSON序列化
        String str = JSON.toJSONString(user);
        System.out.println(str);

        //JSON反序列化，引用指向的对象还有引用类型也可以
        User user1 = JSON.parseObject(str, User.class);

        System.out.println(user1);
        System.out.println(user1.getUsername());
        System.out.println(user1.getStatus());
        ChessPoint startPoint = user1.getStartPoint();
        System.out.println(startPoint.getIconName());

//        Person person = new Person("xw",12);
//        Person person1 = new Person("ws",123);
//        person.setP(person1);
//
//        String str = JSON.toJSONString(person);
//        System.out.println(str);
//
//        Person person2 = JSON.parseObject(str,Person.class);
//        Person p = person2.p;
//        System.out.println(person2.id+person2.name+p.id+p.name);


//        JSONObject object2 = new JSONObject();
//        object2.put("name",person1.name);
//        object2.put("id",person1.id);
//        JSONObject object = new JSONObject();
//        object.put("id",person.id);
//        object.put("name",person.name);
//        object.put("preson",object2);
//
//        String str = object.toJSONString();
//        System.out.println(str);
//
//        JSONObject object1 = JSONObject.parseObject(str);
//        Object name = object1.get("name");
//        Object id = object1.get("id");
//        Object person2 = object1.get("person");
//        //JSONObject.parseObject(person2.toString());
////        System.out.println(person2.toString());
//        System.out.println(name+" "+id);
    }
    static class Person{
        String name;
        int id;
        Person p;
        public Person(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public Person getP() {
            return p;
        }

        public void setP(Person p) {
            this.p = p;
        }
    }
}
