import java.util.*;

public class Anagram{

    static String sortString(String original){
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    static Boolean isAnagram(String s, String s2) {
        String a = sortString(s);
        String b = sortString(s2);

        if (a.equals(b)) return true;
        else return false;
    }

    public static void main(String[] args){
        String s = "earth";
        String s2 = "heart";

        System.out.println(isAnagram(s, s2));

        
    }
}