public class Automorphic{
    public static void main(String[] args) {
        int n=25;

        int len=0;
        int cp = n;
        while(cp>0){
            cp=cp/10;
            len++;
        }

        int sq = n*n;
        
        int mask = 1;
        for (int i = 0; i < len; i++) {
            mask *=10;
        }

        int val = sq%mask;

        if (val==n) System.out.println("Automorphic");
        else System.out.println("Not automorphic");

    }
}