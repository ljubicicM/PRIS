package Backend.services;

import java.util.List;

import Backend.dto.ArtisticMovementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.model.ArtisticMovement;
import Backend.repositories.ArtisticMovementRepository;

@Service
public class ArtisticMovementService {

    @Autowired
    private ArtisticMovementRepository artisticMovementRepository;

    public List<ArtisticMovement> getAllArtisticMovements() {
        return artisticMovementRepository.findAll();
    }

    public ArtisticMovement saveArtisticMovement(ArtisticMovement artisticMovement){ return artisticMovementRepository.save(artisticMovement);}
}
