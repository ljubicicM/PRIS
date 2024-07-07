package Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Backend.model.Epoch;

@Repository
public interface EpochRepository extends JpaRepository<Epoch, Integer> {

    @Query("SELECT e FROM Epoch e WHERE e.id = ?1")
    public Epoch findByID(Integer id);

}
