import java.util.Random;

public class Main {
    /*
        1. should the class's private parameters have a similar name to the ones it's given in the constructor?
            for example: if 'Car' class have constructor 'Car(int fuel)', should its private parameter be called 'fuel'
            or is it better to change it to something similar such ass '__fuel' or 'pFuel'
    */

    public static void main(String[] args) {
        /* main used for testing */
        System.out.println(isPassingTest1());

        System.out.println(isPassingTest2());

        System.out.println(isPassingTest3());

        /*
        Random rand = new Random();
        Book[] myBooks = new Book[10];
        Patron[] myPatrons = new Patron[5];
        Library myLibrary = new Library(9, 10, 10);

        for (int i = 0; i < 10; i++) {
            myBooks[i] = new Book("monkey Island " + (i + 1), "captain cook",
                    1989, rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
        }
        for (int i = 0; i < 5; i++) {
            myPatrons[i] = new Patron("Alex", "Molosky", rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(20) + 40);
        }

        System.out.println(myPatrons[0].stringRepresentation());
        System.out.println(myPatrons[0].comicTendency);
        System.out.println(myPatrons[0].dramaticTendency);
        System.out.println(myPatrons[0].educationalTendency);
        System.out.println(myPatrons[0].enjoymentThreshold + "(threshold)");
        System.out.println(myBooks[0].stringRepresentation());
        System.out.println(myBooks[0].comic_value);
        System.out.println(myBooks[0].dramatic_value);
        System.out.println(myBooks[0].educational_value);

        System.out.println('-');

        System.out.println(myPatrons[0].getBookScore(myBooks[0]) + "(patron book score)");
        System.out.println(myPatrons[0].willEnjoyBook(myBooks[0]));

        System.out.println('-');

        for (int i = 0; i < 10; i++){
            System.out.println(myLibrary.addBookToLibrary(myBooks[i]));
        }   */
    }

    static String isPassingTest1(){
        /* tests the book class */
        Book book = new Book("monkey Island", "Ron Gilbert",
                    1990, 0, 5, 10);

        if (book.getLiteraryValue() != 15) return "Test 1 Failed.";
        if (book.stringRepresentation().compareTo("[monkey Island,Ron Gilbert,1990,15]") != 0)
            return "Test 1 Failed. Problem in stringRepresentation().";
        if (book.getBorrowerId() != -1) return "Test 1 Failed.";
        book.setBorrowerId(7);
        if (book.getBorrowerId() != 7) return "Test 1 Failed.";

        return "Test 1 Passed.";
    }

    static String isPassingTest2(){
        /* tests the patron class */
        Book book1 = new Book("Poetry for kids", "Abe Linkons",
                1891, 1, 5, 10);
        Book book2 = new Book("Advenced quantum mechanics, part II", "Mark chillman",
                1891, 10, 4, 0);
        Patron patron = new Patron("Alex", "Molotsky", 10,
                1, 10, 115);

        if (patron.stringRepresentation().compareTo("Alex Molotsky") != 0) return "Test 2 Failed.";
        if (patron.getBookScore(book1) != 115) return "Test 2 Failed.";
        if (patron.getBookScore(book2) != 104) return "Test 2 Failed.";
        if (!patron.willEnjoyBook(book1)) return "Test 2 Failed.";
        if (patron.willEnjoyBook(book2)) return "Test 2 Failed.";

        return "Test 2 Passed.";
    }

    static String isPassingTest3(){
        /* tests the patron class */
        Book book1 = new Book("Choclate rain", "Tay Zonday",
                1891, 1, 5, 10);
        Book book2 = new Book("double rainbow all the way", "Paul Vasquez",
                1891, 10, 4, 0);
        Patron patron = new Patron("Alex", "Molotsky", 10,
                1, 10, 115);
        Library library = new Library(9, 2, 3);

        return "Test 3 Passed.";
    }
}
