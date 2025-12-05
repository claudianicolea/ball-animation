import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int windowWidth = 1000, windowHeight = 1000;
        window.setBounds(0, 0, windowWidth, windowHeight);
        window.getContentPane().add(new Canvas(windowWidth, windowHeight));
        window.setVisible(true);
    }
}