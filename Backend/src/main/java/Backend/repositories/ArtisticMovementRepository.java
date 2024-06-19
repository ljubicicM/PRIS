package Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Backend.model.ArtisticMovement;

@Repository
public interface ArtisticMovementRepository extends JpaRepository<ArtisticMovement, Integer> {

    @Query("SELECT a FROM ArtisticMovement a WHERE a.id = ?1")
    public ArtisticMovement findByID(Integer id);

}
