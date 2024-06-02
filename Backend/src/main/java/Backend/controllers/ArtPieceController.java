package Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Backend.model.ArtPiece;
import Backend.services.ArtPieceService;

@RestController
@RequestMapping("/artPiece")
@CrossOrigin
public class ArtPieceController {
    @Autowired
    private ArtPieceService artPieceService;

    @GetMapping("/yearsCreated")
    private List<Integer> yearsCreated() {
        return artPieceService.yearsCreated();
    }

    @GetMapping("/getAll")
    private List<ArtPiece> getAll() {
        return artPieceService.getAll();
    }

    @GetMapping("/getByYear")
    private List<ArtPiece> getByYear(@RequestParam(value = "yearCreated") Integer yearCreated) {
        return artPieceService.getByYear(yearCreated);
    }

    @GetMapping("/getByAuthor")
    private List<ArtPiece> getByAuthor(@RequestParam(value = "authorId") Integer authorId) {
        return artPieceService.getByAuthor(authorId);
    }

    @GetMapping("/getByEpoch")
    private List<ArtPiece> getByEpoch(@RequestParam(value = "epochId") Integer epochId) {
        return artPieceService.getByEpoch(epochId);
    }

}
