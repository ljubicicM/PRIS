package Backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.model.Epoch;
import Backend.services.EpochService;

@RestController
@RequestMapping("/epoch")
@CrossOrigin
public class EpochController {
    @Autowired
    private EpochService epochService;

    @GetMapping("/getAll")
    private List<Epoch> epochs() {
        return epochService.getAllEpochs();
    }

}
