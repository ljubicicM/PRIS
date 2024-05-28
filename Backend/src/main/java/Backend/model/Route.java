package Backend.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@NamedQuery(name="Route.findAll", query="SELECT r FROM Route r")
public class Route implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoutePK id;

	private String routeName;

	private String routeDescription;

	private int routeDuration;

	private byte routeVisibility;

	public Route() {
	}

	public RoutePK getId() {
		return this.id;
	}

	public void setId(RoutePK id) {
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

	public byte getRouteVisibility() {
		return this.routeVisibility;
	}

	public void setRouteVisibility(byte routeVisibility) {
		this.routeVisibility = routeVisibility;
	}

}