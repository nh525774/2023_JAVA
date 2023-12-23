import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class BrickBreakerGame extends JFrame implements KeyListener, ActionListener {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;
    private static final int INITIAL_BALL_COUNT = 1;
    private static final int BALL_ADD_INTERVAL = 15 * 1000; // 15초마다 공의 개수를 늘리기

    private Timer timer;
    private int ballX = -1;
    private int ballY = -1;
    private int ballXSpeed = 4;
    private int ballYSpeed = 4;

    private int paddleX = 150;
    private int paddleSpeed = 10;

    private boolean[] bricks;
    private int brickWidth = 50; // 벽돌 이미지의 너비
    private int brickHeight = 20; // 벽돌 이미지의 높이
    private int numRows = 5;
    private int numCols = 8;

    private List<Ball> balls;

    private JLabel timerLabel;
    private int elapsedSeconds = 0;

    private Image brickImage;

    private int score = 0;

    public BrickBreakerGame() {
        setTitle("Brick Breaker Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addKeyListener(this);
        setFocusable(true);

        timer = new Timer(10, this);
        timer.start();

        bricks = new boolean[numRows * numCols];
        initializeBricks();

        balls = new ArrayList<>();
        initializeBalls(INITIAL_BALL_COUNT);

        timerLabel = new JLabel("Time: 0 | Score: 0");
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timerLabel, BorderLayout.SOUTH);

        // 이미지 로드
        brickImage = new ImageIcon("duk2.png").getImage();

        setVisible(true);
        startBallAddTimer();
        startElapsedTimer();
    }

    private void initializeBricks() {
        for (int i = 0; i < bricks.length; i++) {
            bricks[i] = true;
        }
    }

    private void initializeBalls(int count) {
        balls.clear();
        for (int i = 0; i < count; i++) {
            balls.add(new Ball(WIDTH / 2, 100));
        }
    }

    private void startBallAddTimer() {
        Timer ballAddTimer = new Timer(BALL_ADD_INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });
        ballAddTimer.start();
    }

    private void addBall() {
        balls.add(new Ball(WIDTH / 2, 100));
    }

    private void startElapsedTimer() {
        Timer elapsedTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedSeconds++;
                timerLabel.setText("Time: " + elapsedSeconds + " | Score: " + score);
            }
        });
        elapsedTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BrickBreakerGame());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 그리기 작업을 병렬로 수행하려면 별도의 리스트를 만들어야 함
        List<Ball> ballsToDraw = new ArrayList<>(balls);
        for (Ball ball : ballsToDraw) {
            g.setColor(Color.RED);
            g.fillOval(ball.getX(), ball.getY(), 20, 20);
        }

        g.setColor(Color.BLUE);
        g.fillRect(paddleX, 550, 80, 10);

        drawBricks(g);
    }

    private void drawBricks(Graphics g) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (bricks[row * numCols + col]) {
                    g.drawImage(brickImage, col * brickWidth, row * brickHeight, brickWidth, brickHeight, null);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Ball ball : balls) {
            ball.move();
        }

        checkBrickCollisions();
        repaint();
    }

    private void showGameOverDialog() {
        JOptionPane.showMessageDialog(this, "GAME OVER\nYour Score: " + score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        exitGame();
    }

    private void checkBrickCollisions() {
        for (Ball ball : balls) {
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    int index = row * numCols + col;
                    if (bricks[index]) {
                        Rectangle brickRect = new Rectangle(col * brickWidth, row * brickHeight, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ball.getX(), ball.getY(), 20, 20);

                        if (brickRect.intersects(ballRect)) {
                            bricks[index] = false;
                            ball.invertYSpeed();
                            score++; // 벽돌 부실 때마다 스코어 증가
                            timerLabel.setText("Time: " + elapsedSeconds + " | Score: " + score);
                        }
                    }
                }
            }
        }
    }

    private void exitGame() {
        System.exit(0);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT && paddleX > 0) {
            paddleX -= paddleSpeed;
        } else if (keyCode == KeyEvent.VK_RIGHT && paddleX < WIDTH - 80) {
            paddleX += paddleSpeed;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Do nothing
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Do nothing
    }

    private class Ball {
        private int x;
        private int y;
        private int xSpeed = 4;
        private int ySpeed = 4;

        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void move() {
            x += xSpeed;
            y += ySpeed;

            // Check for collisions with walls
            if (x < 0 || x > WIDTH - 20) {
                xSpeed = -xSpeed;
            }
            if (y < 0 || y > HEIGHT - 20) {
                // Game over handling
                showGameOverDialog();
                exitGame();
            }

            // Check for collisions with paddle
            if (y > 540 && y < 560 && x > paddleX && x < paddleX + 80) {
                ySpeed = -ySpeed;
            }
        }

        public void invertYSpeed() {
            ySpeed = -ySpeed;
        }
    }
}
