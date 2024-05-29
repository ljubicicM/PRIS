package Backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class ArtisticMovement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String movementName;

	private String text1Movement;

	private String text2Movement;

	private String text3Movement;

	@JsonIgnore
	@OneToMany(mappedBy = "artisticMovement")
	private List<ArtPiece> artPieces;

	public ArtisticMovement() {
	}

	public ArtisticMovement(String movementName, String text1Movement, String text2Movement,
			String text3Movement) {
		this.movementName = movementName;
		this.text1Movement = text1Movement;
		this.text2Movement = text2Movement;
		this.text3Movement = text3Movement;
	}

	public int getid() {
		return this.id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getMovementName() {
		return this.movementName;
	}

	public void setMovementName(String movementName) {
		this.movementName = movementName;
	}

	public String getText1Movement() {
		return this.text1Movement;
	}

	public void setText1Movement(String text1Movement) {
		this.text1Movement = text1Movement;
	}

	public String getText2Movement() {
		return this.text2Movement;
	}

	public void setText2Movement(String text2Movement) {
		this.text2Movement = text2Movement;
	}

	public String getText3Movement() {
		return this.text3Movement;
	}

	public void setText3Movement(String text3Movement) {
		this.text3Movement = text3Movement;
	}

	public List<ArtPiece> getArtPieces() {
		return this.artPieces;
	}

	public void setArtPieces(List<ArtPiece> artPieces) {
		this.artPieces = artPieces;
	}
}