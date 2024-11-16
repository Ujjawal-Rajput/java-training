import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AppPanel extends JPanel {
    int xAxis = 0, yAxis = 0; // Initial position of the image
    int dx = 5, dy = 5; // Movement increment (speed)
    // int IMAGE_WIDTH = 50, IMAGE_HEIGHT = 50; // Image size
    Timer timer;
    static BufferedImage bufferImage;

    AppPanel() {
        setSize(300, 300);
        // setBackground(Color.BLACK);
        showBgImage();
        recallPaintComp();
    }

    static void showBgImage() {
        try {
            bufferImage = ImageIO.read(AppPanel.class.getResource("download.jpeg"));
        } catch (IOException e) {
            System.out.println("NO IMAGE FOUND");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        // System.out.println(x + "," + y);
        g.drawImage(bufferImage, xAxis, yAxis, 50, 50, null);
    }

    void recallPaintComp() {
        timer = new Timer(3, (abcd) -> {
            xAxis += dx;
            yAxis += dy;

            if (xAxis <= 0 || xAxis >= getWidth() - 50) {
                dx = -dx;
            }
            if (yAxis <= 0 || yAxis >= getHeight() - 50) {
                dy = -dy;
            }

            repaint();
        });
        timer.start();
    }
}