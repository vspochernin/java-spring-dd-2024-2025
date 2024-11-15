package edu.mephi.java.engine;

import edu.mephi.java.entities.Food;
import edu.mephi.java.entities.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel implements ActionListener {

    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

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
        this.food = new Food();
        this.score = 0;

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT ->
                            snake.setDirection(key);
                }
            }
        });

        timer = new Timer(100, this);
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

    private void drawSnake(Graphics g) {
        g.setColor(Color.BLUE);
        for (Point p : snake.getBody()) {
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            g.setColor(Color.GREEN);
        }
    }

    private void drawFood(Graphics g) {
        g.setColor(Color.RED);
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
        g.drawString(gameOverText, 40, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            snake.move();
            checkCollision();
            repaint();
        }
    }

    public void checkCollision() {
        Point head = snake.getBody().getFirst();

        if (head.equals(food.getLocation())) {
            snake.grow();
            food.spawn();
            score++;
        }

        if (head.x < 0 || head.y < 0 || head.x >= WIDTH || head.y >= HEIGHT || snake.checkSelfCollision()) {
            gameOver = true;
            timer.stop();
        }
    }

    public void restart() {
        gameOver = false;
        score = 0;
        snake = new Snake();
        food = new Food();
        timer.start();
        repaint();
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
