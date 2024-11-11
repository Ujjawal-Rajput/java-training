import java.awt.Image;
import java.awt.Rectangle;

public class OpponentCar {
    private Rectangle rectangle; // car rectangle
    private int speed;           
    private Image carImage;

    public OpponentCar(int x, int y, int width, int height, int speed, Image carImage) {
        this.rectangle = new Rectangle(x, y, width, height);
        this.speed = speed;
        this.carImage = carImage;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getSpeed() {
        return speed;
    }

    public Image getCar() {
        return carImage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveDown() {
        rectangle.y += speed;
    }
}
