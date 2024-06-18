package Backend.controllers;

import java.util.List;

import Backend.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AuthorDTO> saveAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = new Author();
        author.setNameAuthor(authorDTO.getNameAuthor());
        author.setSurnameAuthor(authorDTO.getSurnameAuthor());
        author.setText1Author(authorDTO.getText1Author());
        author.setText2Author(authorDTO.getText2Author());
        author.setText3Author(authorDTO.getText3Author());
        author.setArtPieces(authorDTO.getArtPieces());

        Author savedAuthor = authorService.saveAuthor(author);

        AuthorDTO savedAuthorDTO = new AuthorDTO();
        savedAuthorDTO.setId(savedAuthor.getid());
        savedAuthorDTO.setNameAuthor(savedAuthor.getNameAuthor());
        savedAuthorDTO.setSurnameAuthor(savedAuthor.getSurnameAuthor());
        savedAuthorDTO.setText1Author(savedAuthor.getText1Author());
        savedAuthorDTO.setText2Author(savedAuthor.getText2Author());
        savedAuthorDTO.setText3Author(savedAuthor.getText3Author());

        return ResponseEntity.ok(savedAuthorDTO);
    }
}
