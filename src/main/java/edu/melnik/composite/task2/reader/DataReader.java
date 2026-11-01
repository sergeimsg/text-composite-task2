package edu.melnik.composite.task2.reader;

import edu.melnik.composite.task2.exception.UserExceptionComposite;

public interface ReadData {
    String readFromFile() throws UserExceptionComposite;
}
