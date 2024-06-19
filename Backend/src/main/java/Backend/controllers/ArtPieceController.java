package Backend.controllers;

import java.util.List;

import Backend.dto.ArtPieceDTO;
import Backend.dto.AuthorDTO;
import Backend.model.Author;
import Backend.services.ArtisticMovementService;
import Backend.services.AuthorService;
import Backend.services.EpochService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Backend.model.ArtPiece;
import Backend.services.ArtPieceService;

@RestController
@RequestMapping("/artPiece")
@CrossOrigin
public class ArtPieceController {
    @Autowired
    private ArtPieceService artPieceService;

    @Autowired
    private ArtisticMovementService artisticMovementService;

    @Autowired
    private EpochService epochService;

    @Autowired
    private AuthorService authorService;

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
    public ResponseEntity<ArtPieceDTO> saveAuthor(@RequestBody ArtPieceDTO artPieceDTO) {

        ArtPiece artPiece = new ArtPiece();

        artPiece.setName(artPieceDTO.getName());
        artPiece.setAddress(artPieceDTO.getAddress());
        artPiece.setDescription(artPieceDTO.getDescription());
        artPiece.setxCoordinate(artPieceDTO.getxCoordinate());
        artPiece.setyCoordinate(artPieceDTO.getyCoordinate());
        artPiece.setRetentionTime(artPieceDTO.getRetentionTime());
        artPiece.setyearCreated(artPieceDTO.getYearCreated());
        artPiece.setImage(artPieceDTO.getImage());
        artPiece.setArtisticMovement(artisticMovementService.findById(artPieceDTO.getArtisticMovementId()));
        artPiece.setEpoch(epochService.findById(artPieceDTO.getEpochId()));
        artPiece.setAuthor(authorService.findById(artPieceDTO.getAuthorId()));

        ArtPiece savedArtPiece = artPieceService.saveArtPiece(artPiece);

        ArtPieceDTO savedArtPieceDTO = new ArtPieceDTO();

        savedArtPieceDTO.setName(savedArtPiece.getName());
        savedArtPieceDTO.setAddress(savedArtPiece.getAddress());
        savedArtPieceDTO.setDescription(savedArtPiece.getDescription());
        savedArtPieceDTO.setxCoordinate(savedArtPiece.getxCoordinate());
        savedArtPieceDTO.setyCoordinate(savedArtPiece.getyCoordinate());
        savedArtPieceDTO.setRetentionTime(savedArtPiece.getRetentionTime());
        savedArtPieceDTO.setYearCreated(savedArtPiece.getyearCreated());
        savedArtPieceDTO.setImage(savedArtPiece.getImage());
        savedArtPieceDTO.setArtisticMovementId(savedArtPiece.getArtisticMovement().getid());
        savedArtPieceDTO.setEpochId(savedArtPiece.getEpoch().getid());
        savedArtPieceDTO.setAuthorId(savedArtPiece.getAuthor().getid());

        return ResponseEntity.ok(savedArtPieceDTO);
    }

}
