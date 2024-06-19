package Backend.controllers;

import java.util.List;

import Backend.dto.EpochDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EpochDTO> saveAuthor(@RequestBody EpochDTO epochDTO) {
        Epoch epoch = new Epoch();
        epoch.setEpochName(epochDTO.getEpochName());
        epoch.setText1Epoch(epochDTO.getText1Epoch());
        epoch.setText2Epoch(epochDTO.getText2Epoch());
        epoch.setText3Epoch(epochDTO.getText3Epoch());

        Epoch savedEpoch = epochService.saveEpoch(epoch);

        EpochDTO savedEpochDTO = new EpochDTO();

        savedEpochDTO.setEpochName(savedEpoch.getEpochName());
        savedEpochDTO.setText1Epoch(savedEpoch.getText1Epoch());
        savedEpochDTO.setText2Epoch(savedEpoch.getText2Epoch());
        savedEpochDTO.setText3Epoch(savedEpoch.getText3Epoch());

        return ResponseEntity.ok(savedEpochDTO);
    }
}

