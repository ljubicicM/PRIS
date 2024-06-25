package Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ArtPieceRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private ArtPiece artPiece;

    @ManyToOne
    private Route route;

    public ArtPieceRoute() {
        super();
    }

    public ArtPieceRoute(ArtPiece artPiece, Route route) {
        this.artPiece = artPiece;
        this.route = route;
    }

    public ArtPiece getArtPiece() {
        return artPiece;
    }

    public void setArtPiece(ArtPiece artPiece) {
        this.artPiece = artPiece;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

}
