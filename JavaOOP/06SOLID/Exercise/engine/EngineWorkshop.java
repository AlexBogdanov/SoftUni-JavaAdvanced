package engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import appenders.AppenderWorkshop;
import appenders.interfaces.Appender;
import enums.ReportLevel;
import loggers.LoggerWorkshop;
import loggers.interfaces.Logger;

public class EngineWorkshop {

    private BufferedReader reader;

    public EngineWorkshop() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        try {
            List<Appender> appenders = createAppenders();
            var loggerWorker = new LoggerWorkshop();
            Logger logger = loggerWorker.createLogger(appenders);
            write(loggerWorker, logger);
            print(logger);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void print(Logger logger) {
        System.out.println(logger.toString());
    }

    private void write(LoggerWorkshop loggerWorker, Logger logger) throws IOException {
        for (String input = reader.readLine(); !input.equals("END"); input = reader.readLine()) {
            String[] tokens = input.split("\\|+");
            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String date = tokens[1];
            String msg = tokens[2];
            loggerWorker.write(date, reportLevel, msg, logger);
        }
    }

    private List<Appender> createAppenders() throws NumberFormatException, IOException {
        var appenders = new ArrayList<Appender>();
        
        int n = Integer.parseInt(this.reader.readLine());
        while (n-- > 0) {
            String[] tokens = this.reader.readLine().split("\\s+");
            var appenderWorker = new AppenderWorkshop(tokens);
            appenders.add(appenderWorker.createAppender());
        }

        return appenders;
    }

}
