package edu.uchicago.gerber.labjava.lec06.chat_gpt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RandomRectangleApp extends JFrame {
    private DrawPanel drawPanel;

    public RandomRectangleApp() {
        setTitle("Random Rectangle Drawer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the drawing panel
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        // Setup menu with "File" and "Exit" options
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add action listener to the "Exit" menu item
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    // JPanel subclass for drawing rectangles
    private class DrawPanel extends JPanel {
        private Random random = new Random();

        public DrawPanel() {
            /*
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    drawRandomRectangle(e.getX(), e.getY());
                }

            }
             */
            // Mouse listener to draw rectangle at click location
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    drawRandomRectangle(e.getX(), e.getY());
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        // Method to draw a rectangle at a given location
        private void drawRandomRectangle(int x, int y) {
            Graphics g = getGraphics();
            Graphics2D g2d = (Graphics2D) g;

            int width = random.nextInt(100) + 20; // random width from 20 to 120
            int height = random.nextInt(100) + 20; // random height from 20 to 120

            // Random color
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g2d.setColor(color);

            // Calculate top-left position to center the rectangle at (x, y)
            int topLeftX = x - width / 2;
            int topLeftY = y - height / 2;

            // Draw rectangle outline
            g2d.drawRect(topLeftX, topLeftY, width, height);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RandomRectangleApp app = new RandomRectangleApp();
            app.setVisible(true);
        });
    }
}
