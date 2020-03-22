package layouts;

import layouts.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String format(String date, String reportLevel, String msg) {
        return String.format(
            "<log>%n<date>%s</date>%n<level>%s</level>%n<message>%s</message>%n</log>",
            date,
            reportLevel,
            msg
        );
    }

}
