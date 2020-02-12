package p04BookComparator;

import java.util.ArrayList;
import java.util.List;

import p04BookComparator.classes.Book.Book;
import p04BookComparator.classes.BookComparator.BookComparator;

public class Main {

    public static void main(String[] args) {
        
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("Farm Animal", 2002);
        Book bookTwo = new Book("Farm", 2009, "George Orwell", "Some Demo", "Demo Some");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        books.sort(new BookComparator());

        for (Book book : books) {
            System.out.println(book.getTitle() + book.getYear());
        }

    }

}
