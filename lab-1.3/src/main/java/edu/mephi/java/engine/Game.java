package edu.mephi.java.engine;

import edu.mephi.java.model.Food;
import edu.mephi.java.model.Snake;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

public class Game extends JPanel implements ActionListener {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    private static final int TILE_SIZE = 20;

    private final Timer timer;

    private boolean gameOver = false;
    private Snake snake;
    private Food food;
    private int score;

    public Game() {
        setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);

        this.snake = new Snake();
        this.food = new Food(snake);
        this.score = 0;

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT ->
                            snake.setDirection(keyCode);
                }
            }
        });

        timer = new Timer(200, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameOver) {
            drawGameOver(g);
        } else {
            drawSnake(g);
            drawFood(g);
            drawScore(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            snake.move();
            checkIntersections();
            repaint();
        }
    }

    public void restart() {
        gameOver = false;
        score = 0;
        snake = new Snake();
        food = new Food(snake);
        timer.start();
        repaint();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    private void drawSnake(Graphics g) {
        Iterator<Point> bodyIterator = snake.getBody().iterator();
        Point head = bodyIterator.next();

        g.setColor(Color.WHITE);
        g.fillRect(head.x * TILE_SIZE, head.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        g.setColor(Color.GRAY);
        while (bodyIterator.hasNext()) {
            Point part = bodyIterator.next();
            g.fillRect(part.x * TILE_SIZE, part.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

    private void drawFood(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(food.getLocation().x * TILE_SIZE, food.getLocation().y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }

    private void drawScore(Graphics g) {
        String scoreText = "Score: " + score;
        g.setColor(Color.WHITE);
        g.drawString(scoreText, 10, 20);
    }

    private void drawGameOver(Graphics g) {
        String gameOverText = "Game Over! Press 'R' to restart";
        g.setColor(Color.WHITE);
        g.drawString(gameOverText, 10, 20);
    }

    private void checkIntersections() {
        Point head = snake.getBody().getFirst();

        if (head.equals(food.getLocation())) {
            snake.grow();
            food.spawn(snake);
            score++;
        }

        if (snake.checkIntersections()) {
            gameOver = true;
            timer.stop();
        }
    }
}
