package loggers;

import java.util.List;

import appenders.FileAppender;
import appenders.interfaces.Appender;
import controllers.Controller;
import enums.ReportLevel;
import loggers.interfaces.Logger;

public class MessageLogger implements Logger {

    private List<Appender> appenders;

    public MessageLogger(Appender ...appenders) {
        this.appenders = List.of(appenders);
    }

    @Override
    public void logInfo(String date, String msg) {
        Controller controller = new Controller(this.appenders, date, ReportLevel.INFO, msg);
        controller.log();
    }

    @Override
    public void logWarning(String date, String msg) {
        Controller controller = new Controller(this.appenders, date, ReportLevel.WARNING, msg);
        controller.log();
    }

    @Override
    public void logError(String date, String msg) {
        Controller controller = new Controller(this.appenders, date, ReportLevel.ERROR, msg);
        controller.log();
    }

    @Override
    public void logCritical(String date, String msg) {
        Controller controller = new Controller(this.appenders, date, ReportLevel.CRITICAL, msg);
        controller.log();

    }

    @Override
    public void logFatal(String date, String msg) {
        Controller controller = new Controller(this.appenders, date, ReportLevel.FATAL, msg);
        controller.log();

    }

    @Override
    public String toString() {
        StringBuilder appendersInfo = new StringBuilder();

        for (Appender appender : this.appenders) {
            appendersInfo.append(String.format(
                "Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                appender.getClass().getSimpleName(),
                appender.getLayout().getClass().getSimpleName(),
                appender.getReportLevel().toString(),
                appender.getMsgsCount()
            ));

            if (appender.getClass().getSimpleName().equals("FileAppender")) {
                var fileAppender = (FileAppender) appender;
                appendersInfo.append(", File size: " + fileAppender.getFile().getSize());
            }

            appendersInfo.append(System.lineSeparator());
        }

        return String.format(
            "Logger info%n%s",
            appendersInfo.toString()
        );
    }

}
