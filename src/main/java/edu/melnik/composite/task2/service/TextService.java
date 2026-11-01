package edu.melnik.composite.task2.service;

import edu.melnik.composite.task2.entity.TextComponentInterface;
import edu.melnik.composite.task2.exception.UserExceptionComposite;

import java.util.List;

public interface TextService {

    int findMaxSentencesWithSameWords(TextComponentInterface text) throws UserExceptionComposite;

    List<TextComponentInterface> sortSentencesByCharCount(TextComponentInterface text, char targetChar) throws UserExceptionComposite;

    TextComponentInterface swapFirstAndLastLexemes(TextComponentInterface component) throws UserExceptionComposite;


}
