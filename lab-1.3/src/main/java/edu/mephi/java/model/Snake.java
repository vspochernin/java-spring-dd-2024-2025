package edu.mephi.java.model;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Snake {

    private final List<Point> body;
    private Direction direction;

    public Snake() {
        this.body = new LinkedList<>();
        this.body.add(new Point(10, 10));
        this.direction = Direction.RIGHT;
    }

    public List<Point> getBody() {
        return body;
    }

    public void setDirection(int keyCode) {
        Direction newDirection = Direction.byKeyCode(keyCode);
        // Если длина змейки больше 1, нельзя повернуть в себя.
        if (body.size() > 1 && this.direction.isOpposite(newDirection)) {
            return;
        }

        this.direction = newDirection;
    }

    public void move() {
        Point head = body.getFirst();
        Point newHead = new Point(head);

        // Добавляем голову по ходу пути.
        switch (direction) {
            case Direction.UP -> newHead.y--;
            case Direction.DOWN -> newHead.y++;
            case Direction.LEFT -> newHead.x--;
            case Direction.RIGHT -> newHead.x++;
        }

        body.addFirst(newHead);
        body.removeLast();
    }

    public void grow() {
        Point tail = body.getLast();
        Point newTail = new Point(tail);

        // Добавляем хвост против хода пути.
        switch (direction) {
            case Direction.UP -> newTail.y++;
            case Direction.DOWN -> newTail.y--;
            case Direction.LEFT -> newTail.x++;
            case Direction.RIGHT -> newTail.x--;
        }

        body.addLast(newTail);
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
