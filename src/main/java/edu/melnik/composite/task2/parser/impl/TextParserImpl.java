package edu.melnik.composite.task2.parser.impl;

import edu.melnik.composite.task2.entity.TextComponentInterface;
import edu.melnik.composite.task2.entity.TextComponentType;
import edu.melnik.composite.task2.entity.impl.TextComposite;
import edu.melnik.composite.task2.parser.AbstractTextParser;
import edu.melnik.composite.task2.parser.TextParser;
import edu.melnik.composite.task2.util.RegexSplit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParserImpl extends AbstractTextParser {

    public static final Logger logger = LogManager.getLogger();

    @Override
    public TextComponentInterface parse(String string) {

        TextComponentInterface textComponent = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = string.split(RegexSplit.PARAGRAPH_SPLIT_REGEX);
        logger.info("We have paragraphs {}", paragraphs.length);
        for (String paragraph : paragraphs) {
            TextComponentInterface paragraphComponent = nextParser.parse(paragraph);
            textComponent.add(paragraphComponent);
        }
        return textComponent;
    }
}
