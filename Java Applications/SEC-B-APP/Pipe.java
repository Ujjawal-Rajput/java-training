import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pipe {
    // int xAxis;
    // int yAxis;
    // int carWidht;
    // int carHeight;
    BufferedImage spriteSheet;
    BufferedImage singleImages[] = new BufferedImage[6];
    // ImageIcon spriteSheet;

    Pipe() {
        loadSpriteSheet();
    }

    void loadSpriteSheet() {
        try {
            spriteSheet = ImageIO.read(AppPanel.class.getResource("pipe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    BufferedImage[] cutSpriteSheet() {
        singleImages[0] = spriteSheet.getSubimage(0, 0, 66, 250);
        singleImages[1] = spriteSheet.getSubimage(0, 0, 66, 200);
        singleImages[2] = spriteSheet.getSubimage(0, 0, 66, 150);
        singleImages[3] = spriteSheet.getSubimage(0, 0, 66, 100);
        singleImages[4] = spriteSheet.getSubimage(0, 0, 66, 50);
        singleImages[5] = spriteSheet.getSubimage(0, 0, 66, 20);
        return singleImages;
    }

    void showPipe1(Graphics pen, BufferedImage img, int x) {
        pen.drawImage(img, x, 0, img.getWidth() , img.getHeight(), null);
    }

    void showPipe2(Graphics pen, BufferedImage img, int x) {
        pen.drawImage(img, x, 500 - img.getWidth(), img.getWidth() , img.getHeight(), null);
    }

    // void movePipes() {
    //     yAxis = yAxis - carSpeed;
    // }

    // Image dimensions: 196×739 pixels
    // Image width:      196 pixels
    // Image height:     739 pixels
    // Orientation:      vertical (portrait)

    // Image format:     png
    // Total pixels:     144844
    // Aspect ratio:     196:739
    // Image size:       33,119 bytes (32.34kb)
}
