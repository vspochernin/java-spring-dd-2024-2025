package edu.mephi.java.model;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Direction {

    UP(KeyEvent.VK_UP),
    DOWN(KeyEvent.VK_DOWN),
    LEFT(KeyEvent.VK_LEFT),
    RIGHT(KeyEvent.VK_RIGHT);

    private final int keyCode;

    Direction(int keyCode) {
        this.keyCode = keyCode;
    }

    public static final Map<Integer, Direction> BY_KEY_CODE_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(Direction::getKeyCode, Function.identity()));

    public static Direction byKeyCode(int keyCode) {
        return Optional.ofNullable(BY_KEY_CODE_MAP.get(keyCode))
                .orElseThrow(() -> new IllegalArgumentException("There is no direction with key code: " + keyCode));
    }

    public boolean isOpposite(Direction other) {
        return this == RIGHT && other == LEFT
                || this == LEFT && other == RIGHT
                || this == UP && other == DOWN
                || this == DOWN && other == UP;
    }

    public int getKeyCode() {
        return keyCode;
    }
}
