import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 450);

        // Create a JPanel to use as the content pane
        JPanel contentPane = new JPanel() {
            // Override the paintComponent method to paint the background image
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                Image backgroundImage = new ImageIcon("images/branches4.png").getImage();
                // Draw the background image
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setLayout(new BorderLayout());

        // Create a custom font with Times New Roman, size 20, and decreased thickness
        Font font = new Font("Times New Roman", Font.PLAIN, 20).deriveFont(Font.PLAIN, 18f); // decrease the font thickness

        // Add text to the left corner with line break and padding
        JLabel label = new JLabel("<html><div style='text-align: left; padding: 20px 28px;'>Hey, Tell us<br>What you're looking for...</div></html>");
        label.setForeground(Color.WHITE);
        label.setFont(font);

        // Create a panel for navigation buttons
        JPanel navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        navigationPanel.setOpaque(false);

        // Add navigation buttons with hover effect
        String[] navigationItems = {"Home", "Branches", "Items", "Employee"};
        for (String item : navigationItems) {
            JButton navigationButton = new JButton(item);
            navigationButton.setForeground(Color.WHITE);
            navigationButton.setContentAreaFilled(false); // Remove background
            navigationButton.setBorderPainted(false); // Remove border

            // Set default and hover colors
            Color defaultColor = Color.WHITE;
            Color hoverColor = Color.decode("#daa03c");
            navigationButton.setForeground(defaultColor);

            // Add a MouseListener for hover effect
            navigationButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    navigationButton.setForeground(hoverColor);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    navigationButton.setForeground(defaultColor);
                }
            });

            navigationPanel.add(navigationButton);
        }

        // Add the label and navigation panel to the content pane
        contentPane.add(label, BorderLayout.WEST);
        contentPane.add(navigationPanel, BorderLayout.EAST);

        // Add an empty border to the content pane to push content towards the center
        contentPane.setBorder(new EmptyBorder(20, 5, 330, 20));

        // Set the content pane of the frame
        frame.setContentPane(contentPane);

        frame.setVisible(true);
    }
}
