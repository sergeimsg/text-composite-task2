package edu.melnik.composite.task2.parser;

import edu.melnik.composite.task2.entity.TextComponentInterface;


public abstract class AbstractTextParser implements TextParser {
    protected TextParser nextParser;

    @Override
    public void setNextParser(TextParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public abstract TextComponentInterface parse(String string);


}
