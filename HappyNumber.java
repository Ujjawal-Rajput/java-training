public class HappyNumber {
    // 1. Single-digit numbers: When the number is reduced to a single digit, it's either 1 (Happy) or 4, 7, or 9 (Unhappy).
    // 2. Cycle detection: The sum of squares of digits can only result in single-digit numbers 1, 4, 7, or 9. If the sum is 4, 7, or 9, it will eventually loop.
    // 3. Maximum sum: The maximum sum of squares of digits for a single-digit number is 9^2 = 81. When reduced, 81 becomes 8^2 + 1^2 = 65, and eventually, 61 becomes 6^2 + 1^2 = 37, then 3^2 + 7^2 = 58, then 5^2 + 8^2 = 89, and finally 8^2 + 9^2 = 145, then 1^2 + 4^2 + 5^2 = 42, then 4^2 + 2^2 = 20, then 2^2 + 0^2 = 4.
    
    // i did't understand this solution why n>9
    public static boolean isHappy(int n) {
        while (n > 9) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(20)); // false
    }
}