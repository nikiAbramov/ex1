public class Library {
    /**
     * The livrary class descriving a library with books and patrons.
     * @param maxBookCapacity   the maximum ammount of books that the library can hold at any given time
     * @param maxBorrowedBooks  The maximum ammount of books a patron can have at any given time
     * @param maxPatronCapacity The maximum number of patrons that can be registered to the library at any given time
     * @param books               An array of Book objects, holding all the books the library has
     * @param patrons             An array of Patron objects, holding all the registered patrons
     */

    int maxBookCapacity, maxBorrowedBooks, maxPatronCapacity;

    Book[] books;

    Patron[] patrons;

    Library(int maxBookCapacity, int maxBorrowedBooks, int maxPatronCapacity){
        /**
         * The Library constructor
         */
        this.maxBookCapacity = maxBookCapacity;
        this.maxBorrowedBooks = maxBorrowedBooks;
        this.maxPatronCapacity = maxPatronCapacity;

        books = new Book[maxBookCapacity];
        patrons = new Patron[maxPatronCapacity];
    }

    int addBookToLibrary(Book book){
        /**
         * This method adds a book to the library, if the books isn't there already and there is free space.
         * @return a non-negative number that is the book's id that been assigned to it. if the book couldn't be
         *          added, it returns -1 instead.
         */
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
        /**
         * Checks if there is a book with the requested id
         * @return true if there is a book with that id, false otherwise
         */
        if ((bookId < this.books.length) & (this.books[bookId] != null)) return true;
        return false;
    }

    int getBookId(Book book){
        /**
         * This method recives a book objects, checks for it in the library books and returns its id
         * @return  The requested book's id, which is a non-negative number,
         *           if the book isn't in the library it returns -1 instead
         */
        for (int i = 0; i < this.books.length; i++){
            if (this.books[i] == book) return i;
        }

        return -1;
    }

    boolean isBookAvailable(int bookId){
        /**
         * This method checks if a book is currently borrowed or not.
         * @return  returns true if the book can be borrowed, false if the book is already borrowed or it doesn't
         *           exist in the library
         */
        if (isBookIdValid(bookId)) {                                             // if book in library
            if (this.books[bookId].borrowerId == -1)                          // if book isn't borrowed already
                return true;
        }

        return false;
    }

    boolean isPatronRegistered(Patron patron){
        /**
         * This method checks if a patron registered to the library. it is my own method for dealing.
         * This wasn't requered in the API but this method is convenient for 'registerPatronToLibrary'.
         * @return  true if the patron is registered, false otherwise
         */
        for (int i = 0; i < this.patrons.length; i++)
            if (this.patrons[i] == patron)
                    return true;

        return false;
    }

    int registerPatronToLibrary(Patron patron){
        /**
         * registers a patron to the library, effectivly adding him to the library's array of patrons, if there is space
         * and if he isn't registered aready.
         * @return returns the patron's id number. if the patron couldn't be registered, returns -1 instead.
         */
        if (isPatronRegistered(patron)) return getPatronId(patron); // if the patron already registered, returns his id

        for (int i = 0; i < this.patrons.length; i++){
            if (this.patrons[i] == null){
                this.patrons[i] = patron;
                return i;
            }
        }

        return -1; // no space
    }

    boolean isPatronIdValid(int patronId){
        /**
         * Checks if there is a registered patron by the same id number.
         * @return  true if there is a patron with the recived id, false otherwise
         */
        if ((patronId < this.patrons.length) & (this.books[patronId] != null)) return true;
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
