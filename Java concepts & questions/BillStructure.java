import java.text.NumberFormat;
import java.util.Locale;

public class BillStructure {
    public static void main(String[] args) {

        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(indiaLocale);
        // Currency rupee = Currency.getInstance(indiaLocale);
        // String rupeeSymbol = rupee.getSymbol(indiaLocale);

        String[] headers = { "Sr No.", "Product Name", "Pieces", "Amount", "GST"};
        String[][] data = {
            { "1.", "Notebook", "20", nf.format(2000), "18 %" },
            { "2.", "Pen", "200", nf.format(1500), "18 %" },
            { "3.", "Bag", "25", nf.format(5000), "18 %" }
        };

        System.out.println("BILL");
        printLine();
        printRow(headers);
        printLine();
        for (String[] row : data) {
            printRow(row);
        }
        printLine();
    }

    private static void printRow(String[] columns) {
        System.out.printf("| %-6s | %-12s | %-7s | %-9s | %-5s |\n", // FORMAT : %[-][width][conversion type]
            columns[0], columns[1], columns[2], columns[3], columns[4]);
    }

    private static void printLine() {
        System.out.println("+--------+--------------+---------+-----------+-------+");
    }
}

