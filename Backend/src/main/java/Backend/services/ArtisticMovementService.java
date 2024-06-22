package Backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.dto.ArtisticMovementDTO;
import Backend.model.ArtisticMovement;
import Backend.repositories.ArtisticMovementRepository;

@Service
public class ArtisticMovementService {

    @Autowired
    private ArtisticMovementRepository artisticMovementRepository;

    public List<ArtisticMovement> getAllArtisticMovements() {
        return artisticMovementRepository.findAll();
    }

    public ArtisticMovement saveArtisticMovement(ArtisticMovementDTO artisticMovementDTO) {
        ArtisticMovement artisticMovement = new ArtisticMovement();

        artisticMovement.setMovementName(artisticMovementDTO.getMovementName());
        artisticMovement.setText1Movement(artisticMovementDTO.getText1Movement());
        artisticMovement.setText2Movement(artisticMovementDTO.getText2Movement());
        artisticMovement.setText3Movement(artisticMovementDTO.getText3Movement());

        return artisticMovementRepository.save(artisticMovement);
    }

    public ArtisticMovement findById(Integer artisticMovementId) {
        return artisticMovementRepository.findById(artisticMovementId).get();
    }
}
