package layouts;

import layouts.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String date, String reportLevel, String msg) {
        return String.format(
            "%s - %s - %s",
            date,
            reportLevel,
            msg
        );
    }

}
