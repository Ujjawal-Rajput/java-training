import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AppPanel extends JPanel {
    Timer timer;
    // int xPos = 200;
    // int yPos = 300;

    // Car cars = new Car[];
    Car car1;
    Car car2;
    Car car3;

    Bird b1 = new Bird();
    Pipe pipe = new Pipe();
    int initIndex = 0;
    int birdX = 150;
    BufferedImage birdArr[] = b1.cutSpriteSheet();
    BufferedImage pipesArr[] = pipe.cutSpriteSheet();
    int pipePos[] = {400, 500, 600};

    AppPanel() {
        setSize(500, 500);
        // setBackground(Color.BLUE);
        // car1 = new Car(200, 20, 100, 150, "running_sprite.jpg", 10);
        // car2 = new Car(200, 300, 100, 150, "dancer.gif", 1);
        // car3 = new Car(350, 300, 100, 150, "dancer.gif", 50);
        callPaintAgain();
        addKeyboardControls();
        setFocusable(true);
    }

    void paintBird(Graphics pen) {
        // for (int i = 0; i < birdArr.length; i++) {
        b1.showBird(pen, birdArr[initIndex], birdX);
        // System.out.println(i);
        // }
    }

    void paintPipes(Graphics pen) {
        // for (int i = 0; i < birdArr.length; i++) {
        Random random = new Random();
        int rand = random.nextInt(6); // 0 to 5 inclusive
        pipe.showPipe1(pen, pipesArr[rand], pipePos[0]);
        pipe.showPipe2(pen, pipesArr[rand], pipePos[0]);
        // System.out.println(i);
        // }
    }

    @Override
    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        paintBird(pen);
        paintPipes(pen);
        // car1.showCar(pen);
        // car2.showCar(pen);
        // car3.showCar(pen);
    }

    void callPaintAgain() {
        timer = new Timer(50, (a) -> {
            // car1.moveCar();
            // car2.moveCar();
            // car3.moveCar();
            birdX += 5;
            if (birdX > 500) {
                birdX = -194;
            }
            initIndex++;
            if (initIndex > 9) {
                initIndex = 0;
            }

            for(int i=0; i<3; i++){
                pipePos[i] -= 50;
            }
            repaint();
        });
        timer.start();
    }

    void addKeyboardControls() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyPressed(KeyEvent e) {

                // if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                // xPos = xPos + 1; // right move
                // }

                // if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                // xPos = xPos - 1; // left move
                // }

                throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
            }

        });
    }
}
