package edu.melnik.composite.task2.parser.impl;

import edu.melnik.composite.task2.entity.TextComponentInterface;
import edu.melnik.composite.task2.entity.TextComponentType;
import edu.melnik.composite.task2.entity.impl.TextComposite;
import edu.melnik.composite.task2.parser.AbstractTextParser;
import edu.melnik.composite.task2.parser.TextParser;
import edu.melnik.composite.task2.util.RegexSplit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ParagraphParseImpl extends AbstractTextParser {

    private final static Logger logger = LogManager.getLogger();

    @Override
    public TextComponentInterface parse(String string) {
        TextComponentInterface textComponent = new TextComposite(TextComponentType.PARAGRAPH);
        String[] sentences = string.split(RegexSplit.SENTENCE_SPLIT_REGEX);
        logger.info("We have sentences {}", sentences.length);
        logger.info(Arrays.toString(sentences));
        for (String sentence : sentences){
            TextComponentInterface sentenceComponent = nextParser.parse(sentence);
            textComponent.add(sentenceComponent);
            //  textComponent.add(new SymbolLeaf(TextComponentType.PUNCTUATION, ' '));
        }
        return textComponent;
    }
}
