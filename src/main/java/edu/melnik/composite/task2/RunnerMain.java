package edu.melnik.composite.task2;


import edu.melnik.composite.task2.entity.TextComponentInterface;
import edu.melnik.composite.task2.exception.UserExceptionComposite;
import edu.melnik.composite.task2.reader.DataReader;
import edu.melnik.composite.task2.reader.impl.FileReader;
import edu.melnik.composite.task2.service.TextParseService;
import edu.melnik.composite.task2.service.TextService;
import edu.melnik.composite.task2.service.impl.TextParseServiceImpl;
import edu.melnik.composite.task2.service.impl.TextServiceImpl;
import edu.melnik.composite.task2.util.FilePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.text.JTextComponent;


public class RunnerMain {

    private static final Logger logger = LogManager.getLogger();

    private final DataReader dataReader;
    private final TextParseService textParseService;
    private static TextComponentInterface textComponent;
    private static TextService textService;

    public RunnerMain(DataReader dataReader, TextParseService textParseService, TextService textService) {
        this.dataReader = dataReader;
        this.textParseService = textParseService;
        this.textService = textService;
    }

    public void run() throws UserExceptionComposite {
        try {
            String text = dataReader.readFromFile();
            textComponent = textParseService.parseText(text);
        } catch (UserExceptionComposite e) {
            throw new UserExceptionComposite("Failed to read" + FilePath.FILE_PATH, e);
        }


    }

    public static void main(String[] args) throws UserExceptionComposite {

        DataReader dataReader = new FileReader(FilePath.FILE_PATH);
        TextParseService textParseService = new TextParseServiceImpl();
        TextService textService = new TextServiceImpl();
        RunnerMain runnerMain = new RunnerMain(dataReader, textParseService, textService);
        runnerMain.run();

        logger.info("------------------------");
        logger.info(textComponent.restore());
        logger.info("------------------------");
        logger.info(textService.swapFirstAndLastLexemes(textComponent));
    }
}