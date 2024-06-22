package Backend.dto;

import java.util.List;

import Backend.model.ArtPiece;

public class RouteDTO {

    private String routeName;

    private String routeDescription;

    private int routeDuration;

    private boolean routeVisibility;

    private int userId;

    private List<ArtPiece> artPieces;

    public RouteDTO() {
    }

    public String getRouteName() {
        return this.routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteDescription() {
        return this.routeDescription;
    }

    public void setRouteDescription(String routeDescription) {
        this.routeDescription = routeDescription;
    }

    public int getRouteDuration() {
        return this.routeDuration;
    }

    public void setRouteDuration(int routeDuration) {
        this.routeDuration = routeDuration;
    }

    public boolean getRouteVisibility() {
        return this.routeVisibility;
    }

    public void setRouteVisibility(boolean routeVisibility) {
        this.routeVisibility = routeVisibility;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<ArtPiece> getArtPieces() {
        return this.artPieces;
    }

    public void setArtPieces(List<ArtPiece> artPieces) {
        this.artPieces = artPieces;
    }
}
