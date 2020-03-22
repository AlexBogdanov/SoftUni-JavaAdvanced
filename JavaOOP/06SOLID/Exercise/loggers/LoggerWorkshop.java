package loggers;

import java.util.List;

import appenders.interfaces.Appender;
import enums.ReportLevel;
import loggers.interfaces.Logger;
import loggers.interfaces.LoggerFactory;

public class LoggerWorkshop implements LoggerFactory {

    @Override
    public Logger createLogger(List<Appender> appenders) {
        Appender[] appendersArr = (Appender[]) appenders
            .stream().toArray(Appender[]::new);
        return new MessageLogger(appendersArr);
    }

    @Override
    public void write(String date, ReportLevel reportLevel, String msg, Logger logger) {
        switch (reportLevel) {
            case INFO:
                logger.logInfo(date, msg);
                break;
            case WARNING:
                logger.logWarning(date, msg);
                break;
            case ERROR:
                logger.logError(date, msg);
                break;
            case CRITICAL:
                logger.logCritical(date, msg);
                break;
            case FATAL:
                logger.logFatal(date, msg);
                break;
        }
    
    }

}
