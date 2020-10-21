package org.wcci.libraries;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BookStorageTest {

    @Test
    public void bookStorageShouldSaveBooks() {
        //Arrangement
        BookRepository bookRepo = mock(BookRepository.class);
        BookStorage underTest = new BookStorage(bookRepo);
        Book mockBook = mock(Book.class);

        //Action
        underTest.saveBook(mockBook);

        //Assertion
        verify(bookRepo).save(mockBook);
    }
    @Test
    public void bookStorageShouldRetrieveBookWithId(){

        BookRepository bookRepo = mock(BookRepository.class);
        BookStorage underTest = new BookStorage(bookRepo);
        Book mockBook = mock(Book.class);
        when(bookRepo.findById(1L)).thenReturn(Optional.of(mockBook));


        Book retrievedBook = underTest.retrieveBookById(1L);

        assertThat(retrievedBook).isEqualTo(mockBook);

    }


}
