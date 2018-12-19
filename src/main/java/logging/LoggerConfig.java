/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;

/**
 *
 * @author oerte
 */
public class LoggerConfig {

    public static void setUpLogger() {

        ConsoleHandler handler = new ConsoleHandler();

        if (DefaultLogger.PRODUCTION) {
            try {
                DefaultLogger.getMyLogger().addHandler(handler);
                FileHandler fileHandler = new FileHandler(DefaultLogger.LOGFILEPATH);
                fileHandler.setFormatter(new VerySimpleFormatter());
                fileHandler.close();
            } catch (IOException | SecurityException ex) {
                System.out.println(ex.getMessage() +" "+ LoggerConfig.class.getName());
            }
        }
    }

    private static class VerySimpleFormatter extends Formatter {

        private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

        @Override
        public String format(final LogRecord record) {
            return String.format(
                    "%1$s %2$-7s %3$s\n",
                    new SimpleDateFormat(PATTERN).format(
                            new Date(record.getMillis())),
                    record.getLevel().getName(),
                    formatMessage(record));
        }
    }
}
