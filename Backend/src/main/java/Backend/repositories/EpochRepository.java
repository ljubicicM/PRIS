package Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.model.Epoch;

@Repository
public interface EpochRepository extends JpaRepository<Epoch, Integer> {

}
