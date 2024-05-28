package Backend.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the umetnickipravac database table.
 * 
 */
@Entity
@NamedQuery(name="ArtisticMovement.findAll", query="SELECT u FROM ArtisticMovement u")
public class ArtisticMovement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idArtisticMovement;

	private String movementName;

	private String text1Movement;

	private String text2Movement;

	private String text3Movement;

	public ArtisticMovement() {
	}

	public int getIdArtisticMovement() {
		return this.idArtisticMovement;
	}

	public void setIdArtisticMovement(int idUmetnickiPravac) {
		this.idArtisticMovement = idUmetnickiPravac;
	}

	public String getMovementName() {
		return this.movementName;
	}

	public void setMovementName(String imePravac) {
		this.movementName = imePravac;
	}

	public String getText1Movement() {
		return this.text1Movement;
	}

	public void setText1Movement(String text1Pravac) {
		this.text1Movement = text1Pravac;
	}

	public String getText2Movement() {
		return this.text2Movement;
	}

	public void setText2Movement(String text2Pravac) {
		this.text2Movement = text2Pravac;
	}

	public String getText3Movement() {
		return this.text3Movement;
	}

	public void setText3Movement(String text3Pravac) {
		this.text3Movement = text3Pravac;
	}

}