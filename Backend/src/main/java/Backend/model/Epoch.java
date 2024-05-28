package Backend.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@NamedQuery(name="Epoch.findAll", query="SELECT e FROM Epoch e")
public class Epoch implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EpochPK id;

	private String epochName;

	private String text1Epoch;

	private String text2Epoch;

	private String text3Epoch;

	@ManyToOne
	@JoinColumn(name = "significant_event_id")
	private SignificantEvent significantEvent;

	public Epoch() {
	}

	public EpochPK getId() {
		return this.id;
	}

	public void setId(EpochPK id) {
		this.id = id;
	}

	public String getEpochName() {
		return this.epochName;
	}

	public void setEpochName(String epochName) {
		this.epochName = epochName;
	}

	public String getText1Epoch() {
		return this.text1Epoch;
	}

	public void setText1Epoch(String text1Epoch) {
		this.text1Epoch = text1Epoch;
	}

	public String getText2Epoch() {
		return this.text2Epoch;
	}

	public void setText2Epoch(String text2Epoch) {
		this.text2Epoch = text2Epoch;
	}

	public String getText3Epoch() {
		return this.text3Epoch;
	}

	public void setText3Epoch(String text3Epoch) {
		this.text3Epoch = text3Epoch;
	}

	public SignificantEvent getSignificantEvent() {
		return this.significantEvent;
	}

	public void setSignificantEvent(SignificantEvent significantEvent) {
		this.significantEvent = significantEvent;
	}

}