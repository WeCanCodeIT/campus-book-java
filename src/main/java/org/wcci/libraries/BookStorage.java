package org.wcci.libraries;

public class BookStorage {
    private BookRepository bookRepo;

    public BookStorage(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void saveBook(Book bookToSave) {
        bookRepo.save(bookToSave);
    }

    public Book retrieveBookById(long id) {
        return bookRepo.findById(id).get();
    }
}
