package Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.model.Author;
import Backend.services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/author")
@CrossOrigin
public class AuthorContoller {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/getAll")
    private List<Author> getAuthors() {
        return authorService.getAuthors();
    }

}
