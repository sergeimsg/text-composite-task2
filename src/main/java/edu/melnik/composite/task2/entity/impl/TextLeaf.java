package edu.melnik.composite.task2.entity.impl;

import edu.melnik.composite.task2.entity.TextComponentInterface;
import edu.melnik.composite.task2.entity.TextComponentType;

import java.util.Collections;
import java.util.List;

public class TextLeaf implements TextComponentInterface {

    private final char aChar;
    private final TextComponentType textComponentType;

    public TextLeaf(TextComponentType textComponentType, char aChar) {
        this.textComponentType =textComponentType;
        this.aChar = aChar;

    }

    public char getaChar() {
        return aChar;
    }

    @Override
    public void add(TextComponentInterface textComponent) {
        throw new UnsupportedOperationException("Leaf is not node cannot add children");
    }

    @Override
    public void remove(TextComponentInterface textComponent) {
            throw new UnsupportedOperationException("Leaf is not node nothing to remove");
    }

    @Override
    public List<TextComponentInterface> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public String restore() {
        return String.valueOf(aChar);
    }

    @Override
    public TextComponentType getType() {
        return textComponentType;
    }
}
