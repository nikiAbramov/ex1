public class Book {
    /* the class representing a book, which have title, author, year of publication and literery values */

    String title, author;
    int yearOfPoblication, comic_value, dramatic_value, educational_value, borrowerId;

    Book(String bookTitle, String bookAuthor, int bookYearOfPoblication, int bookComicValue,
         int bookDramaticValue, int bookEducationalValue) {
        /* constructor for the book class */

        this.title = bookTitle;
        this.author = bookAuthor;
        this.yearOfPoblication = bookYearOfPoblication;
        this.comic_value = bookComicValue;
        this.dramatic_value = bookDramaticValue;
        this.educational_value = bookEducationalValue;
        this.borrowerId = -1;
    }

    String stringRepresentation(){
        /* This method returns a string with information about the book */
        return "["+this.title+"," + this.author + "," + this.yearOfPoblication + "," + getLiteraryValue() +"]";
    }

    int getLiteraryValue(){
        /* This method reurns an int representing the literary value of the book - the sum of its literary asspects. */
        return (this.comic_value + this.dramatic_value + this.educational_value);
    }

    void setBorrowerId(int borrowerId){
        /* This method sets the book borrower id. */
        this.borrowerId = borrowerId;
    }

    int getBorrowerId(){
        /* This method returns the borrowers id, -1 represents no current borrower. */
        return this.borrowerId;
    }

    void returnBook(){
        /* this method sets the borrower id to -1, representing no borrower. */
        this.borrowerId = -1;
    }
}
