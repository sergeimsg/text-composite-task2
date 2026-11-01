package edu.melnik.composite.task2.parser;

import edu.melnik.composite.task2.entity.TextComponentInterface;

public interface TextParser {
    TextComponentInterface parse(String string);
    void setNextParser(TextParser nextParser);
}
