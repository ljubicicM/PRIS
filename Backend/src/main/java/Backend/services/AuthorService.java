package Backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.dto.AuthorDTO;
import Backend.model.Author;
import Backend.repositories.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author saveAuthor(AuthorDTO authorDTO) {
        Author author = new Author();

        author.setNameAuthor(authorDTO.getNameAuthor());
        author.setSurnameAuthor(authorDTO.getSurnameAuthor());
        author.setText1Author(authorDTO.getText1Author());
        author.setText2Author(authorDTO.getText2Author());
        author.setText3Author(authorDTO.getText3Author());

        return authorRepository.save(author);
    }

    public Author findById(Integer id) {
        return authorRepository.findById(id).get();
    }

    public boolean updateAuthorTexts(int id, int generality, String text) {
        Author author = authorRepository.findById(id).get();
        if (author != null) {
            if (generality == 1) {
                author.setText1Author(text);
            } else if (generality == 2) {
                author.setText2Author(text);
            } else if (generality == 3) {
                author.setText3Author(text);
            }
            authorRepository.save(author);
            return true;
        }
        return false;
    }
}
