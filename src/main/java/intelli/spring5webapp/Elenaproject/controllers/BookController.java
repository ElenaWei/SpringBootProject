package intelli.spring5webapp.Elenaproject.controllers;

import intelli.spring5webapp.Elenaproject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by Elena on 12/6/2018
 */
@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}
