package Backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.dto.RouteDTO;
import Backend.services.RouteService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/route")
@CrossOrigin
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/saveRoute")
    public boolean postMethodName(@RequestParam RouteDTO dto) {
        return routeService.saveRoute(dto);
    }

}