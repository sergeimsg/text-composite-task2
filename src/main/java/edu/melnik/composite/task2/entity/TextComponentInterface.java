package edu.melnik.composite.task2.entity;

import java.util.List;

public interface TextComponentInterface {
    void add(TextComponentInterface textComponent);
    void remove(TextComponentInterface textComponent);
    List<TextComponentInterface> getChildren();
    String restore();
    TextComponentType getType();
}
