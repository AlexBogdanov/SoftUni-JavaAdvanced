package p01SortByNameAndAge.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    private static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static String nextLine() throws IOException {
        return READER.readLine();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(READER.readLine());
    }

}
