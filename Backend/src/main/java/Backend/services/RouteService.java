package Backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.dto.RouteDTO;
import Backend.model.Route;
import Backend.model.User;
import Backend.repositories.RouteRepository;
import Backend.repositories.UserRepository;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean saveRoute(RouteDTO dto) {
        Route route = new Route();
        route.setRouteName(dto.getRouteName());
        route.setRouteDescription(dto.getRouteDescription());
        route.setRouteDuration(dto.getRouteDuration());
        route.setRouteVisibility(dto.getRouteVisibility());
        route.setArtPieces(dto.getArtPieces());
        User user = userRepository.findById(dto.getUserId()).get();
        route.setUser(user);
        try {
            routeRepository.save(route);
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
