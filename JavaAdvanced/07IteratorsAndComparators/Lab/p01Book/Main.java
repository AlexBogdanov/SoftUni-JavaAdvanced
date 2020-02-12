package p01Book;

import java.util.ArrayList;
import java.util.List;

import p01Book.Book.Book;

public class Main {

    public static void main(String[] args) {
        
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("Farm Animal", 2002);
        Book bookTwo = new Book("Farm", 2009, "George Orwell", "Some Demo", "Demo Some");

        List<Book> books = new ArrayList<>();

        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

    }

}
