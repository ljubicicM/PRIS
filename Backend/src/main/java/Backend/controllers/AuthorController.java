package Backend.controllers;

import java.util.List;

import Backend.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Backend.model.Author;
import Backend.services.AuthorService;

@RestController
@RequestMapping("/author")
@CrossOrigin
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/getAll")
    private List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping("/saveAuthor")
    public boolean saveAuthor(@RequestBody AuthorDTO authorDTO) {

        Author savedAuthor = authorService.saveAuthor(authorDTO);

        return savedAuthor == null;
    }

    @PutMapping("updateAuthorTexts")
    public boolean updateAuthorTexts(@RequestParam(value = "id") int id, @RequestParam(value = "gen") int generality,
            @RequestParam(value = "text") String text) {
        return authorService.updateAuthorTexts(id, generality, text);
    }
}
