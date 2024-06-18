package Backend.dto;

import Backend.model.ArtPiece;
import Backend.model.SignificantEvent;

import java.util.List;

public class EpochDTO {

    private int id;
    private String epochName;
    private String text1Epoch;
    private String text2Epoch;
    private String text3Epoch;
    private List<SignificantEvent> significantEvents;

    private List<ArtPiece> artPieces;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEpochName() {
        return epochName;
    }

    public void setEpochName(String epochName) {
        this.epochName = epochName;
    }

    public String getText1Epoch() {
        return text1Epoch;
    }

    public void setText1Epoch(String text1Epoch) {
        this.text1Epoch = text1Epoch;
    }

    public String getText2Epoch() {
        return text2Epoch;
    }

    public void setText2Epoch(String text2Epoch) {
        this.text2Epoch = text2Epoch;
    }

    public String getText3Epoch() {
        return text3Epoch;
    }

    public void setText3Epoch(String text3Epoch) {
        this.text3Epoch = text3Epoch;
    }

    public List<SignificantEvent> getSignificantEvents() {
        return significantEvents;
    }

    public void setSignificantEvents(List<SignificantEvent> significantEvents) {
        this.significantEvents = significantEvents;
    }

    public List<ArtPiece> getArtPieces() {
        return this.artPieces;
    }

    public void setArtPieces(List<ArtPiece> artPieces) {
        this.artPieces = artPieces;
    }
}
