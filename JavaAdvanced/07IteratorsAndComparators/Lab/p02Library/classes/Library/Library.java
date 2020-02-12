package p02Library.classes.Library;

import java.util.Iterator;

import p02Library.classes.Book.Book;

public class Library implements Iterable<Book> {

    private Book[] books;
    private int pointer;

    public Library(Book... books) {
        this.books = books;
        this.pointer = 0;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<Book> {

        @Override
        public boolean hasNext() {
            return pointer < books.length;
        }

        @Override
        public Book next() {
            return books[pointer++];
        }

    }

}
