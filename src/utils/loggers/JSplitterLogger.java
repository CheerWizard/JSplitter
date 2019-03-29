package utils.loggers;

import org.jetbrains.annotations.Contract;

import java.util.logging.Logger;

public final class JSplitterLogger {

    private static Logger logger = Logger.getGlobal();

    public static void info(String className , String message) {
        logger.info("===================" + className + "====================");
        logger.info(message);
    }

    public static void warn(String className , String message) {
        logger.info("===================" + className + "====================");
        logger.warning(message);
    }

    public static void error(String className , String message) {
        logger.info("===================" + className + "====================");
        logger.severe(message);
    }

    @Contract(pure = true)
    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        JSplitterLogger.logger = logger;
    }
}
