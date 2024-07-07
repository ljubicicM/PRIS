package Backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@OneToMany(mappedBy = "route")
	private List<ArtPieceRoute> artPieceRoutes;

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

	public List<ArtPieceRoute> getArtPieceRoutes() {
		return this.artPieceRoutes;
	}

	public void setArtPieceRoutes(List<ArtPieceRoute> artPieceRoutes) {
		this.artPieceRoutes = artPieceRoutes;
	}
}