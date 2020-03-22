package loggers.interfaces;

import java.util.List;

import appenders.interfaces.Appender;
import enums.ReportLevel;

public interface LoggerFactory {

    Logger createLogger(List<Appender> appenders);
    void write(String date, ReportLevel reportLevel, String msg, Logger logger);

}
