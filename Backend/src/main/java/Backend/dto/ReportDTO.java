package Backend.dto;

import java.util.List;

public class ReportDTO {
    public List<ArtPieceDTO> artPieces;
    public String routeString;
    public String hours;
    public String minutes;
    public String routeGenerality;

    public ReportDTO() {
    }

    public List<ArtPieceDTO> getArtPieces() {
        return this.artPieces;
    }

    public void setArtPieces(List<ArtPieceDTO> artPieces) {
        this.artPieces = artPieces;
    }

    public String getRouteString() {
        return this.routeString;
    }

    public void setRouteString(String routeString) {
        this.routeString = routeString;
    }

    public String getHours() {
        return this.hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getMinutes() {
        return this.minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getRouteGenerality() {
        return this.routeGenerality;
    }

    public void setRouteGenerality(String routeGenerality) {
        this.routeGenerality = routeGenerality;
    }

}
