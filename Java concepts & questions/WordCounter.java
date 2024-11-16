import java.util.Scanner;

public class WordCounter{
    public static void main(String[] args){
        Scanner sc = new Scanner("hjbh hjhj hjhj");

        int c = 0;
        while(sc.hasNext()){
            sc.next();
            c++;
        }
        System.out.println(c);
    }
}