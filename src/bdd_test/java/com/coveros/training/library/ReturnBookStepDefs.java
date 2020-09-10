package com.coveros.training.library;

import com.coveros.training.library.domainobjects.Book;
import com.coveros.training.library.domainobjects.Borrower;
import com.coveros.training.persistence.IPersistenceLayer;
import com.coveros.training.persistence.PersistenceLayer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

public class ReturnBookStepDefs {

    private Book myBook = Book.createEmpty();
    private Borrower myBorrower = Borrower.createEmpty();
    private String borrowerName = "does_not_matter";
    private static final Date BORROW_DATE = Date.valueOf(LocalDate.of(2018, Month.JANUARY, 1));
    private final IPersistenceLayer pl = new PersistenceLayer();
    private LibraryUtils libraryUtils = LibraryUtils.createEmpty();

    /**
     * Set up the databases, clear them, initialize the Library Utility with them.
     */
    private void initializeEmptyDatabaseAndUtility() {
        pl.cleanAndMigrateDatabase();
        libraryUtils = new LibraryUtils();
    }

    @Given("a borrower had checked out a book, {string},")
    public void a_borrower_had_checked_out_a_book(String book) {
        initializeEmptyDatabaseAndUtility();
        libraryUtils.registerBook(book);
        myBook = libraryUtils.searchForBookByTitle(book);
        libraryUtils.registerBorrower(borrowerName);
        myBorrower = libraryUtils.searchForBorrowerByName(borrowerName);
        libraryUtils.lendBook(myBook, myBorrower, BORROW_DATE);
    }

    @When("I enter that book as returned")
    public void i_enter_that_book_as_returned() {
        libraryUtils.returnBook();
    }

    @Then("it is available to be borrowed")
    public void it_is_available_to_be_borrowed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("a book, {string} is available for borrowing,")
    public void a_book_is_available_for_borrowing(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I am presented an error about it already being available")
    public void i_am_presented_an_error_about_it_already_being_available() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("the network connection has gone down")
    public void the_network_connection_has_gone_down() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the librarian tries to return the book")
    public void the_librarian_tries_to_return_the_book() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the system provides a meaningful error message")
    public void the_system_provides_a_meaningful_error_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("its return date is recorded")
    public void its_return_date_is_recorded() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
