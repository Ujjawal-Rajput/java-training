import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;

public class AppFrame extends JFrame {
    AppFrame() {
        Locale locale =  Locale.forLanguageTag("en-US");
        ResourceBundle rb = ResourceBundle.getBundle("ResourceBundle", locale);

        setTitle("Game");
        setSize(Integer.parseInt(rb.getString("FRAME-WIDTH")), Integer.parseInt(rb.getString("FRAME-HEIGHT"))); //550, 750
        setLocationRelativeTo(null);
        AppPanel aPanel = new AppPanel();

        add(aPanel);
        setVisible(true);
    }
}