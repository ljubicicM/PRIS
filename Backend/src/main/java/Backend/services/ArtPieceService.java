package Backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.dto.ArtPieceDTO;
import Backend.model.ArtPiece;
import Backend.repositories.ArtPieceRepository;

@Service
public class ArtPieceService {
    @Autowired
    private ArtisticMovementService artisticMovementService;

    @Autowired
    private EpochService epochService;

    @Autowired
    private AuthorService authorService;

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

    public ArtPiece saveArtPiece(ArtPieceDTO artPieceDTO) {
        ArtPiece artPiece = new ArtPiece();
        artPiece.setName(artPieceDTO.getName());
        artPiece.setAddress(artPieceDTO.getAddress());
        artPiece.setDescription(artPieceDTO.getDescription());
        artPiece.setxCoordinate(artPieceDTO.getxCoordinate());
        artPiece.setyCoordinate(artPieceDTO.getyCoordinate());
        artPiece.setRetentionTime(artPieceDTO.getRetentionTime());
        artPiece.setyearCreated(artPieceDTO.getYearCreated());
        artPiece.setImage(artPieceDTO.getImage());
        artPiece.setArtisticMovement(artisticMovementService.findById(artPieceDTO.getArtisticMovementId()));
        artPiece.setEpoch(epochService.findById(artPieceDTO.getEpochId()));
        artPiece.setAuthor(authorService.findById(artPieceDTO.getAuthorId()));

        return artPieceRepository.save(artPiece);
    }

    public ArtPiece getById(Integer artPieceId) {
        return artPieceRepository.findByID(artPieceId);
    }

    public List<ArtPiece> getArtpiecesForRoute(Integer routeId) {
        return artPieceRepository.findByRouteId(routeId);
    }

}
