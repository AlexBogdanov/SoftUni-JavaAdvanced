package p04BookComparator.classes.Book;

import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.authors = new ArrayList<>();
        
        this.title = title;
        this.year = year;
        setAuthors(authors);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(String... authors) {
        this.authors = List.of(authors);
    }

    @Override
    public int compareTo(Book b) {
        
        int res = this.title.compareTo(b.getTitle());
        
        if (res == 0) {
            if (this.year > b.getYear()) {
                res = 1;
            } else if (this.year < b.getYear()) {
                res = -1;
            }
        }

        return res;
    }

}
