package p03ComparableBook;

import p03ComparableBook.Book.Book;

public class Main {

    public static void main(String[] args) {
        
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("Farm Animal", 2002);
        Book bookTwo = new Book("Farm", 2009, "George Orwell", "Some Demo", "Demo Some");

        if (bookOne.compareTo(bookTwo) > 0) {
            System.out.println(String.format(
                "%s is before %s",
                bookOne, bookTwo
            ));
        } else if (bookOne.compareTo(bookTwo) < 0) {
            System.out.println(String.format(
                "%s is before %s",
                bookTwo, bookOne
            ));
        } else {
            System.out.println("Books are equal");
        }

    }

}
