/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging;

import java.util.logging.Logger;

/**
 *
 * @author oerte
 */
public class DefaultLogger {

    private static Logger myLogger = Logger.getLogger("");
    //public static final String LOGFILEPATH = "/var/log/tomcat8/foglogs/loginlog.log";
    public static final String LOGFILEPATH = "C:\\Users\\oerte\\Desktop\\foglogs\\loginlog.log";
    public static final boolean PRODUCTION = false;

    public static Logger getMyLogger() {
        return myLogger;
    }

}

