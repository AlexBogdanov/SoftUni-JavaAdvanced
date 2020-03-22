package files;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import files.interfaces.FileStore;

public class LogFile implements FileStore {

    private String path;
    private File file;
    private long size;

    public LogFile() {
        this.path = "memory.txt";
        this.file = new File(this.path);
        this.size = 0;
    }

    @Override
    public void write(String text) {
        this.addToSize(text);

        try {
            byte[] bytes = Files.readAllBytes(Paths.get(this.file.getPath()));
            StringBuilder sb = new StringBuilder();

            for (byte b : bytes) {
                sb.append(Character.valueOf((char) b));
            }

            sb.append(System.lineSeparator())
                .append(text);

            PrintWriter writer = new PrintWriter(this.file);
            writer.write(sb.toString());
            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public long getSize() {
        return this.size;
    }

    private void addToSize(String text) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isAlphabetic(ch)) {
                this.size += ch;
            }
        }
    }

}
