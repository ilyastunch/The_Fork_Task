package com.theFork.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {

    static Logger logger = Logger.getLogger(Log.class);

    public Log(){
        DOMConfigurator.configure("Log4j.xml");
    }

    public static void info(String message){
        logger.info(message);
    }

    public void warn (String message){
        logger.warn(message);
    }

}
