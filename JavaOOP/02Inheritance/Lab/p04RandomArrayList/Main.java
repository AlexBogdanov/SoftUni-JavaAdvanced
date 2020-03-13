package p04RandomArrayList;

public class Main {

    public static void main(String[] args) {

        var randomArrayList = new RandomArrayList<String>();
        randomArrayList.add("some");
        randomArrayList.add("demo");
        randomArrayList.add("new");

        System.out.println(randomArrayList.getRandomElement());

    }

}
