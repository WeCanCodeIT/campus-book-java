package org.wcci.libraries;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {


    private BookStorage bookStorage;

    public BookController(BookStorage bookStorage) {

        this.bookStorage = bookStorage;
    }
    @GetMapping("books/{id}")
    public String displaySingleBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookStorage.retrieveBookById(id));
        return "single-book-template";
    }
}
// MVC method tests:
// 1. Name of template to be used.
// 2. That the right value is added to the model with the right attribute name.
// 3. Is this a controller with mapping?