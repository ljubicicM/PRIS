package Backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.model.ArtPiece;
import Backend.repositories.ArtPieceRepository;

@Service
public class ArtPieceService {
    @Autowired
    private ArtPieceRepository artPieceRepository;

    public List<Integer> yearsCreated() {
        return artPieceRepository.yearsCreated();
    }

    public List<ArtPiece> getAll() {
        return artPieceRepository.findAll();
    }

    public List<ArtPiece> getByYear(Integer yearCreated) {
        return artPieceRepository.findByYearCreated(yearCreated);
    }

    public List<ArtPiece> getByAuthor(Integer authorId) {
        return artPieceRepository.findByAuthor(authorId);
    }

    public List<ArtPiece> getByEpoch(Integer epochId) {
        return artPieceRepository.findByEpoch(epochId);
    }

    public ArtPiece saveArtPiece(ArtPiece artPiece){ return artPieceRepository.save(artPiece);}
}
