package Backend.controllers;

import java.util.List;

import Backend.dto.ArtisticMovementDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ArtisticMovement saveArtisticMovement(@RequestBody ArtisticMovementDTO artisticMovementDTO) {

        ArtisticMovement savedArtisticMovement = artisticMovementService.saveArtisticMovement(artisticMovementDTO);

        return savedArtisticMovement;
    }
}
