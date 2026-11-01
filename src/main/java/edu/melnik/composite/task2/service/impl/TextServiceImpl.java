package edu.melnik.composite.task2.service.impl;

import edu.melnik.composite.task2.entity.TextComponentInterface;
import edu.melnik.composite.task2.entity.TextComponentType;
import edu.melnik.composite.task2.exception.UserExceptionComposite;
import edu.melnik.composite.task2.parser.TextParser;
import edu.melnik.composite.task2.parser.impl.LexemeParseImpl;
import edu.melnik.composite.task2.parser.impl.ParagraphParseImpl;
import edu.melnik.composite.task2.parser.impl.SentenceParseImpl;
import edu.melnik.composite.task2.parser.impl.TextParserImpl;
import edu.melnik.composite.task2.service.TextService;


import java.util.List;

public class TextServiceImpl implements TextService {

    private final TextParser parser;

    public TextServiceImpl() {
        TextParser textParser = new TextParserImpl();
        TextParser paragraphParse = new ParagraphParseImpl();
        TextParser sentenceParse = new SentenceParseImpl();
        LexemeParseImpl lexemeParse = new LexemeParseImpl();
        textParser.setNextParser(paragraphParse);
        paragraphParse.setNextParser(sentenceParse);
        sentenceParse.setNextParser(lexemeParse);

        this.parser = textParser;
    }


    @Override
    public int findMaxSentencesWithSameWords(TextComponentInterface text) throws UserExceptionComposite {
        return 0;
    }

    @Override
    public List<TextComponentInterface> sortSentencesByCharCount(TextComponentInterface text, char targetChar) throws UserExceptionComposite {
        return List.of();
    }

    @Override
    public TextComponentInterface swapFirstAndLastLexemes(TextComponentInterface component) throws UserExceptionComposite {
        return null;
    }
}
