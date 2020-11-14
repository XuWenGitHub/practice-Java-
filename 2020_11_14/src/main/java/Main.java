public class Main {
    public static void main(String[] args) {
        
    }
    public static int fib(int n,int[] fib){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        if(fib[n]>0){
            return fib[n];
        }
        fib[n] = fib(n-1,fib)+fib(n-2,fib);
        return fib(n-1,fib)+fib(n-2,fib);
    }
}
