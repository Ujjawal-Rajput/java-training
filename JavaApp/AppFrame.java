import javax.swing.JFrame;

public class AppFrame extends JFrame{
    AppFrame(){
        setTitle("SEC B APP");
        setSize(650,530);
        // setSize(510,530);
        setLocationRelativeTo(null);
        AppPanel aPanel = new AppPanel();
        add(aPanel);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}