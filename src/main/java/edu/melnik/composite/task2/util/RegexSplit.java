package edu.melnik.composite.task2.util;

public class RegexSplit {

    public static final String PARAGRAPH_SPLIT_REGEX = "\\R\\R+";
    public static final String SENTENCE_SPLIT_REGEX = "(?<=[?.!])\\s+";
    public static final String LEXEME_SPLIT_REGEX = "(?=\\s+)";


}
