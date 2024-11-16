public class Recursion{

    static void count(int n){
        if (n==0) return;
        System.err.println(n);
        count(n-1);
    }
    public static void main(String[] args){
        count(5);
    }
}