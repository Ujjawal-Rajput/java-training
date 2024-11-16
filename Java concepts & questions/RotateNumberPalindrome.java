public class RotateNumberPalindrome{
    // if rotation is -ve -> put front to back
    // if rotation is +ve -> put back to front
    static boolean isPalindrome(int n, int len){
        int cp = n;
        len = len-1;

        int rev = 0;
        while(cp>0){
            int dig = cp%10;
            cp = cp/10;
            rev += dig*Math.pow(10,len); // 1*100 + 2*10 + 1 = 121
            len--;
        }

        System.out.println(n);

        if (rev == n) return true;
        else return  false;
    }
    public static void main(String[] args){
        int val = 112;
        int n=3; // 54545

        int flag = 0;
        for(int i=0; i<n-1; i++){
            int dig = val%10; // 2
            val = val/10; //11
            

            for(int j=0; j<n-1; j++){
                dig *= 10; // 200
            } 

            val = dig + val; // 211

            if (isPalindrome(val,n)){
                flag = 1;
                System.out.println(val + " is palindrome");
            }
        }

        if (flag==0){
            System.out.println("No palindrome found");
        }
    }
}