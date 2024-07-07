package Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Backend.dto.RouteDTO;
import Backend.model.Route;
import Backend.services.RouteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/route")
@CrossOrigin
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/saveRoute")
    public boolean postMethodName(@RequestBody RouteDTO dto) {
        return routeService.saveRoute(dto);
    }

    @GetMapping("/getGlobalRoutes")
    public List<Route> getGlobalRoutes() {
        return routeService.getGlobalRoutes();
    }

    @GetMapping("/getRoutesForUser")
    public List<Route> getRoutesForUser(@RequestParam(value = "userId") Integer userId) {
        return routeService.getRoutesForUser(userId);
    }

}