package Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Backend.model.ArtPieceRoute;
import Backend.services.ArtPieceRouteService;

@RestController
@RequestMapping("/artPieceRoute")
@CrossOrigin
public class ArtPieceRouteController {

    @Autowired
    private ArtPieceRouteService artPieceRouteService;

    @GetMapping("/getArtPieceRoutes")
    public List<ArtPieceRoute> getArtPieceRoutes() {
        return artPieceRouteService.getAll();
    }

    @GetMapping("/getArtPiecesForRoute")
    public List<ArtPieceRoute> getArtPieceRoutesByRoute(@RequestParam(value = "routeId") Integer routeId) {
        return artPieceRouteService.getByRoute(routeId);
    }
}
