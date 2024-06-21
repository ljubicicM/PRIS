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
    public boolean saveArtisticMovement(@RequestBody ArtisticMovementDTO artisticMovementDTO) {
        ArtisticMovement artisticMovement = new ArtisticMovement();

        artisticMovement.setMovementName(artisticMovementDTO.getMovementName());
        artisticMovement.setText1Movement(artisticMovementDTO.getText1Movement());
        artisticMovement.setText2Movement(artisticMovementDTO.getText2Movement());
        artisticMovement.setText3Movement(artisticMovementDTO.getText3Movement());

        ArtisticMovement savedArtisticMovement = artisticMovementService.saveArtisticMovement(artisticMovement);

        return savedArtisticMovement == null;
    }
}
