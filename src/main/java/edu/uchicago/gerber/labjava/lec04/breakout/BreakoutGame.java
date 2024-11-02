package edu.uchicago.gerber.labjava.lec04.breakout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//created by chatGPT - but not working
public class BreakoutGame extends JPanel implements ActionListener {
    private Paddle paddle;
    private Ball ball;
    private ArrayList<Brick> bricks;
    private Timer timer;
    private boolean isGameOver;
    private boolean isGameWon;
    private boolean leftPressed, rightPressed;

    public BreakoutGame() {
        paddle = new Paddle();
        ball = new Ball();
        bricks = new ArrayList<>();
        isGameOver = false;
        isGameWon = false;

        setFocusable(true);
        setPreferredSize(new Dimension(500, 400));
        setupBricks();
        setupInput();

        timer = new Timer(16, this); // 60 FPS
        timer.start();
    }

    private void setupInput() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) leftPressed = true;
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) leftPressed = false;
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = false;
            }
        });
    }

    private void setupBricks() {
        int rows = 5;
        int cols = 10;
        int brickWidth = 40;
        int brickHeight = 20;
        int spacing = 5;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * (brickWidth + spacing) + 35;
                int y = row * (brickHeight + spacing) + 50;
                bricks.add(new Brick(x, y, brickWidth, brickHeight));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver && !isGameWon) {
            gameUpdate();
            checkCollisions();
            repaint();
        }
    }

    private void gameUpdate() {
        if (leftPressed) paddle.moveLeft();
        if (rightPressed) paddle.moveRight();
        ball.move();

        if (bricks.isEmpty()) {
            isGameWon = true;
            timer.stop();
        }

        if (ball.getY() > getHeight()) {
            isGameOver = true;
            timer.stop();
        }
    }

    private void checkCollisions() {
        // Check collision with paddle
        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.reverseY();
        }

        // Check collision with bricks
        ArrayList<Brick> bricksToRemove = new ArrayList<>();
        for (Brick brick : bricks) {
            if (ball.getBounds().intersects(brick.getBounds())) {
                ball.reverseY();
                bricksToRemove.add(brick);
            }
        }
        bricks.removeAll(bricksToRemove);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bufferImage = createImage(getWidth(), getHeight());
        Graphics bufferGraphics = bufferImage.getGraphics();

        // Draw paddle, ball, and bricks
        paddle.draw(bufferGraphics);
        ball.draw(bufferGraphics);

        for (Brick brick : bricks) {
            brick.draw(bufferGraphics);
        }

        // Draw game-over or game-won messages
        bufferGraphics.setColor(Color.BLACK);
        if (isGameOver) {
            bufferGraphics.drawString("Game Over!", getWidth() / 2 - 30, getHeight() / 2);
        } else if (isGameWon) {
            bufferGraphics.drawString("You Won!", getWidth() / 2 - 30, getHeight() / 2);
        }

        g.drawImage(bufferImage, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout Game");
        BreakoutGame gamePanel = new BreakoutGame();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Inner class for Paddle
    class Paddle {
        private int x, y;
        private final int width = 80;
        private final int height = 10;
        private final int speed = 6;

        public Paddle() {
            x = getWidth() / 2 - width / 2;
            y = getHeight() - 30;
        }

        public void moveLeft() {
            if (x > 0) x -= speed;
        }

        public void moveRight() {
            if (x + width < getWidth()) x += speed;
        }

        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }

    // Inner class for Ball
    class Ball {
        private int x, y;
        private final int diameter = 10;
        private int xSpeed = 4;
        private int ySpeed = -4;

        public Ball() {
            x = getWidth() / 2;
            y = getHeight() / 2;
        }

        public void move() {
            x += xSpeed;
            y += ySpeed;

            // Check for collision with walls
            if (x <= 0 || x + diameter >= getWidth()) xSpeed = -xSpeed;
            if (y <= 0) ySpeed = -ySpeed;
        }

        public void reverseY() {
            ySpeed = -ySpeed;
        }

        public int getY() {
            return y;
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillOval(x, y, diameter, diameter);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, diameter, diameter);
        }
    }

    // Inner class for Brick
    class Brick {
        private int x, y;
        private int width, height;
        private boolean destroyed = false;

        public Brick(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public void draw(Graphics g) {
            if (!destroyed) {
                g.setColor(Color.GREEN);
                g.fillRect(x, y, width, height);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, width, height);
            }
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }
}
