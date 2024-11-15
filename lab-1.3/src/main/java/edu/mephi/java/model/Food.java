package edu.mephi.java.model;

import java.awt.*;
import java.util.Random;

public class Food {

    private Point location;

    public Food() {
        spawn();
    }

    public void spawn() {
        Random random = new Random();
        location = new Point(random.nextInt(20), random.nextInt(20));
    }

    public Point getLocation() {
        return location;
    }
}
