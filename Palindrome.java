import java.util.*;

public class Palindrome{

    static void m1(String s, int n){
        int flag = 0;
        for(int i=0; i<n/2; i++){
            if (!(s.charAt(i) == s.charAt(n-i-1))) flag = 1;
        }

        if (flag == 1) System.out.println("Not Palindrome");
        else System.out.println("Palindrome");
    }
    
    static void m2(String s){
        String n = "";
        for(int i=s.length()-1; i>=0; i--){
            n = n + s.charAt(i);
        }

        if (s.equals(n)) System.out.println("Panindrome");
        else  System.out.println("Not Panindrome");
    }

    public static void main(String[] args){
        String s = "dsaioasd";
        int n = s.length();

        m1(s,n);
        m2(s);
    }
}