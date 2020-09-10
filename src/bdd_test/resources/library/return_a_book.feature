Feature: A librarian may return books that were borrowed

  As a librarian,
  I want to mark books as returned,
  so that they can be checked out again.

  Scenario: Able to make a returned book available for borrowing
    Given a borrower had checked out a book, "The Devops Handbook",
    When I enter that book as returned
    Then it is available to be borrowed

  Scenario: Not able to return a non-borrowed book
    Given a book, "The Devops Handbook" is available for borrowing,
    When I enter that book as returned
    Then I am presented an error about it already being available

  Scenario: Graceful failure - network issues
    Given the network connection has gone down
    When the librarian tries to return the book
    Then the system provides a meaningful error message

  Scenario: Returned books have their date of return recorded
    Given a borrower had checked out a book, "The Devops Handbook",
    When I enter that book as returned
    Then its return date is recorded