import java.util.*;

public class Swap{

    static void addsub(int a,int b){
        System.out.println("a : " + a + ", b : " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        
        System.out.println("a : " + a + ", b : " + b);
    }
    static void muldiv(int a, int b){
        System.out.println("a : " + a + ", b : " + b);
        a = a * b;
        b = a / b;
        a = a / b;
        
        System.out.println("a : " + a + ", b : " + b);
    }
    static void xorr(int a, int b){
        System.out.println("a : " + a + ", b : " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        
        System.out.println("a : " + a + ", b : " + b + "नमस्ते");
    }
    public static void main(String[] args){
        int a = 6;
        int b = 2;

        addsub(a,b);
        muldiv(a,b);
        xorr(a,b);
        
    } 
}