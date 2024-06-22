package Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.model.ArtisticMovement;

@Repository
public interface ArtisticMovementRepository extends JpaRepository<ArtisticMovement, Integer> {

}
