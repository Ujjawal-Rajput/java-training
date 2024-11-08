import javax.swing.JFrame;

public class GameFrame extends JFrame {
    GameFrame() {
        setTitle("2D CAR GAME");
        setSize(800, 600);
        setLocationRelativeTo(null);
        GameSurface surface = new GameSurface();
        add(surface);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
