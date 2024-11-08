import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameSurface extends JPanel {
    Timer timer;             // Timer to control background movement
    int xAxis = 330;         // Initial x-axis position of the car
    int yAxis = 400;         // Initial y-axis position of the car
    int backgroundY = 0;     // Background position for scrolling effect
    Image backgroundImage;   // Image for the background (road)
    ImageIcon overlayImage;  // Image for the car

    GameSurface() {
        setPreferredSize(new Dimension(800, 600)); // Set panel size
        showBgImage();        // Load images for background and car
        // MovingBackground();   // Start the background movement
        keyboardOpr();        // Initialize key bindings for car control
        setFocusable(true);   // Make the panel focusable for key events
        requestFocusInWindow(); // Request focus to capture key events
    }

    // Method to load the background and car images
    void showBgImage() {
        backgroundImage = new ImageIcon(GameSurface.class.getResource("road.jpg")).getImage();
        overlayImage = new ImageIcon(GameSurface.class.getResource("cars.png"));

        // Check if background image is loaded successfully
        if (backgroundImage == null) {
            System.out.println("Background image not found");
        } else {
            System.out.println("Background image loaded successfully.");
        }
    }

    // Method to draw the images onto the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the scrolling background twice for continuous effect
        g.drawImage(backgroundImage, 0, backgroundY, 800, 600, this);
        g.drawImage(backgroundImage, 0, backgroundY + 600, 800, 600, this);

        // Draw the car image at the specified coordinates
        g.drawImage(overlayImage.getImage(), xAxis, yAxis, 100, 200, null);
    }

    // Method to create a moving background effect using a timer
    public void MovingBackground() {
        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backgroundY -= 1; // Move background up by 1 pixel

                // Reset background position for continuous scrolling
                if (backgroundY <= -600) {
                    backgroundY = 0;
                }
                repaint(); // Refresh panel to show updated background position
            }
        });
        timer.start(); // Start the timer
    }

    // Method to set up a key listener for moving the car with arrow keys
    void keyboardOpr() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Not used, but required for KeyListener
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Set boundaries to keep the car within the visible area
                if (e.getKeyCode() == KeyEvent.VK_RIGHT && xAxis < getWidth() - 300) {
                    xAxis += 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT && xAxis > 150) {
                    xAxis -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP && yAxis > 220) {
                    yAxis -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN && yAxis < getHeight() - 200) {
                    yAxis += 5;
                }
                repaint(); // Refresh panel to show the car at the new position
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not used, but required for KeyListener
            }
        });
    }
}
