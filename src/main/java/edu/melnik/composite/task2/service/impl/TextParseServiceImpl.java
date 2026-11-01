package edu.melnik.composite.task2.service.impl;

import edu.melnik.composite.task2.entity.TextComponentInterface;
import edu.melnik.composite.task2.parser.TextParser;
import edu.melnik.composite.task2.parser.impl.LexemeParseImpl;
import edu.melnik.composite.task2.parser.impl.ParagraphParseImpl;
import edu.melnik.composite.task2.parser.impl.SentenceParseImpl;
import edu.melnik.composite.task2.parser.impl.TextParserImpl;
import edu.melnik.composite.task2.service.TextParseService;

public class TextParseServiceImpl implements TextParseService {

    private final TextParser parser;

    public TextParseServiceImpl() {
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
    public TextComponentInterface parseText(String string) {
        return parser.parse(string);
    }
}
