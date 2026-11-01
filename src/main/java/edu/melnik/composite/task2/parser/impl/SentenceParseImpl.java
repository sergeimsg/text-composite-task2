package edu.melnik.composite.task2.parser.impl;

import edu.melnik.composite.task2.entity.TextComponentInterface;
import edu.melnik.composite.task2.entity.TextComponentType;
import edu.melnik.composite.task2.entity.impl.TextComposite;
import edu.melnik.composite.task2.parser.AbstractTextParser;
import edu.melnik.composite.task2.util.RegexSplit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SentenceParseImpl extends AbstractTextParser {

    public static final Logger logger = LogManager.getLogger();

    @Override
    public TextComponentInterface parse(String string) {
        TextComponentInterface textComponent = new TextComposite(TextComponentType.SENTENCE);
        String[] lexems = string.split(RegexSplit.LEXEME_SPLIT_REGEX);
        logger.info("We have lemems {}", lexems.length);
        logger.info(Arrays.toString(lexems));
        for (String lexem : lexems){
            TextComponentInterface lexemeComponent = nextParser.parse(lexem);
            textComponent.add(lexemeComponent);
        }
        return textComponent;
    }
}
