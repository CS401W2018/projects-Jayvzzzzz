import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class SimplePyramidScene extends JPanel {

    public SimplePyramidScene() {
        // Constructor - can be left empty or used for setup
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the panel

        int w = getWidth();
        int h = getHeight();

        // Sky
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, w, h);

        // Sun
        g.setColor(Color.YELLOW);
        g.fillOval(300, 20, 60, 60);

        // Trees (simple green hills)
        g.setColor(Color.GREEN);
        g.fillOval(0, 100, 150, 150);
        g.fillOval(100, 100, 150, 150);
        g.fillOval(200, 100, 150, 150);

        // Ground
        g.setColor(new Color(144, 238, 144)); // Light green
        g.fillRect(0, 200, w, h - 200);

        // Pyramid - stepped design
        g.setColor(new Color(255, 165, 0)); // Orange
        g.fillRect(140, 180, 120, 20); // bottom step
        g.fillRect(150, 160, 100, 20);
        g.fillRect(160, 140, 80, 20);
        g.fillRect(170, 120, 60, 20);
        g.fillRect(180, 100, 40, 20);
        g.fillRect(190, 80, 20, 20); // top step

        // Pyramid stairs
        g.setColor(Color.BLACK);
        g.drawLine(200, 180, 200, 80); // center line
        g.drawLine(180, 160, 220, 160);
        g.drawLine(170, 140, 230, 140);
        g.drawLine(160, 120, 240, 120);

        // Top Oval
        g.setColor(Color.ORANGE);
        g.fillOval(185, 65, 30, 15);
        g.setColor(Color.BLACK);
        g.drawOval(185, 65, 30, 15);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Simple Pyramid Scene");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setContentPane(new SimplePyramidScene());
        window.setVisible(true);
    }
}