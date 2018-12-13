/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging;

import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oerte
 */
public class DefaultLogger {


    public static final boolean PRODUCTION = true;
    public static final String LOGFILEPATH = "C:\\Users\\oerte\\Desktop\\foglogs\\logfile.log";
    private static Logger myLogger = Logger.getLogger("");
    //public static final String LOGFILEPATH = "/var/log/tomcat8/foglogs/loginlog.log";

    public static Logger getMyLogger() {
        return myLogger;
    }
}
