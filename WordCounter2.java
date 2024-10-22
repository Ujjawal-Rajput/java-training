// WordCounter2.java

import java.util.Scanner;

public class WordCounter2{
    public static void main(String[] args){
        String s = "ii";
        int w = 0;
        s = s.trim();

        for(int i=0; i<s.length()-1; i++){
            // if (s.charAt(i) == ' ') w++;
            if (s.charAt(i) == ' ' && s.charAt(i+1) != ' ') w++;
        }

        System.out.println(w+1);
    }
}