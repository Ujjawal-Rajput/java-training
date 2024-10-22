import java.util.*;
 
public class Calculator{
    public static void main(String[] args){
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[1]);
        String val3 = args[2];

        switch(val3){
            case "+":
                System.out.print(val1+val2);
                break;              
            case "-":
                System.out.print(val1-val2);
                break;
            case "*":
                System.out.print(val1*val2);
                break;
            case "/":
                System.out.print(val1/val2);
                break;
            default:
                System.out.println("Something went wrong");

        }
    }
}