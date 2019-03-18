public class Library {

    int maxBookCapacity, maxBorrowedBooks, maxPatronCapacity;

    Book[] books;

    Patron[] patrons;

    Library(int maxBookCapacity, int maxBorrowedBooks, int maxPatronCapacity){
        this.maxBookCapacity = maxBookCapacity;
        this.maxBorrowedBooks = maxBorrowedBooks;
        this.maxPatronCapacity = maxPatronCapacity;

        books = new Book[maxBookCapacity];
        patrons = new Patron[maxPatronCapacity];
    }

    int addBookToLibrary(Book book){
        if (getBookId(book) != -1) return -1; // if book is not in library already

        for (int i = 0; i < maxBookCapacity; i++){
            if (this.books[i] == null){
                this.books[i] = book;
                return i;                    // successful, return id
            }
        }

        return -1; // if there is no space
    }

    boolean isBookIdValid(int bookId){
        if ((bookId < this.maxBookCapacity) & (this.books[bookId] != null)) return true;
        return false;
    }

    int getBookId(Book book){
        for (int i = 0; i < maxBookCapacity; i++){
            if (this.books[i] == book) return i;
        }

        return -1;
    }

    boolean isBookAvailable(int bookId){
        if (isBookIdValid(bookId)) {                                             // if book in library
            if (this.books[bookId].borrowerId == -1)                          // if book isn't borrowed already
                return true;
        }

        return false;
    }

    boolean isPatronRegistered(Patron patron){
        for (int i = 0; i < maxPatronCapacity; i++)
            if (this.patrons[i] == patron)
                    return true;

        return false;
    }

    int registerPatronToLibrary(Patron patron){
        if (isPatronRegistered(patron)) return -1; // delete this in case this is unnecessary
                                                    // this is for when a patron can try to register twice

        for (int i = 0; i < maxPatronCapacity; i++){
            if (this.patrons[i] == null){
                this.patrons[i] = patron;
                return i;
            }
        }

        return -1; // no space
    }

    boolean isPatronIdValid(int patronId){
        if ((patronId < this.maxPatronCapacity) & (this.books[patronId] != null)) return true;
        return false;
    }

    int getPatronId(Patron patron){
        for (int i = 0; i < this.patrons.length; i++) {
            if (this.patrons[i] == patron)
                return i;
        }

        return -1;                           // no patron matching
    }

    boolean borrowBook(int bookId, int patronId) {
        Book currBook;          // those two are unnecessary but help with readability
        Patron currPatron;

        if (isBookIdValid(bookId))
            currBook = this.books[bookId];
        else
            return false;
        if (isPatronIdValid(patronId))
            currPatron = this.patrons[patronId];
        else
            return false;

        if (!currPatron.willEnjoyBook(currBook))        // patron should enjoy book if he wants to borrow it
            return false;

        if (isBorrowerAtLimit(patronId))                // patron shouldn't have too many books borrowed
            return false;

        currBook.setBorrowerId(patronId);               // success. we mark the book as borrowed by the patron
        return true;

    }

    boolean isBorrowerAtLimit(int patronId){
        /* This function goes through all the books to check how many of them borrowed by the patron in question.
        * This function could be more efficient if we could add 'currently_borrowed_books' parameter to the Patron
        * class, but we are not allowed to do so (?). so I guass this is the way we should do it?*/

        int booksBorrowed = 0;

        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i].getBorrowerId() == patronId) {
                booksBorrowed++;
                if (booksBorrowed == maxBookCapacity)
                    return true;
            }
        }

        return false;

    }

    void returnBook(int bookId){
        if (isBookIdValid(bookId))
            this.books[bookId].returnBook();
    }

    Book suggestBookToPatron(int patronId){
        Book currBestBook = null;
        Patron patron;

        if (isPatronIdValid(patronId))
            patron = this.patrons[patronId];
        else
            throw new NullPointerException("cant suggest Book to non-valid patron");

        for (int i = 0; i < this.books.length; i++){
            if (this.books[i] != null){
                if (patron.willEnjoyBook(this.books[i])){       // only suggesting books patrin
                                                                                   // will enjoy
                    if (currBestBook == null) {
                        currBestBook = this.books[i];
                    }
                    else{
                        if (patron.getBookScore(currBestBook) < patron.getBookScore(this.books[i]))
                            currBestBook = this.books[i];
                    }
                }
            }
        }

        return currBestBook;
    }

}
