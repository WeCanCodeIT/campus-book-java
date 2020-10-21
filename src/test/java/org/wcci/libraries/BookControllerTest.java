package org.wcci.libraries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest {


    private BookController underTest;
    private Model model;
    private BookStorage mockStorage;

    @BeforeEach
    void setUp() {
        mockStorage = mock(BookStorage.class);
        underTest = new BookController(mockStorage);
        model = mock(Model.class);
    }

    @Test
    public void displaySingleBookShouldUseSingleBookTemplate() {
        //Action
        String templateName = underTest.displaySingleBook(1L, model);
        //Assertion
        assertThat(templateName).isEqualTo("single-book-template");
    }

    @Test
    public void displaySingleBookShouldAddBookToModelFromBookStorage() {
        Book mockBook = mock(Book.class);
        when(mockStorage.retrieveBookById(2L)).thenReturn(mockBook);

        underTest.displaySingleBook(2L, model);

        verify(model).addAttribute("book", mockBook);

    }

    @Test
    public void displaySinglePageShouldBeMappedCorrectly() throws Exception {
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/books/1"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
