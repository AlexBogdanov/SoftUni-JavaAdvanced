package p02Library;

import p02Library.classes.Book.Book;
import p02Library.classes.Library.Library;

public class Main {

    public static void main(String[] args) {
        
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("Farm Animal", 2002);
        Book bookTwo = new Book("Farm", 2009, "George Orwell", "Some Demo", "Demo Some");

        Library library = new Library(bookOne, bookTwo, bookThree);

        for (Book book : library) {
            System.out.println(book.getTitle());
        }

    }

}
