import java.text.*;
import java.util.*;

public class BillCalculatorRB {
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
        Locale locale;

        System.out.println("choose your language");
        System.out.println("Enter 1 for english");
        System.out.println("Enter 2 for hindi");
        System.out.println("Enter 3 for japanese");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println("ok");


        if (choice==1){
            locale = new Locale("en","US");
        }
        else if (choice==2){
            locale = new Locale("hi","IN");
        }
        else if (choice==3){
            locale = new Locale("jp","jp");
        }
        else{
            System.out.println("Invalid input");
            locale = new Locale("en","US");
        }

        ResourceBundle rb;
        rb = ResourceBundle.getBundle("ResourceBundle",locale);

        System.out.println(rb.getString("NAME"));
        String name = sc.next();
        System.out.println(rb.getString("PRODUCT"));
        String prodName = sc.next();
        System.out.println(rb.getString("PRICE"));
        double totalPrice = sc.nextDouble();
        System.out.println(rb.getString("TAX"));    
        double taxRate = sc.nextDouble();

        double taxAmout = totalPrice * (taxRate / 100);
        double netPrice = totalPrice - taxAmout;

        System.out.println("***************************");
        System.out.println(rb.getString("WELCOME") + " "+ name);
        System.out.println(rb.getString("BOUGHT") + " " + prodName + " on " + printDate(locale));
        System.out.println(rb.getString("TOTAL_PAID") + " " + printTotal(locale, totalPrice));
        System.out.println(rb.getString("TAX_PAID") + " " + printTotal(locale, taxAmout));
        System.out.println(rb.getString("NET_PAID") + " " + printTotal(locale, netPrice));
    }
}