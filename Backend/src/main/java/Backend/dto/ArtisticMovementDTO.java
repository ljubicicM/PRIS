package Backend.dto;

import Backend.model.ArtPiece;

import java.util.List;

public class ArtisticMovementDTO {

    private int id;
    private String movementName;
    private String text1Movement;
    private String text2Movement;
    private String text3Movement;
    private List<ArtPiece> artPieces;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovementName() {
        return movementName;
    }

    public void setMovementName(String movementName) {
        this.movementName = movementName;
    }

    public String getText1Movement() {
        return text1Movement;
    }

    public void setText1Movement(String text1Movement) {
        this.text1Movement = text1Movement;
    }

    public String getText2Movement() {
        return text2Movement;
    }

    public void setText2Movement(String text2Movement) {
        this.text2Movement = text2Movement;
    }

    public String getText3Movement() {
        return text3Movement;
    }

    public void setText3Movement(String text3Movement) {
        this.text3Movement = text3Movement;
    }

    public List<ArtPiece> getArtPieces() {
        return artPieces;
    }

    public void setArtPieces(List<ArtPiece> artPieces) {
        this.artPieces = artPieces;
    }
}
