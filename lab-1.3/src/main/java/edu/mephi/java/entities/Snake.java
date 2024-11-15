package edu.mephi.java.entities;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Snake {

    private final LinkedList<Point> body;
    private int direction;

    public Snake() {
        this.body = new LinkedList<>();
        this.body.add(new Point(10, 10));
        this.direction = KeyEvent.VK_RIGHT;
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        if (body.size() > 1 &&
                (this.direction == KeyEvent.VK_RIGHT && direction == KeyEvent.VK_LEFT
                        || this.direction == KeyEvent.VK_LEFT && direction == KeyEvent.VK_RIGHT
                        || this.direction == KeyEvent.VK_UP && direction == KeyEvent.VK_DOWN
                        || this.direction == KeyEvent.VK_DOWN && direction == KeyEvent.VK_UP)) {
            return;
        }

        this.direction = direction;
    }

    public void move() {
        Point head = body.getFirst();
        Point newHead = new Point(head);

        switch (direction) {
            case KeyEvent.VK_UP -> newHead.y--;
            case KeyEvent.VK_DOWN -> newHead.y++;
            case KeyEvent.VK_LEFT -> newHead.x--;
            case KeyEvent.VK_RIGHT -> newHead.x++;
        }

        body.addFirst(newHead);
        body.removeLast();
    }

    public void grow() {
        Point lastPart = body.getLast();
        Point newPart = new Point(lastPart);

        switch (direction) {
            case KeyEvent.VK_UP -> newPart.y++;
            case KeyEvent.VK_DOWN -> newPart.y--;
            case KeyEvent.VK_LEFT -> newPart.x++;
            case KeyEvent.VK_R -> newPart.x--;
        }

        body.addLast(newPart);
    }

    public boolean checkSelfCollision() {
        Point head = body.getFirst();
        for (int i = 1; i < body.size(); i++) {
            if (body.get(i).equals(head)) {
                return true;
            }
        }
        return false;
    }
}
