package edu.melnik.composite.task2.parser.impl;

import edu.melnik.composite.task2.entity.TextComponentInterface;
import edu.melnik.composite.task2.entity.TextComponentType;
import edu.melnik.composite.task2.entity.impl.TextComposite;
import edu.melnik.composite.task2.entity.impl.TextLeaf;
import edu.melnik.composite.task2.parser.AbstractTextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParseImpl extends AbstractTextParser {
    private final static Logger logger = LogManager.getLogger();
    @Override
    public TextComponentInterface parse(String lexeme) {
        TextComponentInterface textComponent = new TextComposite(TextComponentType.LEXEME);
        for (int i = 0; i < lexeme.length(); i++) {
            textComponent.add(new TextLeaf(TextComponentType.SYMBOL, lexeme.charAt(i)));
            //logger.info("Symbols {}", lexeme.charAt(i));
        }
        return textComponent;
    }
}
