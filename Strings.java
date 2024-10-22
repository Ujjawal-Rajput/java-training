// .equals compares the 2 actual strings.

public class Strings{
    public static void main(String[] args){
        String name1 = "ujju";
        String name2 = "ujju";

        System.out.println(name1 == name2);
        System.out.println(name1.equals(name2));

        name1.toLowerCase();

        String s = new String("ujju");

        System.out.println(name1 == s);
        System.out.println(name1.equals(s));



        System.out.println(name1.compareTo(s));
        System.out.println('a'- (int)'y');
        


    }
}