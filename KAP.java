import java.util.Arrays;

public class KAP {
    public static void main(String[] args) {
        int num = 1234;
        int asc;
        int desc;

        while (num != 6174) {
            asc = getAscending(num);
            desc = getDescending(num);

            System.out.println(desc + " - " + asc + " = " + (desc - asc));

            num = desc - asc;
            if (num*2 == 6174){
                System.out.println(num + " is half of 6174");
                break;
            }
        }
    }

    public static int getAscending(int n) {
        int[] digits = new int[4];
        int i = 0;
        while (n > 0) {
            digits[i++] = n % 10;
            n /= 10;
        }
        Arrays.sort(digits);
        int asc = 0;
        for (int digit : digits) {
            asc = asc * 10 + digit;
        }
        return asc;
    }

    public static int getDescending(int n) {

        int[] digits = new int[4];
        int i = 0;
        while (n > 0) {
            digits[i++] = n % 10;
            n /= 10;
        }
        Arrays.sort(digits);
        int desc = 0;
        for (int j = digits.length - 1; j >= 0; j--) {
            desc = desc * 10 + digits[j];
        }
        return desc;
    }
}