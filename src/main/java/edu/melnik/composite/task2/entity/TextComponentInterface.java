package edu.melnik.composite.task2.entity;

import java.util.List;

public interface TextComponent {
    void add(TextComponent textComponent);
    void remove(TextComponent textComponent);
    List<TextComponent> getChildren();
    String restore();
}
