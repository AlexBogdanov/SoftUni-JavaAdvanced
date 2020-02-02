import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class CopyBytes {

    public static void main(String[] args) {
        
        readAndWrite();

    }

    private static void readAndWrite() {
        String readPath = "./resources/input.txt";
        String writePath = "./resources/03.CopyBytesOutput.txt";

        try (
            FileInputStream fis = new FileInputStream(readPath);
            FileOutputStream fos = new FileOutputStream(writePath);
        ) {
            Scanner scanner = new Scanner(fis);
            PrintWriter pw = new PrintWriter(fos);
            
            while(scanner.hasNext()) {
                String input = scanner.next();
                
                for (int i = 0; i < input.length(); i++) {
                    pw.write((int) input.charAt(i) + "");
                }

                pw.write(" ");
            }

            pw.flush();
            scanner.close();
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
