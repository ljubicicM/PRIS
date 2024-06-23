package Backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.model.ArtPieceRoute;
import Backend.repositories.ArtPieceRouteRepository;

@Service
public class ArtPieceRouteService {

    @Autowired
    private ArtPieceRouteRepository artPieceRouteRepository;

    public List<ArtPieceRoute> getAll() {
        return artPieceRouteRepository.findAll();
    }

    public List<ArtPieceRoute> getByRoute(Integer routeId) {
        return artPieceRouteRepository.findByRouteId(routeId);
    }
}
