public class StarPatterns3{

    static void box(int i, int j){
        if (i==0) return;

        for(int k=0; k<j; k++){
            System.out.print("*");
        }

        System.out.println();
        box(i-1,j);
    }

    static void triangles1(int n, int copy, boolean flag){
        if (n==0 && flag == false){
            n=1;
            flag = true;
        }
        if (n>=copy+1 && flag == true) return;

        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
        if (flag == false){
            triangles1(n-1,copy,flag);
        }
        else{
            triangles1(n+1,copy,flag);
        }

     }




     static void plus(int n, int i){
        if (i==13) return;
        if (i==6){
            for (int j = 0; j < 13; j++) {
                System.out.print("+");
            }
        }
        else{
            for (int j = 0; j < n; j++) {
                System.out.print(" ");
            }
            System.out.print("+");
        }
        System.out.println();
        plus(n,i+1);
     }




     static void diamond(int n, int i, boolean flag){
        if (i==-1 && flag==true) return;
        if (i==n){
            i=n-2;
            flag = true;
        }
        for (int j = 0; j < n-i-1; j++) {
            System.out.print("  ");
        }
        for (int j = 0; j < 2*i+1; j++) {
            System.out.print("* ");
        }
        System.out.println();
        if (flag== false) diamond(n,i+1,flag);
        else diamond(n,i-1,flag);
     }




     static void cross(int n, int i){//10 0
        if (i==2*n) return;
        // for (int j = 0; j < i; j++) {
        //     System.out.print(" ");
        // }
        for (int j = 0; j < 2*n; j++) {
            if (i==j || j==2*n-i-1){
                System.out.print("*");
            }
            else System.out.print(" ");
        }
        System.out.println();
        cross(n,i+1);
     }



     static void eight(int n, int i){// 10 0
        if ( i == 2*n-1) return;
        if (i==0 || i==n-1 || i==2*n-2){
            for (int j = 0; j < 6; j++) {
                if (j==0 || j==5) System.out.print(" ");
                else System.out.print("*");
            }
        }
        else{
            for (int j = 0; j < 6; j++) {
                if (j==0 || j==5) System.out.print("*");
                else System.out.print(" ");
            }
        }
        System.out.println();

        eight(n, i+1);
     }



    static void outer_diamond(int n,int i,int a, int b, boolean flag){
        if (i==n){
            a=0;
            b=9;
            flag = true;
        }
        if (i==2*n) return;
        for (int j = 0; j < 10; j++) {
            if (j>a && j<b) System.out.print(" ");
            else System.out.print("*");
        }
        System.out.println();
        if (i==0){
            a=4;
            b=5;
        }
        if (flag == false ) outer_diamond(n,i+1, a-1, b+1,flag);
        else outer_diamond(n,i+1, a+1, b-1,flag);
    }

    //using recursion
    public static void main(String[] args) {
        box(4,4);
        System.out.println("====================================================");
        triangles1(5,5,false);
        System.out.println("====================================================");
        plus(6,0);
        System.out.println("====================================================");
        diamond(4,0,false);
        System.out.println("====================================================");
        cross(5,0);
        System.out.println("====================================================");
        eight(10,0);
        System.out.println("====================================================");
        outer_diamond(5,0,0,0, false);
    }
}