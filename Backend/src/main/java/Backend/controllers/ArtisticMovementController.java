package Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.model.ArtisticMovement;
import Backend.services.ArtisticMovementService;
import org.springframework.web.bind.annotation.GetMapping;

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

}
