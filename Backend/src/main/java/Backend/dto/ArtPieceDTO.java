package Backend.dto;

import Backend.model.*;

import java.util.List;

public class ArtPieceDTO {
    private String name;
    private String address;
    private String description;
    private int xCoordinate;
    private int yCoordinate;
    private int retentionTime;
    private int yearCreated;
    private byte[] image;
    private int idArtisticMovement;
    private int idEpoch;
    private int idAuthor;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getRetentionTime() {
        return retentionTime;
    }

    public void setRetentionTime(int retentionTime) {
        this.retentionTime = retentionTime;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getArtisticMovementId() {
        return idArtisticMovement;
    }

    public void setArtisticMovementId(int idArtisticMovement) {
        this.idArtisticMovement = idArtisticMovement;
    }

    public int getEpochId() {
        return idEpoch;
    }

    public void setEpochId(int epochId) {
        this.idEpoch = epochId;
    }

    public int getAuthorId() {
        return idAuthor;
    }

    public void setAuthorId(int idAuthor) {
        this.idAuthor = idAuthor;
    }
}
