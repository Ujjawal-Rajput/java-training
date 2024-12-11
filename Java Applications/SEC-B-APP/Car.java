import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Car {
    int xAxis;
    int yAxis;
    int carWidht;
    int carHeight;
    BufferedImage carImage;
    // ImageIcon carImage;
    String fileName;
    int carSpeed;

    Car(int xAxis, int yAxis, int carWidht, int carHeight, String fileName, int carSpeed) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.carHeight = carHeight;
        this.carWidht = carWidht;
        this.fileName = fileName;
        this.carSpeed = carSpeed;
        loadBgImage();
    }

    void loadBgImage() {

        // carImage = new ImageIcon(Car.class.getResource(fileName));
        try {
            carImage = ImageIO.read(AppPanel.class.getResource(fileName)).getSubimage(82, 106, 82, 106);
            // carImage = ImageIO.read(AppPanel.class.getResource(fileName)).getSubimage(12, 10, 75, 82);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void showCar(Graphics pen) {
        pen.drawImage(carImage, xAxis, yAxis, carWidht, carHeight, null);
    }

    void moveCar() {
        yAxis = yAxis - carSpeed;
    }
}
