package p04BookComparator.classes.BookComparator;

import java.util.Comparator;

import p04BookComparator.classes.Book.Book;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        
        int res = b1.getTitle().compareTo(b2.getTitle());
        
        if (res == 0) {
            if (b1.getYear() > b2.getYear()) {
                res = 1;
            } else if (b1.getYear() < b2.getYear()) {
                res = -1;
            }
        }

        return res;

    }

}
