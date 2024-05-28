package Backend.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the epoha database table.
 * 
 */
@Embeddable
public class EpohaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idEpoha;

	@Column(insertable=false, updatable=false)
	private int znacajniDogadjaj_idZnacajniDogadjaj;

	public EpohaPK() {
	}
	public int getIdEpoha() {
		return this.idEpoha;
	}
	public void setIdEpoha(int idEpoha) {
		this.idEpoha = idEpoha;
	}
	public int getZnacajniDogadjaj_idZnacajniDogadjaj() {
		return this.znacajniDogadjaj_idZnacajniDogadjaj;
	}
	public void setZnacajniDogadjaj_idZnacajniDogadjaj(int znacajniDogadjaj_idZnacajniDogadjaj) {
		this.znacajniDogadjaj_idZnacajniDogadjaj = znacajniDogadjaj_idZnacajniDogadjaj;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EpohaPK)) {
			return false;
		}
		EpohaPK castOther = (EpohaPK)other;
		return 
			(this.idEpoha == castOther.idEpoha)
			&& (this.znacajniDogadjaj_idZnacajniDogadjaj == castOther.znacajniDogadjaj_idZnacajniDogadjaj);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEpoha;
		hash = hash * prime + this.znacajniDogadjaj_idZnacajniDogadjaj;
		
		return hash;
	}
}