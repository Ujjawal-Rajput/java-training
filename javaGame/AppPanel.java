import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import javax.swing.*;

public class AppPanel extends JPanel implements ActionListener, KeyListener {
    Locale locale =  Locale.forLanguageTag("en-US");
    ResourceBundle rb = ResourceBundle.getBundle("ResourceBundle", locale);
    private Timer timer;
    private int playerX = Integer.parseInt(rb.getString("PLAYER-X")); //250-30; // Start position of my car
    private int playerY = Integer.parseInt(rb.getString("PLAYER-Y")); //500;
    private ArrayList<Rectangle> roadLines;
    private ArrayList<OpponentCar> opponentCars;
    private Image playerCar, opponentCar1, opponentCar2,opponentCar3;
    private boolean gameOver = false;
    private int carWidth = Integer.parseInt(rb.getString("CAR-WIDTH")), carHeight = Integer.parseInt(rb.getString("CAR-HEIGHT"));//90, 180;
    private Image opponentCarImages[] = new Image[3];
    private int score = 0;
    private int Hscore = 0;


    public AppPanel() {
        // setPreferredSize(new Dimension(400, 600));
        setBackground(Color.BLACK);

        // load images
        playerCar = new ImageIcon("car.png").getImage();
        opponentCar1 = new ImageIcon("opponent_car1.png").getImage();
        opponentCar2 = new ImageIcon("opponent_car2.png").getImage();
        opponentCar3 = new ImageIcon("opponent_car3.png").getImage();
        
        opponentCarImages[0] = opponentCar1;
        opponentCarImages[1] = opponentCar2;
        opponentCarImages[2] = opponentCar3;



        roadLines = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // left lane divider
            roadLines.add(new Rectangle(166, i * 100, 30, 70)); 
            // right lane divider
            roadLines.add(new Rectangle(332, i * 100, 30, 70)); 
        }

        // initialize opponent cars
        opponentCars = new ArrayList<>();
        createOpponentCars();

        timer = new Timer(20, this); // controls game speed
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    private int getRandomSpeed(){
        Random rand = new Random();
        return rand.nextInt(20) + 5;
    }

    private int getRandomLane(){
        Random rand = new Random();
        return rand.nextInt(3);  // (0, 1, or 2)
    }

    private int getRamdom_X_Coordinates(){
        return 166 * getRandomLane() + (83-30); // minus opponent car width
    }

    private int getRamdom_Y_Coordinates(){
        Random rand = new Random();
        return -rand.nextInt(500); // minus opponent car width
    }


    private void createOpponentCars() {
        opponentCars.clear();
        int lastY = 0;

        for (int i = 0; i < 3; i++) {
            int y = getRamdom_Y_Coordinates();
            if (Math.abs(lastY - y) < carHeight+50) y = y-carHeight-50;
            lastY = y;
            opponentCars.add(new OpponentCar(getRamdom_X_Coordinates(),y, carWidth, carHeight, getRandomSpeed(), opponentCarImages[i]));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        // move road lines downward
        for (Rectangle line : roadLines) {
            line.y += 30;
            if (line.y > getHeight()) {
                line.y = -50;
            }
        }

        // move opponent cars downward by their speed
        for (OpponentCar car : opponentCars) {
            car.moveDown();
            if (car.getRectangle().y > getHeight()) { // will true when opponent car reaches bottom
                int lane = new Random().nextInt(3);
                car.getRectangle().x = 166 * lane + (83-30);
                car.getRectangle().y = -500;
                car.setSpeed(new Random().nextInt(20) + 5);
            }
        }

        // collision
        Rectangle playerRect = new Rectangle(playerX, playerY, carWidth, carHeight);
        for (OpponentCar car : opponentCars) {
            // System.out.println(car.getRectangle().x + " : " + playerRect.x);
            // if (playerRect.intersects(car.getRectangle())) {
            if (car.getRectangle().y + carHeight >= playerRect.y && (car.getRectangle().x - 10 < playerRect.x && car.getRectangle().x + 10 > playerRect.x)) {
                gameOver = true;
                if (score > Hscore) Hscore = score;
                timer.stop();
                // JOptionPane.showMessageDialog(this, "Game Over!");
            }

            // for (int a=0; a<3; a++) {
            // OpponentCar opp1 = opponentCars.get(0);
            // OpponentCar opp2 = opponentCars.get(1);
            // OpponentCar opp3 = opponentCars.get(2);
            // if (playerY < opp1.getRectangle().y && playerY < opp2.getRectangle().y && playerY < opp3.getRectangle().y) score += 3;
            

        }
        updateScore();

        repaint();
    }

    private void updateScore() {
        boolean allCrossed = true;
        
        for (OpponentCar opponentCar : opponentCars) { // Assuming each Car has an 'y' position
            if (opponentCar.getRectangle().y >= playerY) { // Check if player’s car hasn’t passed an opponent car
                allCrossed = false;
                break;
            }
        }
        
        if (allCrossed) {
            score += 3; // Increment score when all cars are successfully crossed
        }
        if (score > Hscore) Hscore = score;
    }








    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // draw road lines
        g.setColor(Color.WHITE);
        for (Rectangle line : roadLines) {
            g.fillRect(line.x, line.y, line.width, line.height);
            // g.fillRect((line.x)*2, line.y, line.width, line.height);
        }

        // draw player car
        g.drawImage(playerCar, playerX, playerY, carWidth, carHeight, this);

        // draw opponent cars
        for (OpponentCar car : opponentCars) {
            Rectangle rect = car.getRectangle();
            g.drawImage(car.getCar(), rect.x, rect.y, rect.width, rect.height, this);          
        }

        // Draw the score in the top-right corner
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);
        g.drawString("HScore: " + Hscore, 10, 60);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();        

        if (key == KeyEvent.VK_LEFT && (playerX-166) >= 53) {
            playerX -= 166; // Move to the left lane
        } 
        else if (key == KeyEvent.VK_LEFT && (playerX-166) <= 53) {
            playerX = 387; // Move to the left lane
        } 
        else if (key == KeyEvent.VK_RIGHT && (playerX+166) <= 387) {
            playerX += 166; // Move to the right lane
        } 
        else if (key == KeyEvent.VK_RIGHT && (playerX+166) >= 387) {
            playerX = 53; // Move to the right lane
        } 
        else if (key == KeyEvent.VK_UP && playerY > 0) {
            playerY -= 20; // Move forward 
        } 
        else if (key == KeyEvent.VK_DOWN && playerY < 900) {
            playerY += 20; // Move backward
        }


        if (gameOver && (key ==  KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN)){
            // System.out.println("GAME WAS OVER");
            restart();
        }
        if (key == KeyEvent.VK_PAGE_DOWN){
            // decrease the speed
            int currentDelay = timer.getDelay();
            int newDelay = Math.min(currentDelay + 10, 100);
            timer.setDelay(newDelay);
        }
        if (key == KeyEvent.VK_PAGE_UP){
            // increase the speed
            int currentDelay = timer.getDelay();
            int newDelay = Math.min(currentDelay - 10, 100);
            if (newDelay > 0) timer.setDelay(newDelay);
        }
    }



    private void restart() {
        playerX = 250-30;
        playerY = 500;
        opponentCars = new ArrayList<>();
        createOpponentCars();
        score = 0;
        timer = new Timer(20, this); 
        timer.start();
        gameOver = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
