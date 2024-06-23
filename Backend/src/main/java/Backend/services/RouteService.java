package Backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.dto.RouteDTO;
import Backend.model.ArtPiece;
import Backend.model.ArtPieceRoute;
import Backend.model.Route;
import Backend.model.User;
import Backend.repositories.ArtPieceRouteRepository;
import Backend.repositories.RouteRepository;
import Backend.repositories.UserRepository;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ArtPieceRouteRepository artPieceRouteRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean saveRoute(RouteDTO dto) {
        Route route = new Route();
        route.setRouteName(dto.getRouteName());
        route.setRouteDescription(dto.getRouteDescription());
        route.setRouteDuration(dto.getRouteDuration());
        route.setRouteVisibility(dto.getRouteVisibility());
        User user = userRepository.findById(dto.getUserId()).get();
        route.setUser(user);
        routeRepository.save(route);
        for (ArtPiece ap : dto.getArtPieces()) {
            artPieceRouteRepository.save(new ArtPieceRoute(ap, route));
        }
        try {

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Route> getGlobalRoutes() {
        return routeRepository.findGlobalRoutes();
    }

    public List<Route> getRoutesForUser(Integer userId) {
        return routeRepository.findRoutesForUser(userId);
    }

}
