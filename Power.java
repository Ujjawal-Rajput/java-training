import java.util.Scanner;

public class Power{
    static int cal(int n, int p){
        int ans = 1;
        for(int i = 1; i<=p; i++){
            ans *= n;
        }
        return ans;
    }


    static int bits(int base, int exponent) {
        int result = 1;
        
        // Loop until all bits of the exponent are processed
        while (exponent > 0) {
            // If the current bit is set (odd exponent), multiply the result by the base
            if ((exponent & 1) == 1) {
                result *= base;
            }
            
            // Square the base and shift the exponent to the right (divide by 2)
            base *= base;
            exponent >>= 1; // Exponent divided by 2
        }
        
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter n : ");
        int n = sc.nextInt();

        System.out.printf("Enter power : ");
        int power = sc.nextInt();

        

        System.out.println(cal(n, power));
        System.out.println(bits(n, power));
        
    }
}