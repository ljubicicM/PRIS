package Backend.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the ruta database table.
 * 
 */
@Embeddable
public class RoutePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idRoute;

	private int user_idUser;

	public RoutePK() {
	}
	public int getIdRoute() {
		return this.idRoute;
	}
	public void setIdRoute(int idRuta) {
		this.idRoute = idRuta;
	}
	public int getUser_idUser() {
		return this.user_idUser;
	}
	public void setUser_idUser(int user_idUser) {
		this.user_idUser = user_idUser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RoutePK)) {
			return false;
		}
		RoutePK castOther = (RoutePK)other;
		return 
			(this.idRoute == castOther.idRoute)
			&& (this.user_idUser == castOther.user_idUser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRoute;
		hash = hash * prime + this.user_idUser;
		
		return hash;
	}
}