package Backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Epoch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String epochName;

	private String text1Epoch;

	private String text2Epoch;

	private String text3Epoch;

	@ManyToOne
	@JoinColumn(name = "significant_event_id")
	private SignificantEvent significantEvent;

	@JsonIgnore
	@OneToMany(mappedBy = "epoch")
	private List<ArtPiece> artPieces;

	public Epoch() {
	}

	public Epoch(String epochName, String text1Epoch, String text2Epoch, String text3Epoch,
			SignificantEvent significantEvent) {
		this.epochName = epochName;
		this.text1Epoch = text1Epoch;
		this.text2Epoch = text2Epoch;
		this.text3Epoch = text3Epoch;
		this.significantEvent = significantEvent;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public List<ArtPiece> getArtPieces() {
		return this.artPieces;
	}

	public void setArtPieces(List<ArtPiece> artPieces) {
		this.artPieces = artPieces;
	}

}