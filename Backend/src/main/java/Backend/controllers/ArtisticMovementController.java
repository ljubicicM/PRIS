package Backend.controllers;

import java.util.List;

import Backend.dto.ArtisticMovementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Backend.model.ArtisticMovement;
import Backend.services.ArtisticMovementService;

@RestController
@RequestMapping("/artisticMovement")
@CrossOrigin
public class ArtisticMovementController {

    @Autowired
    private ArtisticMovementService artisticMovementService;

    @GetMapping("/getAll")
    public List<ArtisticMovement> artisticMovements() {
        return artisticMovementService.getAllArtisticMovements();
    }

    @PostMapping("/saveArtisticMovement")
    public ResponseEntity<ArtisticMovementDTO> saveAuthor(@RequestBody ArtisticMovementDTO artisticMovementDTO) {
        ArtisticMovement artisticMovement = new ArtisticMovement();

        artisticMovement.setMovementName(artisticMovementDTO.getMovementName());
        artisticMovement.setid(artisticMovementDTO.getId());
        artisticMovement.setText1Movement(artisticMovementDTO.getText1Movement());
        artisticMovement.setText2Movement(artisticMovementDTO.getText2Movement());
        artisticMovement.setText3Movement(artisticMovementDTO.getText3Movement());
        artisticMovement.setArtPieces(artisticMovementDTO.getArtPieces());

        ArtisticMovement savedArtisticMovement = artisticMovementService.saveArtisticMovement(artisticMovement);

        ArtisticMovementDTO savedArtisticMovementDTO = new ArtisticMovementDTO();

        savedArtisticMovementDTO.setMovementName(savedArtisticMovement.getMovementName());
        savedArtisticMovementDTO.setId(savedArtisticMovement.getid());
        savedArtisticMovementDTO.setText1Movement(savedArtisticMovement.getText1Movement());
        savedArtisticMovementDTO.setText2Movement(savedArtisticMovement.getText2Movement());
        savedArtisticMovementDTO.setText3Movement(savedArtisticMovement.getText3Movement());
        savedArtisticMovementDTO.setArtPieces(savedArtisticMovement.getArtPieces());

        return ResponseEntity.ok(savedArtisticMovementDTO);
    }
}
