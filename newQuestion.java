public class newQuestion{
    public static void main(String[] args) {
        int n=197; // 1^9
        int len = 3;

        // not completed yet
        int newlen = 0;
        while(n!=1 || len+1 > newlen){
            int sum = 0;
            newlen = 0;
            while(n>0){
                int dig = n%10;
                n = n/10;

                sum += dig*dig;
                // if (sum<10) newlen = 1;
                // else if (sum<100) newlen = 2;
                // else if (sum<1000) newlen = 3;
                // else 
                int cp = sum;
                while(cp>0){
                    cp /= 10;
                    newlen++;
                }
                //wrong code.

            }
            n = sum;
            n=1;
        }

        System.out.println(n);
    }
}