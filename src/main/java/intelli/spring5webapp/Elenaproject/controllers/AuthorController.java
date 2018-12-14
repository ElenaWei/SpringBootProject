package intelli.spring5webapp.Elenaproject.controllers;

import intelli.spring5webapp.Elenaproject.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by Elena on 12/6/2018
 */
@Controller
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}
