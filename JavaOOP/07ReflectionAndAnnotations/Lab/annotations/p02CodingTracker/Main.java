package annotations.p02CodingTracker;

public class Main {

    @Author(name = "Denis")
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {

        Class<Main> mainClass = Main.class;
        Class<Tracker> trackerClass = Tracker.class;
        
        Tracker.printMethodsByAuthor(mainClass);
        Tracker.printMethodsByAuthor(trackerClass);

    }

}
