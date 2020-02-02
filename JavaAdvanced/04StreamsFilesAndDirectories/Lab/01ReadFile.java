import java.io.FileInputStream;
import java.io.IOException;

class ReadFile {

    public static void main(String[] args) {
        
        StringBuilder sb = readAndWrite();
        System.out.println(sb);

    }

    private static StringBuilder readAndWrite() {
        String path = "./resources/input.txt";
        StringBuilder sb = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(path)) {
            for (int b = fis.read(); b > -1; b = fis.read()) {
                sb.append(Integer.toBinaryString(b) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb;
    }

}
