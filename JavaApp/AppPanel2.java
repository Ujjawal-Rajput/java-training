import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AppPanel2 extends JPanel {

    static BufferedImage bufferImage;
    Timer timer;
    int xAxis = 0;
    int yAxis = 0;
    boolean flag = true;

    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.BLACK);
        showBgImage();
        recallPaintComp();
    }

    static void showBgImage() {
        try {
            bufferImage = ImageIO.read(AppPanel.class.getResource("download.jpeg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("NO IMAGE FOUND");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        // System.out.println(xAxis + "," + yAxis);
        g.drawImage(bufferImage, xAxis, yAxis, 50, 50, null);
    }

    void recallPaintComp() {
        timer = new Timer(3, (abcd) -> {

            if (xAxis >= 450 || yAxis >= 450){
                    xAxis -= 5;
                    yAxis -= 5;
                    flag = false;
            }
            else if (xAxis <= 0 || yAxis <= 0){
                    xAxis += 5;
                    yAxis += 5;
                    flag = true;
            }
            
            if (flag==true && xAxis < 450 && yAxis < 450) {
                xAxis += 5;
                yAxis += 5;                
            } 
            else{
                xAxis -= 5;
                yAxis -= 5;               
            }

            repaint();
        });
        timer.start();
    }
}