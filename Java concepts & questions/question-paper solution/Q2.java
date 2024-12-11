class ABC{
    int a,b;
    public ABC(int a, int b){
            a=a;
            b=b;
        }
    public void show(){
        System.out.println(a);
        System.out.println(b);
    }
}

public class Q2{
    public static void main(String[] args) {
        ABC a,b;

        a = new ABC(10,90);
        a.show();
        // b = new ABC(); // must specify default constructor
        // b.show();
    }
}