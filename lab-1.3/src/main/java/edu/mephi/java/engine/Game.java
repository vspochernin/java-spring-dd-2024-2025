package edu.mephi.java.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// TODO допишите все необходимые сущности для игры
public class Game extends JPanel implements ActionListener {
	private final int TILE_SIZE = 20;
	private final int WIDTH = 20;
	private final int HEIGHT = 20;
	private boolean gameOver = false;
	private Timer timer;

	public Game() {
		setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE));
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("You pressed " + e.getKeyChar() + " key!");
			}
		});

		timer = new Timer(100, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void restart() {
		timer.start();
		repaint();
	}

	public boolean isGameOver() {
		return gameOver;
	}
}
