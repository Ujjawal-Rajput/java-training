import java.util.*;

public class Stringbuffer{
    public static void main(String[] args){
        // default capacity is 16 bits.
        // 2*previous_size + 2
        // before java 17, size doubles 2 times
        // after java 17, size doubles 1 time
        // string < string_builder < string buffer -> speed
        // string buffer isn't thread safe.
        
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());
        System.out.println(sb.length());

        sb.append("kkg");
        System.out.println(sb.capacity());
        System.out.println(sb.length());

        sb.append("IRJTIJRJY        ");
        System.out.println(sb.capacity());
        System.out.println(sb.length());

        sb.append("IRJTIJRJY hjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhjhj");
        System.out.println(sb.capacity());
        System.out.println(sb.length());
    }
}