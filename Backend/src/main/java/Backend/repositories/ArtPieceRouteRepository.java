package Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Backend.model.ArtPieceRoute;

public interface ArtPieceRouteRepository extends JpaRepository<ArtPieceRoute, Integer> {

    List<ArtPieceRoute> findByRouteId(Integer routeId);

}
