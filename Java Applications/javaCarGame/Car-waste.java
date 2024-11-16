import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

 class Car {
    int xAxis;
    int yAxis;
    int carWidht;
    int carHeight;
    BufferedImage carImage;
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
        try {
            carImage = ImageIO.read(AppPanel.class.getResource(fileName));
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