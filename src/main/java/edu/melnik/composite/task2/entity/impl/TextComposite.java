package edu.melnik.composite.task2.entity.impl;

import edu.melnik.composite.task2.entity.TextComponentInterface;
import edu.melnik.composite.task2.entity.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponentInterface {
    private final List<TextComponentInterface> components = new ArrayList<>();
    public final TextComponentType textComponentType;

    public TextComposite(TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
    }

    @Override
    public void add(TextComponentInterface textComponent) {
        components.add(textComponent);
    }

    @Override
    public void remove(TextComponentInterface textComponent) {
        components.remove(textComponent);
    }

    @Override
    public TextComponentType getType() {
        return textComponentType;
    }

    @Override
    public List<TextComponentInterface> getChildren() {
        return components;
    }

    @Override
    public String restore() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponentInterface textComponentInterface : components){
            stringBuilder.append(textComponentInterface.restore());
        }
        return stringBuilder.toString();
    }
}
