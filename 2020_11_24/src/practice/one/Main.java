package practice.one;
class Test{
    public static void hello(){
        System.out.println("hello");
    }
}
public class Main {

    public static void main(String[] args) {
        Test test = null;
        test.hello();
        Object o = new Main();
        int[] arr = new int[]{1,2,3,4,5,6,7,0};

    }
    public int count(int[] A, int n) {
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(A[i]>A[j]){
                    res++;
                }
            }
        }
        return res;
    }

}
