package appenders;

import enums.ReportLevel;
import layouts.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String date, String reportLevel, String msg) {
        ReportLevel currReportLevel = ReportLevel.valueOf(reportLevel.toUpperCase());

        if (this.getReportLevel().ordinal() > currReportLevel.ordinal()) {
            return;
        }

        String formatted = this.getLayout().format(date, reportLevel, msg);
        System.out.println(formatted);
        this.incrementMsgs();
    }

}
