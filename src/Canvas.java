import javax.swing.*;
import java.awt.*;

class Canvas extends JComponent {

    int windowWidth, windowHeight;

    // rectangle
    int minX = 20, minY = 20;
    int rectWidth = 800, rectHeight = 600;

    // ball
    int ballWidth = 40, ballHeight = 40;
    double angle = Math.toRadians(-60);
    double x = 20, y = 20;
    int delay = 3; // milliseconds

    public Canvas(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;

        Timer timer = new Timer(delay, actionEvent -> {
            updateBallPosition();
            repaint(); // repaint the canvas
        });
        timer.start();
    }

    public void paint(Graphics g) {
        // color rectangle fill
        Color rectFillColor = new Color(255, 207, 187);
        g.setColor(rectFillColor);
        g.fillRect(20, 20, rectWidth, rectHeight);

        // color rectangle border
        Color rectBorderColor = new Color(151, 46, 0);
        g.setColor(rectBorderColor);
        g.drawRect(20, 20, rectWidth, rectHeight);

        // color ball fill
        Color ballFillColor = new Color(0, 255, 144);
        g.setColor(ballFillColor);
        g.fillArc((int) x, (int) y, ballWidth, ballHeight, 0, 360);

        // color ball border
        Color ballBorderColor = new Color(35, 73, 58);
        g.setColor(ballBorderColor);
        g.drawArc((int) x, (int) y, ballWidth, ballHeight, 0, 360);
    }

    private void updateBallPosition() {
        x += Math.cos(angle);
        y -= Math.sin(angle);

        // ball bumps into left or right wall
        if (x <= minX || x >= minX + rectWidth - ballWidth) {
            angle = Math.toRadians(180) - angle;
        }

        // ball bumps into upper or lower wall
        if (y <= minY || y >= minY + rectHeight - ballHeight) {
            angle = -angle;
        }
    }
}
