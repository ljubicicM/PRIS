package Backend.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the epoha database table.
 * 
 */
@Entity
@NamedQuery(name="Epoha.findAll", query="SELECT e FROM Epoha e")
public class Epoha implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EpohaPK id;

	private String nazivEpoha;

	private String text1Epoha;

	private String text2Epoha;

	private String text3Epoha;

	//bi-directional many-to-one association to Znacajnidogadjaj
	@ManyToOne
	private SignificantEvent znacajnidogadjaj;

	public Epoha() {
	}

	public EpohaPK getId() {
		return this.id;
	}

	public void setId(EpohaPK id) {
		this.id = id;
	}

	public String getNazivEpoha() {
		return this.nazivEpoha;
	}

	public void setNazivEpoha(String nazivEpoha) {
		this.nazivEpoha = nazivEpoha;
	}

	public String getText1Epoha() {
		return this.text1Epoha;
	}

	public void setText1Epoha(String text1Epoha) {
		this.text1Epoha = text1Epoha;
	}

	public String getText2Epoha() {
		return this.text2Epoha;
	}

	public void setText2Epoha(String text2Epoha) {
		this.text2Epoha = text2Epoha;
	}

	public String getText3Epoha() {
		return this.text3Epoha;
	}

	public void setText3Epoha(String text3Epoha) {
		this.text3Epoha = text3Epoha;
	}

	public SignificantEvent getZnacajnidogadjaj() {
		return this.znacajnidogadjaj;
	}

	public void setZnacajnidogadjaj(SignificantEvent znacajnidogadjaj) {
		this.znacajnidogadjaj = znacajnidogadjaj;
	}

}