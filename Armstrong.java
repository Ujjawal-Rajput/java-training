import java.util.Scanner;

public class Armstrong{
    static int cal(int n, int p){
        int ans = 1;
        for(int i = 1; i<=p; i++){
            ans *= n;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //153
        int cp = n;

        int digits = 0;
        while(cp>0){
            digits++;
            cp = cp/10;
        }

        cp = n;
        int ans = 0;

        while(cp>0){
            int dig = cp%10;
            cp=cp/10;
            ans = ans + cal(dig, digits);
        }

        if (n==ans) System.out.println("armstrong");
        else System.out.println("not armstrong");


    }
}