
public class CheckSpeed{
    public static void main(String[] args){
        // calculate execution speed using nanoTime()

        long start, end;
        start = System.nanoTime();


        // String s = "Ujjawal";
        //for(int i=0; i<50; i++){
        //     s += " ";
        // }
        // System.out.println(s);
        // ================OR==================
        StringBuilder sb = new StringBuilder();
        sb.append("Ujjawal");
        for(int i=0; i<50; i++){
            sb.append(" ");
        }
        System.out.println(sb);




        end = System.nanoTime();

        System.out.println(end - start); // in nanoseconds
        System.out.println((double)(end - start)/1e9); // in seconds
    }
}