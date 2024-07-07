package Backend.controllers;

import java.util.List;
import Backend.dto.ArtPieceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Backend.model.ArtPiece;
import Backend.services.ArtPieceService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/saveArtPiece")
    public ArtPiece saveArtPiece(@RequestBody ArtPieceDTO artPieceDTO) {

        ArtPiece savedArtPiece = artPieceService.saveArtPiece(artPieceDTO);

        return savedArtPiece;
    }

    @GetMapping("/getArtpiecesForRoute")
    public List<ArtPiece> getArtpiecesForRoute(@RequestParam(value = "routeId") Integer routeId) {
        return artPieceService.getArtpiecesForRoute(routeId);
    }

    @PutMapping("updateArtPieceDescription")
    public boolean updateAP(@RequestParam(value = "id") String id, @RequestParam(value = "desc") String description) {
        return artPieceService.updateArtPieceDescription(id, description);
    }
}
