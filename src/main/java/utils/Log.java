package utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Log {
   public static Logger logger = Logger.getLogger(Log.class.getName());
    public static Properties prop = new Properties();
    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }


    public static void debug(String message) {
        logger.debug(message);
    }

    public static Logger logg = null;
    public static Log log = null;
    public static Log getLogger(Class<?> T){
        if(logg!= null){
            InputStream is = null;
            try {
                is = new FileInputStream(new File("src\\main\\resources\\log4j.properties"));
                prop.load(is);
            } catch (Exception e) {
                e.printStackTrace();
            }
            PropertyConfigurator.configure(prop);
            logg = Logger.getLogger(T);
            log = new Log();
        }
        return log;
    }

//    public static void readLogConfig() {
//
//        InputStream is = null;
//        try {
//            is = new FileInputStream(new File("src\\main\\resources\\logConfig\\log4j.properties"));
//            prop.load(is);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
