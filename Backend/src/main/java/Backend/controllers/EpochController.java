package Backend.controllers;

import java.util.List;

import Backend.dto.EpochDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Backend.model.Epoch;
import Backend.services.EpochService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PutMapping("updateEpochTexts")
    public boolean updateEpochTexts(@RequestParam(value = "id") int id, @RequestParam(value = "gen") int generality,
            @RequestParam(value = "text") String text) {
        return epochService.updateEpochTexts(id, generality, text);
    }
}
