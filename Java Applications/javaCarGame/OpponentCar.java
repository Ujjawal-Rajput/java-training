import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class OpponentCar {
    private Rectangle rectangle; // car rectangle
    private int speed;           
    private Image carImage;
    private String carFileName;

    public OpponentCar(int x, int y, int width, int height, int speed, String carFileName) {
        this.rectangle = new Rectangle(x, y, width, height);
        this.speed = speed;
        this.carFileName = carFileName;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getSpeed() {
        return speed;
    }

    public Image getCar() {
        return new ImageIcon(carFileName).getImage();

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveDown() {
        rectangle.y += speed;
    }
}
