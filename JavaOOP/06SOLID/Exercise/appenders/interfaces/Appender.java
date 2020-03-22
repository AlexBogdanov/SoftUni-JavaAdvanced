package appenders.interfaces;

import enums.ReportLevel;
import layouts.interfaces.Layout;

public interface Appender {

    Layout getLayout();
    int getMsgsCount();
    ReportLevel getReportLevel();
    void append(String date, String reportLevel, String msg);
    void setReportLevel(ReportLevel reportLevel);
    void incrementMsgs();

}
