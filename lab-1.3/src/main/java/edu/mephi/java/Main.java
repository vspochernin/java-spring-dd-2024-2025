package edu.mephi.java;

import edu.mephi.java.engine.Game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Game");
		Game game = new Game();
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		game.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (game.isGameOver() && e.getKeyCode() == KeyEvent.VK_R) {
					game.restart();
				}
			}
		});

	}
}