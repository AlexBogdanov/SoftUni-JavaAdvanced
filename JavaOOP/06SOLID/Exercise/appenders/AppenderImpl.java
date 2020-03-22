package appenders;

import appenders.interfaces.Appender;
import enums.ReportLevel;
import layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private int msgsCount;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.msgsCount = 0;
    }

    @Override
    public Layout getLayout() {
        return this.layout;
    }

    @Override
    public int getMsgsCount() {
        return this.msgsCount;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public void incrementMsgs() {
        this.msgsCount++;
    }

}
