import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1360, 730);
        frame.setResizable(false);

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

                // Load the map image
                Image mapImage = new ImageIcon("images/map.png").getImage();
                // Draw the map image
                g.drawImage(mapImage, 325, 250, null); // Adjust the position as needed

                // Load the location icon image
                Image locationIcon = new ImageIcon("images/location_icon.png").getImage();
                // Draw the location icon image at the desired position
                int iconWidth = 40; // Adjust the width as needed
                int iconHeight = 40;
                g.drawImage(locationIcon, 400, 300, iconWidth, iconHeight, this); // Adjust the position as needed

                // Load the location icon image
                Image locationIcon2 = new ImageIcon("images/location_icon2.png").getImage();
                // Draw the location icon image at the desired position
                int iconWidth2 = 40; // Adjust the width as needed
                int iconHeight2 = 40;
                g.drawImage(locationIcon2, 200, 300, iconWidth2, iconHeight2, this); // Adjust the position as needed

                // Load the location icon image
                Image locationIcon3 = new ImageIcon("images/location_icon3.png").getImage();
                // Draw the location icon image at the desired position
                int iconWidth3 = 40; // Adjust the width as needed
                int iconHeight3 = 40;
                g.drawImage(locationIcon3, 100, 300, iconWidth3, iconHeight3, this); // Adjust the position as needed


            }
        };
        contentPane.setLayout(new BorderLayout());

        // Create a custom font with Times New Roman, size 20, and decreased thickness
        Font font = new Font("Times New Roman", Font.PLAIN, 50).deriveFont(Font.PLAIN, 28f); // increase the font size

        // Add text to the left corner with line break and padding
        JLabel label = new JLabel("<html><div style='text-align: left; padding: 80px 10px 460px 48px;'>Hey, Tell us<br>What you're looking for...</div></html>"); // adjust padding
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
            navigationButton.setFont(font.deriveFont(Font.PLAIN, 20f)); // increase font size

            // Add padding to the button
            navigationButton.setBorder(new EmptyBorder(10, 20, 10, 20)); // top, left, bottom, right

            // Set margin to ensure the text is fully visible
            navigationButton.setMargin(new Insets(10, 20, 10, 20)); // top, left, bottom, right

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
        contentPane.add(navigationPanel, BorderLayout.NORTH);


        // Add an empty border to the content pane to push content towards the center
        contentPane.setBorder(new EmptyBorder(20, 5, 75, 5));

        // Set the content pane of the frame
        frame.setContentPane(contentPane);

        frame.setVisible(true);
    }
}