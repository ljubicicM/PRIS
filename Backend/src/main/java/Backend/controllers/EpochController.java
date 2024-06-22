package Backend.controllers;

import java.util.List;

import Backend.dto.EpochDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/saveEpoch")
    public Epoch saveEpoch(@RequestBody EpochDTO epochDTO) {

        Epoch savedEpoch = epochService.saveEpoch(epochDTO);

        return savedEpoch;
    }
}
