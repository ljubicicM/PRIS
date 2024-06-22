package Backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.dto.EpochDTO;
import Backend.model.Epoch;
import Backend.repositories.EpochRepository;

@Service
public class EpochService {

    @Autowired
    private EpochRepository epochRepository;

    public List<Epoch> getAllEpochs() {
        return epochRepository.findAll();
    }

    public Epoch saveEpoch(EpochDTO epochDTO) {
        Epoch epoch = new Epoch();
        epoch.setEpochName(epochDTO.getEpochName());
        epoch.setText1Epoch(epochDTO.getText1Epoch());
        epoch.setText2Epoch(epochDTO.getText2Epoch());
        epoch.setText3Epoch(epochDTO.getText3Epoch());
        return epochRepository.save(epoch);
    }

    public Epoch findById(Integer id) {
        return epochRepository.findById(id).get();
    }
}
