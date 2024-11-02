package edu.uchicago.gerber.labjava.lec04.p1941;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


//created by chatGPT - but not working
public class Game1941 extends JPanel implements ActionListener {
    private PlayerShip player;
    private ArrayList<Enemy> enemies;
    private ArrayList<Bullet> bullets;
    private Timer timer;
    private int score;
    private boolean isGameOver;
    private BackgroundScroller background;

    // Directional keys
    private boolean leftPressed, rightPressed, upPressed, downPressed, spacePressed;

    public Game1941() {
        player = new PlayerShip();
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        background = new BackgroundScroller();
        score = 0;
        isGameOver = false;

        setFocusable(true);
        setPreferredSize(new Dimension(400, 600));
        setupInput();

        timer = new Timer(16, this); // 60 FPS
        timer.start();
    }

    private void setupInput() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> leftPressed = true;
                    case KeyEvent.VK_RIGHT -> rightPressed = true;
                    case KeyEvent.VK_UP -> upPressed = true;
                    case KeyEvent.VK_DOWN -> downPressed = true;
                    case KeyEvent.VK_SPACE -> spacePressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> leftPressed = false;
                    case KeyEvent.VK_RIGHT -> rightPressed = false;
                    case KeyEvent.VK_UP -> upPressed = false;
                    case KeyEvent.VK_DOWN -> downPressed = false;
                    case KeyEvent.VK_SPACE -> spacePressed = false;
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            gameUpdate();
            checkCollisions();
            repaint();
        }
    }

    private void gameUpdate() {
        background.scroll(); // Update background position
        player.update();

        // Handle continuous movement based on key states
        if (leftPressed) player.moveLeft();
        if (rightPressed) player.moveRight();
        if (upPressed) player.moveUp();
        if (downPressed) player.moveDown();

        // Fire bullets if space is held down
        if (spacePressed && player.canFire()) {
            bullets.add(player.fire());
        }

        // Update enemies and add new ones
        for (Enemy enemy : enemies) {
            enemy.move();
            if (Math.random() < 0.01) { // Random chance for enemy to fire
                bullets.add(enemy.fire());
            }
        }

        // Remove enemies that moved off-screen
        enemies.removeIf(enemy -> enemy.getY() > getHeight());

        // Update bullets
        for (Bullet bullet : bullets) {
            bullet.move();
        }

        // Spawn new enemies randomly
        if (Math.random() < 0.05) {
            enemies.add(new Enemy());
        }
    }

    private void checkCollisions() {
        ArrayList<Bullet> bulletsToRemove = new ArrayList<>();
        ArrayList<Enemy> enemiesToRemove = new ArrayList<>();

        for (Bullet bullet : bullets) {
            if (bullet.isPlayerBullet()) {
                for (Enemy enemy : enemies) {
                    if (bullet.getBounds().intersects(enemy.getBounds())) {
                        bulletsToRemove.add(bullet);
                        enemiesToRemove.add(enemy);
                        score += 100;
                        break;
                    }
                }
            } else if (bullet.getBounds().intersects(player.getBounds())) {
                bulletsToRemove.add(bullet);
                player.takeDamage();
                if (player.isDestroyed()) {
                    isGameOver = true;
                    timer.stop();
                }
            }
        }

        bullets.removeAll(bulletsToRemove);
        enemies.removeAll(enemiesToRemove);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bufferImage = createImage(getWidth(), getHeight());
        Graphics bufferGraphics = bufferImage.getGraphics();

        background.draw(bufferGraphics);
        player.draw(bufferGraphics);

        for (Enemy enemy : enemies) {
            enemy.draw(bufferGraphics);
        }

        for (Bullet bullet : bullets) {
            bullet.draw(bufferGraphics);
        }

        bufferGraphics.setColor(Color.WHITE);
        bufferGraphics.drawString("Score: " + score, 10, 20);

        if (isGameOver) {
            bufferGraphics.setColor(Color.RED);
            bufferGraphics.drawString("Game Over!", getWidth() / 2 - 30, getHeight() / 2);
        }

        g.drawImage(bufferImage, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("1941 Game");
        Game1941 gamePanel = new Game1941();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Inner class for PlayerShip
    class PlayerShip {
        private int x, y;
        private int width = 30, height = 30;
        private int speed = 5;
        private int health = 3;
        private long lastFireTime = 0;
        private final int fireRate = 200; // milliseconds

        public PlayerShip() {
            x = getWidth() / 2 - width / 2;
            y = getHeight() - 60;
        }

        public void moveLeft() { if (x > 0) x -= speed; }
        public void moveRight() { if (x < getWidth() - width) x += speed; }
        public void moveUp() { if (y > 0) y -= speed; }
        public void moveDown() { if (y < getHeight() - height) y += speed; }

        public boolean canFire() {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastFireTime >= fireRate) {
                lastFireTime = currentTime;
                return true;
            }
            return false;
        }

        public Bullet fire() {
            return new Bullet(x + width / 2 - 2, y, -10, true);
        }

        public void takeDamage() {
            health--;
        }

        public boolean isDestroyed() {
            return health <= 0;
        }

        public void update() {
            // Any additional updates for player ship can go here
        }

        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }

    // Inner class for Enemy
    class Enemy {
        private int x, y;
        private int width = 30, height = 30;
        private int speed = 3;

        public Enemy() {
            x = new Random().nextInt(getWidth() - width);
            y = -height;
        }

        public void move() {
            y += speed;
        }

        public Bullet fire() {
            return new Bullet(x + width / 2 - 2, y + height, 5, false);
        }

        public int getY() {
            return y;
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillRect(x, y, width, height);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }

    // Inner class for Bullet
    class Bullet {
        private int x, y;
        private int speed;
        private boolean playerBullet;
        private int width = 5, height = 10;

        public Bullet(int x, int y, int speed, boolean playerBullet) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.playerBullet = playerBullet;
        }

        public void move() {
            y += speed;
        }

        public boolean isPlayerBullet() {
            return playerBullet;
        }

        public void draw(Graphics g) {
            g.setColor(playerBullet ? Color.YELLOW : Color.ORANGE);
            g.fillRect(x, y, width, height);
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }

    // Inner class for BackgroundScroller
    class BackgroundScroller {
        private int y1, y2;
        private int scrollSpeed = 2;

        public BackgroundScroller() {
            y1 = 0;
            y2 = -getHeight();
        }

        public void scroll() {
            y1 += scrollSpeed;
            y2 += scrollSpeed;

            if (y1 >= getHeight()) y1 = -getHeight();
            if (y2 >= getHeight()) y2 = -getHeight();
        }

        public void draw(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect(0, y1, getWidth(), getHeight());
            g.fillRect(0, y2, getWidth(), getHeight());
        }
    }
}
