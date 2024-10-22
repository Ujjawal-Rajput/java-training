public class Divyansh{

    public static void main(String[] args){
        int n=10; //9

        int count = 1;

        for (int i = 0; i < n; i++) {

            for(int j=0; j < n-i-1; j++ ) System.out.print(" ");

            for(int j=0; j < count; j++) System.out.print("*");

            count += 2;

            System.out.println();
        }
    }
}