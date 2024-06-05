package Backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.model.Epoch;
import Backend.repositories.EpochRepository;

@Service
public class EpochService {

    @Autowired
    private EpochRepository epochRepository;

    public List<Epoch> getAllEpochs() {
        return epochRepository.findAll();
    }

}
