package edu.uchicago.gerber.labjava.lec06.tetris2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TetrisGame extends JPanel implements ActionListener {
    private Board board;
    private Tetrimino currentTetrimino;
    private Tetrimino nextTetrimino;
    private Timer timer;
    private int score;
    private int level;
    private boolean isGameOver;

    public TetrisGame() {
        board = new Board();
        score = 0;
        level = 1;
        isGameOver = false;
        currentTetrimino = Tetrimino.getRandomTetrimino();
        nextTetrimino = Tetrimino.getRandomTetrimino();

        timer = new Timer(400, this);
        timer.start();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!isGameOver) handleKeyPress(e);
            }
        });
    }

    //added code from prompt4
    private void drawNextTetrimino(Graphics g) {
        int previewX = board.getWidth() * board.getSquareSize() + 20;
        int previewY = 50;
        int squareSize = board.getSquareSize();

        // Draw the label for "Next"
        g.setColor(Color.BLACK);
        g.drawString("Next:", previewX, previewY - 10);

        // Draw the next Tetrimino shape
        for (int[] block : nextTetrimino.getBlocks()) {
            int x = block[0] * squareSize + previewX;
            int y = block[1] * squareSize + previewY;
            g.setColor(nextTetrimino.getColor());
            g.fillRect(x, y, squareSize, squareSize);
            g.setColor(Color.BLACK);  // Draw border around each block
            g.drawRect(x, y, squareSize, squareSize);
        }
    }

    private void handleKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> currentTetrimino.moveLeft(board);
            case KeyEvent.VK_RIGHT -> currentTetrimino.moveRight(board);
            case KeyEvent.VK_DOWN -> currentTetrimino.fall(board);
            case KeyEvent.VK_UP -> currentTetrimino.rotate(board);
            //I added this line of code
            case KeyEvent.VK_SPACE -> currentTetrimino.rotate(board);
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) gameUpdate();
        repaint();
    }

    private void gameUpdate() {
        if (!currentTetrimino.fall(board)) {
            board.addTetrimino(currentTetrimino);
            clearCompletedRows();
            updateGameStatus();
            currentTetrimino = nextTetrimino;
            nextTetrimino = Tetrimino.getRandomTetrimino();
            currentTetrimino.setPosition(board.getWidth() / 2, 0);
        }
    }

    private void clearCompletedRows() {
        int rowsCleared = board.clearFullRows();
        if (rowsCleared > 0) {
            score += calculateScore(rowsCleared);
            level = score / 1000 + 1;
            timer.setDelay(400 - (level * 20));
        }
    }

    private int calculateScore(int rowsCleared) {
        return switch (rowsCleared) {
            case 1 -> 100 * level;
            case 2 -> 300 * level;
            case 3 -> 500 * level;
            case 4 -> 800 * level; // Tetris
            default -> 0;
        };
    }

    private void updateGameStatus() {
        if (board.getHeightOccupied() > board.getHeight() * 0.9) {
            isGameOver = true;
            timer.stop();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bufferImage = createImage(getWidth(), getHeight());
        Graphics bufferGraphics = bufferImage.getGraphics();

        board.draw(bufferGraphics);
        currentTetrimino.draw(bufferGraphics, board.getSquareSize());

        //added this line from prompt4
        drawNextTetrimino(bufferGraphics);

        if (isGameOver) {
            bufferGraphics.setColor(Color.BLACK);
            bufferGraphics.drawString("Game Over!", getWidth() / 2 - 30, getHeight() / 2);
        }

        g.drawImage(bufferImage, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris Game");
        TetrisGame game = new TetrisGame();
        frame.add(game);
        //frame.setSize(300, 600);
        //and I changed the size
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

// Board Class
class Board {
    private final int WIDTH = 10;
    private final int HEIGHT = 20;
    private final int SQUARE_SIZE = 30;
    private boolean[][] grid = new boolean[HEIGHT][WIDTH];

    public void addTetrimino(Tetrimino tetrimino) {
        for (int[] pos : tetrimino.getBlocks()) {
            int x = tetrimino.getPosition().getX() + pos[0];
            int y = tetrimino.getPosition().getY() + pos[1];
            grid[y][x] = true;
        }
    }

    public int clearFullRows() {
        int clearedRows = 0;
        for (int y = 0; y < HEIGHT; y++) {
            if (isRowFull(y)) {
                clearRow(y);
                clearedRows++;
            }
        }
        return clearedRows;
    }

    private boolean isRowFull(int y) {
        for (int x = 0; x < WIDTH; x++) {
            if (!grid[y][x]) return false;
        }
        return true;
    }

    private void clearRow(int row) {
        for (int y = row; y > 0; y--) {
            System.arraycopy(grid[y - 1], 0, grid[y], 0, WIDTH);
        }
        grid[0] = new boolean[WIDTH];
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getSquareSize() {
        return SQUARE_SIZE;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (grid[y][x]) {
                    g.fillRect(x * SQUARE_SIZE, y * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                }
                g.drawRect(x * SQUARE_SIZE, y * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }

    public boolean checkCollision(int[][] shape, Position position) {
        for (int[] block : shape) {
            int x = position.getX() + block[0];
            int y = position.getY() + block[1];
            if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT || (y < HEIGHT && grid[y][x])) {
                return true;
            }
        }
        return false;
    }

    public int getHeightOccupied() {
        int height = 0;
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (grid[y][x]) {
                    height = Math.max(height, HEIGHT - y);
                    break;
                }
            }
        }
        return height;
    }
}

// Tetrimino Class
class Tetrimino {
    private TetriminoType type;
    private int rotation;
    private Position position;

    public Tetrimino(TetriminoType type) {
        this.type = type;
        this.rotation = 0;
        this.position = new Position(0, 0);
    }

    //added for prompt4
    public TetriminoType getType() {
        return type;
    }

    public static Tetrimino getRandomTetrimino() {
        TetriminoType[] types = TetriminoType.values();
        TetriminoType randomType = types[new Random().nextInt(types.length)];
        return new Tetrimino(randomType);
    }

    public int[][] getBlocks() {
        return type.getShape(rotation);
    }

    public void rotate(Board board) {
        int newRotation = (rotation + 1) % type.getRotationCount();
        int[][] rotatedShape = type.getShape(newRotation);
        if (!board.checkCollision(rotatedShape, position)) {
            rotation = newRotation;
        }
    }

    public void moveLeft(Board board) {
        position.move(-1, 0);
        if (board.checkCollision(getBlocks(), position)) {
            position.move(1, 0);
        }
    }

    public void moveRight(Board board) {
        position.move(1, 0);
        if (board.checkCollision(getBlocks(), position)) {
            position.move(-1, 0);
        }
    }

    public boolean fall(Board board) {
        position.move(0, 1);
        if (board.checkCollision(getBlocks(), position)) {
            position.move(0, -1);
            return false;
        }
        return true;
    }

    public void setPosition(int x, int y) {
        position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public void draw(Graphics g, int squareSize) {
        g.setColor(getColorForType(type));
        for (int[] block : getBlocks()) {
            int x = position.getX() + block[0];
            int y = position.getY() + block[1];
            g.fillRect(x * squareSize, y * squareSize, squareSize, squareSize);
        }
    }



    //add method given prompt4
    public Color getColor(){
        return getColorForType(this.getType());
    }
    private Color getColorForType(TetriminoType type) {
        return switch (type) {
            case I -> Color.CYAN;
            case J -> Color.BLUE;
            case L -> Color.ORANGE;
            case O -> Color.YELLOW;
            case S -> Color.GREEN;
            case T -> Color.MAGENTA;
            case Z -> Color.RED;
        };
    }
}
enum TetriminoType {
    I(new int[][][] {
            {{0, 1}, {1, 1}, {2, 1}, {3, 1}},     // Horizontal
            {{2, 0}, {2, 1}, {2, 2}, {2, 3}}      // Vertical
    }),
    J(new int[][][] {
            {{0, 1}, {1, 1}, {2, 1}, {2, 0}},     // Upwards J
            {{1, 0}, {1, 1}, {1, 2}, {0, 2}},     // Right-facing J
            {{0, 1}, {1, 1}, {2, 1}, {0, 0}},     // Downwards J
            {{1, 0}, {1, 1}, {1, 2}, {2, 0}}      // Left-facing J
    }),
    L(new int[][][] {
            {{0, 1}, {1, 1}, {2, 1}, {2, 2}},     // Upwards L
            {{1, 0}, {1, 1}, {1, 2}, {0, 0}},     // Right-facing L
            {{0, 1}, {1, 1}, {2, 1}, {0, 0}},     // Downwards L
            {{1, 0}, {1, 1}, {1, 2}, {2, 2}}      // Left-facing L
    }),
    O(new int[][][] {
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}}      // O is static, does not rotate
    }),
    S(new int[][][] {
            {{1, 0}, {2, 0}, {0, 1}, {1, 1}},     // Horizontal S
            {{1, 0}, {1, 1}, {2, 1}, {2, 2}}      // Vertical S
    }),
    T(new int[][][] {
            {{0, 1}, {1, 1}, {2, 1}, {1, 2}},     // T upwards
            {{1, 0}, {1, 1}, {1, 2}, {2, 1}},     // Right-facing T
            {{0, 1}, {1, 1}, {2, 1}, {1, 0}},     // T downwards
            {{1, 0}, {1, 1}, {1, 2}, {0, 1}}      // Left-facing T
    }),
    Z(new int[][][] {
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},     // Horizontal Z
            {{1, 0}, {1, 1}, {0, 1}, {0, 2}}      // Vertical Z
    });

    private final int[][][] shapes;

    TetriminoType(int[][][] shapes) {
        this.shapes = shapes;
    }

    public int[][] getShape(int rotation) {
        return shapes[rotation % shapes.length];
    }

    public int getRotationCount() {
        return shapes.length;
    }
}


// Position Class
class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}

