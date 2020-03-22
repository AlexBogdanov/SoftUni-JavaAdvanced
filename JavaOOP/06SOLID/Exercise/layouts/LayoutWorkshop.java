package layouts;

import layouts.interfaces.Layout;
import layouts.interfaces.LayoutFactory;

public class LayoutWorkshop implements LayoutFactory {

    private String layoutType;

    public LayoutWorkshop(String layoutType) {
        this.layoutType = layoutType;
    }

    @Override
    public Layout createLayout() {
        switch (this.layoutType) {
            case "SimpleLayout":
                return new SimpleLayout();
            case "XmlLayout":
                return new XmlLayout();
            default:
                throw new IllegalArgumentException("Invalid layout type: " + this.layoutType);
        }
    }

}
