import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.BufferUnderflowException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Bird {
    // int xAxis;
    // int yAxis;
    // int carWidht;
    // int carHeight;
    BufferedImage spriteSheet;
    BufferedImage singleImages[] = new BufferedImage[10];
    // ImageIcon spriteSheet;

    Bird() {
        loadSpriteSheet();
    }

    void loadSpriteSheet() {
        try {
            spriteSheet = ImageIO.read(AppPanel.class.getResource("bird.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    BufferedImage[] cutSpriteSheet() {
        singleImages[0] = spriteSheet.getSubimage(0, 0, 194, 180);
        singleImages[1] = spriteSheet.getSubimage(194, 0, 194, 180);
        singleImages[2] = spriteSheet.getSubimage(388, 0, 194, 180);
        singleImages[3] = spriteSheet.getSubimage(582, 0, 194, 180);
        singleImages[4] = spriteSheet.getSubimage(776, 0, 194, 180);
        singleImages[5] = spriteSheet.getSubimage(0, 180, 194, 180);
        singleImages[6] = spriteSheet.getSubimage(194, 180, 194, 180);
        singleImages[7] = spriteSheet.getSubimage(388, 180, 194, 180);
        singleImages[8] = spriteSheet.getSubimage(582, 180, 194, 180);
        singleImages[9] = spriteSheet.getSubimage(776, 180, 194, 180);
        return singleImages;
    }

    void showBird(Graphics pen, BufferedImage img, int x) {
        pen.drawImage(img, x, 150, 150, 150, null);
    }

    // void moveBird() {
    // yAxis = yAxis - carSpeed;
    // }
}
