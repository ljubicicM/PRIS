package Backend.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class EpochPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idEpoch;

	@Column(insertable=false, updatable=false)
	private int significantEvent_idSignificantEvent;

	public EpochPK() {
	}
	public int getIdEpoch() {
		return this.idEpoch;
	}
	public void setIdEpoch(int idEpoch) {
		this.idEpoch = idEpoch;
	}
	public int getSignificantEvent_idSignificantEvent() {
		return this.significantEvent_idSignificantEvent;
	}
	public void setSignificantEvent_idSignificantEvent(int significantEvent_idSignificantEvent) {
		this.significantEvent_idSignificantEvent = significantEvent_idSignificantEvent;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EpochPK)) {
			return false;
		}
		EpochPK castOther = (EpochPK)other;
		return 
			(this.idEpoch == castOther.idEpoch)
			&& (this.significantEvent_idSignificantEvent == castOther.significantEvent_idSignificantEvent);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEpoch;
		hash = hash * prime + this.significantEvent_idSignificantEvent;
		
		return hash;
	}
}