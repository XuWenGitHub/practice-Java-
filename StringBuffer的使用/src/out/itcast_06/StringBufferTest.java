package out.itcast_06;

/*把数组拼接成一个字符串*/
public class StringBufferTest {
    public static void main(String[] args) {
        //定义一个数组
        int[] array= {11, 22, 33, 44, 55};

        //调用String做拼接的方法
        System.out.println(arrayToString(array));
        //用StringBuffer做拼接的方法
        System.out.println(arrayToString2(array));


    }

    //用StringBuffer做拼接
    public static String arrayToString2(int[] array){
        StringBuffer sb = new StringBuffer();

        sb.append("[");
        for(int i=0;i<array.length;i++){
            if(i==array.length-1){
                sb.append(array[i]);
            }else {
                sb.append(array[i]).append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    //用String做拼接的方式（效率低，内存空间开辟了很多个新的字符串，浪费内存空间）
    public static String arrayToString(int[] array){
        String s = "";

        s+="[";
        for(int i=0;i<array.length;i++){
            if(i==array.length-1){
                s+=array[i];
                s+="]";
            }else{
                s+=array[i];
                s+=", ";
            }
        }

        return  s;
    }
}
