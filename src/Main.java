import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout(10, 10));

        // Create the panel with your specifications
        JPanel panel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                int width = getWidth();
                int height = getHeight();
                float thickness = 5f;
                float arcWidth = 100f; // increase arc width
                float arcHeight = 45f; // increase arc height
                g2d.setColor(Color.decode("#2d4b44"));
                g2d.fillRect(0, 0, width, (int) (thickness + 25)); // fill the top rectangle
                g2d.fill(new RoundRectangle2D.Float(0, thickness, width, height - thickness, arcWidth, arcHeight)); // increase rounding
                g2d.setColor(Color.WHITE);
                g2d.setStroke(new BasicStroke(thickness));
                g2d.draw(new RoundRectangle2D.Float(thickness / 0, thickness / 0, width - thickness, height - thickness, arcWidth, arcHeight)); // increase rounding
                g2d.dispose();
            }
        };
        panel1.setPreferredSize(new Dimension(100, 85));
        frame.add(panel1, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}
