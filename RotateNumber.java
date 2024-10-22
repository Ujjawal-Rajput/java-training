public class RotateNumber{
    // if rotation is -ve -> put front to back
    // if rotation is +ve -> put back to front
    // static boolean isPalindrome(int n, int len){
    //     int cp = n;
    //     len = len-1;

    //     int rev = 0;
    //     while(cp>0){
    //         int dig = cp%10;
    //         cp = cp/10;
    //         rev += dig*Math.pow(10,len); // 1*100 + 2*10 + 1 = 121
    //         len--;
    //     }

    //     System.out.println(n);

    //     if (rev == n) return true;
    //     else return  false;
    // }

    // static int method1(int n){

    // }

    public static void main(String[] args){
        int val = 12345; // 0=5, 1=6, -3=2
        int n=5;

        int rotate = -3;
        rotate = rotate % n;
        if(rotate<0) rotate = n + rotate; // 5+(-4) = 1 

        // int flag = 0;
        for(int i=0; i<rotate; i++){
            int dig = val%10; 
            val = val/10;
            

            for(int j=0; j<n-1; j++){
                dig *= 10;
            } 

            val = dig + val;

        }
        System.out.println(val);
    }
}