package controllers;

import java.util.List;

import appenders.interfaces.Appender;
import enums.ReportLevel;

public class Controller {

    private List<Appender> appenders;
    private String date;
    private ReportLevel reportLevel;
    private String msg;

    public Controller(List<Appender> appenders, String date, ReportLevel reportLevel, String msg) {
        this.appenders = appenders;
        this.date = date;
        this.reportLevel = reportLevel;
        this.msg = msg;
    }

    public void log() {
        for (Appender appender : this.appenders) {
            appender.append(this.date, this.reportLevel.toString(), this.msg);
        }
    }

}
