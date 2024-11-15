package edu.mephi.java.model;

import edu.mephi.java.engine.Game;

import java.awt.Point;
import java.util.Random;

public class Food {

    private Point location;

    public Food(Snake snake) {
        spawn(snake);
    }

    public void spawn(Snake snake) {
        Random random = new Random();
        do {
            location = new Point(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT));
        } while (hasIntersectionsWithSnake(snake));
    }

    public Point getLocation() {
        return location;
    }

    private boolean hasIntersectionsWithSnake(Snake snake) {
        for (Point part : snake.getBody()) {
            if (location.equals(part)) {
                return true;
            }
        }
        return false;
    }
}
