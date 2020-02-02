import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class WriteFile {

    public static void main(String[] args) {
        
        readAndWrite();

    }

    private static void readAndWrite() {
        Set<Character> punctuation = new HashSet<>(Arrays.asList(',', '.', '!', '?'));
        String readPath = "./resources/input.txt";
        String writePath = "./resources/02.WriteToFileOutput.txt";

        try (
            FileInputStream fis = new FileInputStream(readPath);
            FileOutputStream fos = new FileOutputStream(writePath);
        ) {
            for (int b = fis.read(); b > -1; b = fis.read()) {
                if (!punctuation.contains((char) b)) {
                    fos.write(b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
