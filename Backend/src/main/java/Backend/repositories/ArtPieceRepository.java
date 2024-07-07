package Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Backend.model.ArtPiece;

@Repository
public interface ArtPieceRepository extends JpaRepository<ArtPiece, Integer> {
    @Query("SELECT DISTINCT a.yearCreated FROM ArtPiece a")
    public List<Integer> yearsCreated();

    @Query("SELECT a FROM ArtPiece a WHERE a.yearCreated = ?1")
    public List<ArtPiece> findByYearCreated(Integer yearCreated);

    @Query("SELECT a FROM ArtPiece a WHERE a.author.id = ?1")
    public List<ArtPiece> findByAuthor(Integer authorId);

    @Query("SELECT a FROM ArtPiece a WHERE a.epoch.id = ?1")
    public List<ArtPiece> findByEpoch(Integer epochId);

    @Query("SELECT a FROM ArtPiece a WHERE a.id = ?1")
    public ArtPiece findByID(Integer id);

    @Query("SELECT a FROM ArtPiece a INNER JOIN ArtPieceRoute apr ON a.id = apr.artPiece.id WHERE apr.route.id = :routeId")
    public List<ArtPiece> findByRouteId(@Param("routeId") Integer routeId);

}
