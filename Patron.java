public class Patron {
    /* This class represents a library patron.
    A patron has name, literary tendencies and a thereshold of enjoyment he needs to reach before he will want a
    certain book.
     */

    String firstName, lastName;
    int comicTendency, dramaticTendency, educationalTendency, enjoymentThreshold;

    Patron(String patronFirstName, String patronLastName, int comicTendency, int dramaticTendency,
           int educationalTendency, int patronenjoymentThreshold){
        /* The constructor for the patron class */
        this.firstName = patronFirstName;
        this.lastName = patronLastName;
        this.comicTendency = comicTendency;
        this.dramaticTendency = dramaticTendency;
        this.educationalTendency = educationalTendency;
        this.enjoymentThreshold = patronenjoymentThreshold;
    }

    String stringRepresentation(){
        /* returns a string with the name and last name of the patron. */
        return this.firstName + " " + this.lastName;
    }

    int getBookScore(Book book){
        /* returns an int representing the score the patron will give to a certain book.
        The score depends on the literary tendencies the patron has and the literary asspects the book has.
         */
        return ((book.comic_value * this.comicTendency) + (book.dramatic_value * this.dramaticTendency) +
                (book.educational_value * this.educationalTendency));
    }

    boolean willEnjoyBook(Book book){
        /* returns true if the patron will enjoy a certain book, or false otherwise.
        Whether a patron enjoys a book or not depends on if the score the patrons assighns to the book is higher
        (or equal to) the enjoyment threshold of the patron.
         */
        return (this.enjoymentThreshold <= getBookScore(book));
    }
}
