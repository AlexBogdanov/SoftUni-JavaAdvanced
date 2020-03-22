package appenders;

import enums.ReportLevel;
import files.interfaces.FileStore;
import layouts.interfaces.Layout;

public class FileAppender extends AppenderImpl {

    private FileStore file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    public FileStore getFile() {
        return this.file;
    }

    public void setFile(FileStore file) {
        this.file = file;
    }

    @Override
    public void append(String date, String reportLevel, String msg) {
        ReportLevel currReportLevel = ReportLevel.valueOf(reportLevel.toUpperCase());

        if (this.getReportLevel().ordinal() > currReportLevel.ordinal()) {
            return;
        }
        
        String formatted = this.getLayout().format(date, reportLevel, msg);
        this.file.write(formatted);
        this.incrementMsgs();
    }

}
