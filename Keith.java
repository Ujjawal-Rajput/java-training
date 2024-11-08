public class Keith{
    public static void main(String[] args) {
        int n=197;
        int cp = n;

        int third = n%10;
        n=n/10;
        int second = n%10;
        n=n/10;
        int first = n%10;
        

        int sum = 0;
        while(third < cp && third != cp){
            sum = first + second + third;
            first = second;
            second = third;
            third = sum;

            if (sum == cp){
                System.out.println("yes");
                break;
            }
        }

        if (sum!=cp) System.out.println("no");
        
    }
}