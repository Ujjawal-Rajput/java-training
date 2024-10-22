
public class StarPatterns {
    static void box1(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void square2(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if ((i>0 && i<3) && (j>0 && j<3)) System.out.print("  ");
                else System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void triangle3(){
        for(int i=0; i<4; i++){
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void triangle4(){
        for(int i=0; i<4; i++){
            for(int j=i; j<4; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void fig5(){
        for(int i=0; i<4; i++){
            for(int k=i; k<3; k++){
                System.err.print("  ");
            }
            for(int j=0; j<4; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void fig6(){
        for(int i=0; i<4; i++){
            for(int k=0; k<i; k++){
                System.err.print("  ");
            }
            for(int j=0; j<4; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {  
        box1();
        System.out.println("==========================");
        square2();
        System.out.println("==========================");
        triangle3();
        System.out.println("==========================");
        triangle4();
        System.out.println("==========================");
        fig5();
        System.out.println("==========================");
        fig6();
    }
}