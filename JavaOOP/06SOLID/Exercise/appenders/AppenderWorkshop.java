package appenders;

import appenders.interfaces.Appender;
import appenders.interfaces.AppenderFactory;
import enums.ReportLevel;
import files.LogFile;
import files.interfaces.FileStore;
import layouts.LayoutWorkshop;
import layouts.interfaces.Layout;

public class AppenderWorkshop implements AppenderFactory {
    
    private String appenderType;
    private String layoutType;
    private ReportLevel reportLevel;

    public AppenderWorkshop(String ...args) {
        this.appenderType = args[0];
        this.layoutType = args[1];

        if (args.length > 2) {
            this.reportLevel = ReportLevel.valueOf(args[2]);
        } else {
            this.reportLevel = ReportLevel.INFO;
        }
    }

    @Override
    public Appender createAppender() {
        var layoutWorker = new LayoutWorkshop(this.layoutType);
        Layout layout = layoutWorker.createLayout();

        switch(this.appenderType) {
            case "ConsoleAppender":
                var consoleAppender = new ConsoleAppender(layout);
                consoleAppender.setReportLevel(this.reportLevel);
                return consoleAppender;
            case "FileAppender":
                var fileAppender = new FileAppender(layout);
                fileAppender.setReportLevel(this.reportLevel);
                FileStore file = new LogFile();
                fileAppender.setFile(file);
                return fileAppender;
            default:
                throw new IllegalArgumentException("Illegal appender type: " + this.appenderType);
        }
    }

}
