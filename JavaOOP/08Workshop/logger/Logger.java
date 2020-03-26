package logger;

public class Logger {

    public void log(String msg) {
        System.out.println(msg);
    }

    public void logErr(String errMsg) {
        System.err.println(errMsg);
    }

}
