import java.text.*;
import java.util.*;

public class BillCalculator {
    static String printTotal(Locale locale, double num) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(num);
    }

    static String printDate(Locale locale) {
        Date date = new Date();
        DateFormat dtf = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return dtf.format(date);
    }

    public static void main(String[] args) {
        Locale locale = new Locale("hi", "IN");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name?");
        String name = sc.nextLine();
        System.out.println("Product name?");
        String prodName = sc.nextLine();
        System.out.println("Total Price?");
        double totalPrice = sc.nextDouble();
        System.out.println("Tax Paid in %?");
        double taxRate = sc.nextDouble();
        double taxAmout = totalPrice * (taxRate / 100);
        double netPrice = totalPrice - taxAmout;

        System.out.println("***************************");
        System.out.println("Welcome, " + name);
        System.out.println("You have bought " + prodName + " on " + printDate(locale));
        System.out.println("Total Paid " + printTotal(locale, totalPrice));
        System.out.println("Tax Paid " + printTotal(locale, taxAmout));
        System.out.println("Net Paid " + printTotal(locale, netPrice));
    }
}