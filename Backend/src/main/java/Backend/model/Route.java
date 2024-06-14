package Backend.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String routeName;

	private String routeDescription;

	private int routeDuration;

	private boolean routeVisibility;

	@ManyToOne
	private User user;

	@ManyToMany(mappedBy = "routes")
	private List<ArtPiece> artPieces;

	public Route() {
	}

	public Route(String routeName, String routeDescription, int routeDuration, boolean routeVisibility) {
		this.routeName = routeName;
		this.routeDescription = routeDescription;
		this.routeDuration = routeDuration;
		this.routeVisibility = routeVisibility;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ArtPiece> getArtPieces() {
		return this.artPieces;
	}

	public void setArtPieces(List<ArtPiece> artPieces) {
		this.artPieces = artPieces;
	}
}