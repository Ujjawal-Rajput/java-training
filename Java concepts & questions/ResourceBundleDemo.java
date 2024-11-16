// import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ResourceBundleDemo {
    public static void main(String[] args) {

        // Locale indiaLocale = new Locale("en", "IN");
        // NumberFormat nf = NumberFormat.getCurrencyInstance(indiaLocale);

        ResourceBundle rb;
        Locale locale;
        Scanner sc = new Scanner(System.in);
        System.out.println("choose your language");
        System.out.println("Enter 1 for english");
        System.out.println("Enter 2 for hindi");
        System.out.println("Enter 3 for japanese");

        int choice = sc.nextInt();
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

        // System.out.println("Enter your name : ");

        //load properties files
        rb = ResourceBundle.getBundle("ResourceBundle",locale);
        System.out.println(rb.getString("NAME"));

        
    }
}