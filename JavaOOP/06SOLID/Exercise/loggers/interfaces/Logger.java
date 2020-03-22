package loggers.interfaces;

public interface Logger {

    void logInfo(String date, String msg);
    void logWarning(String date, String msg);
    void logError(String date, String msg);
    void logCritical(String date, String msg);
    void logFatal(String date, String msg);

}
