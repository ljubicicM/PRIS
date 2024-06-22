package Backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtPieceDTO {
    private String name;
    private String address;
    private String description;
    private int xCoordinate;
    private int yCoordinate;
    private int retentionTime;
    private int yearCreated;
    private byte[] image;
    @JsonProperty("idArtisticMovement")
    private Integer idArtisticMovement;
    @JsonProperty("idEpoch")
    private Integer idEpoch;
    @JsonProperty("idAuthor")
    private Integer idAuthor;

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

    public Integer getArtisticMovementId() {
        return idArtisticMovement;
    }

    public void setArtisticMovementId(Integer idArtisticMovement) {
        this.idArtisticMovement = idArtisticMovement;
    }

    public Integer getEpochId() {
        return idEpoch;
    }

    public void setEpochId(Integer epochId) {
        this.idEpoch = epochId;
    }

    public Integer getAuthorId() {
        return idAuthor;
    }

    public void setAuthorId(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }
}
