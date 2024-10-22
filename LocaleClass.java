import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;

public class LocaleClass{
    static void formatTotal(Locale locale, int value) {
        // NumberFormat nf = NumberFormat.getNumberInstance(locale);
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        System.out.println(nf.format(value));
    }

    static void showDate(Locale locale) {
        // Date date = new Date(0);
        Date date = new Date();
        DateFormat dtf = DateFormat.getDateInstance(DateFormat.FULL, locale);
        // DateFormat.LONG / DateFormat.SHORT / DateFormat.FULL
        System.out.println(dtf.format(date));
    }

    public static void main(String[] args) {
        // DDMMYY - IN RS 1,00,000.00
        // MMDDYY - US USD 100,000.00
        // YYMMDD - JP, JP'S (japan)
        int tot = 2600; // 2,600.00
        // Locale locale = new Locale();
        Locale locale = new Locale("EN", "US");
        Locale indialocale = new Locale("hi", "IN");
        Locale japanlocale = new Locale("jp", "jp");
        // Locale locale = Locale.GERMANY;

        

        formatTotal(locale, tot);
        showDate(locale);

        formatTotal(indialocale, tot);
        showDate(indialocale);

        formatTotal(japanlocale, tot);
        showDate(japanlocale);
    }
}