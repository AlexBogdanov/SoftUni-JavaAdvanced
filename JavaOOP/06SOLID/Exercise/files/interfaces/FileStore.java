package files.interfaces;

public interface FileStore {

    void write(String text);
    long getSize();

}
