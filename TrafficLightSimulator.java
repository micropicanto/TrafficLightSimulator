import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame implements ActionListener {
    // Constants for window size
    private static final int WIDTH = 300;
    private static final int HEIGHT = 400;

    // Radio buttons for selecting light colors
    private JRadioButton redButton;
    private JRadioButton yellowButton;
    private JRadioButton greenButton;
    
    // Panel to draw the traffic lights
    private JPanel lightPanel;

    // Constructor to initialize the UI
    public TrafficLightSimulator() {
        initializeUI();
    }

    // Method to set up the UI components
    private void initializeUI() {
        // Frame setup
        setTitle("Traffic Light Simulator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create radio buttons for the traffic lights
        createRadioButtons();

        // Create a panel to hold the radio buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);

        // Create the light panel where the traffic lights will be drawn
        lightPanel = new LightPanel();
        lightPanel.setPreferredSize(new Dimension(100, 300));

        // Add the panels to the frame
        add(buttonPanel, BorderLayout.WEST);  // Add buttons to the left
        add(lightPanel, BorderLayout.CENTER); // Light display in the center
    }

    // Method to create and configure the radio buttons
    private void createRadioButtons() {
        // Initialize buttons for each light color
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        // Group the buttons so only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(yellowButton);
        group.add(greenButton);

        // Add action listeners to handle button selections
        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);
    }

    // Event handler for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // When any button is selected, repaint the light panel
        lightPanel.repaint();
    }

    // Custom panel class to draw the traffic lights
    private class LightPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawTrafficLights(g); // Method to draw the traffic lights
        }

        // Method to draw the traffic lights based on selected button
        private void drawTrafficLights(Graphics g) {
            // Draw red light
            g.setColor(Color.GRAY); // Default off state
            g.fillOval(50, 50, 50, 50);
            if (redButton.isSelected()) {
                g.setColor(Color.RED); // Turn red on if selected
                g.fillOval(50, 50, 50, 50);
            }

            // Draw yellow light
            g.setColor(Color.GRAY);
            g.fillOval(50, 150, 50, 50);
            if (yellowButton.isSelected()) {
                g.setColor(Color.YELLOW); // Turn yellow on if selected
                g.fillOval(50, 150, 50, 50);
            }

            // Draw green light
            g.setColor(Color.GRAY);
            g.fillOval(50, 250, 50, 50);
            if (greenButton.isSelected()) {
                g.setColor(Color.GREEN); // Turn green on if selected
                g.fillOval(50, 250, 50, 50);
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Launch the Traffic Light Simulator
        SwingUtilities.invokeLater(() -> {
            TrafficLightSimulator simulator = new TrafficLightSimulator();
            simulator.setVisible(true); // Make the window visible
        });
    }
}
