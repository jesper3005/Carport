/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import javax.security.auth.login.LoginException;

/**
 *
 * @author oerte
 */
public class LoggerConfig {

    public static void setUpLogger() throws LoginException {
        ConsoleHandler handler = new ConsoleHandler();
        DefaultLogger.getMyLogger().addHandler(handler);

        if (DefaultLogger.PRODUCTION) {
            try {
                FileHandler fileHandler = new FileHandler(DefaultLogger.LOGFILEPATH);
                fileHandler.setFormatter(new SimpleFormatter());
                DefaultLogger.getMyLogger().addHandler(fileHandler);
                fileHandler.close();
            } catch (IOException | SecurityException ex) {
                throw new LoginException(ex.getMessage());
            }
        }

    }

}
