/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oerte
 */
public class DefaultLogger {

    public static final boolean PRODUCTION = true;
    public static final String LOGFILEPATH = "C:\\temp\\oerte\\Desktop\\foglogs\\logfile.log";
    private static final Logger LOGGER = Logger.getLogger(Logger.class.getName());

    public static Logger getMyLogger() {
        return LOGGER;
    }
    
    }

