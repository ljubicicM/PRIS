package Backend.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@NamedQuery(name="SignificantEvent.findAll", query="SELECT z FROM SignificantEvent z")
public class SignificantEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSignificantEvent;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumDogadjaj;

	private String nazivDogadjaj;

	private String text1Dogadjaj;

	private String text2Dogadjaj;

	private String text3Dogadjaj;

	//bi-directional many-to-one association to Epoha
	@OneToMany(mappedBy="znacajnidogadjaj")
	private List<Epoha> epohas;

	public SignificantEvent() {
	}

	public int getIdSignificantEvent() {
		return this.idSignificantEvent;
	}

	public void setIdSignificantEvent(int idZnacajniDogadjaj) {
		this.idSignificantEvent = idZnacajniDogadjaj;
	}

	public Date getDatumDogadjaj() {
		return this.datumDogadjaj;
	}

	public void setDatumDogadjaj(Date datumDogadjaj) {
		this.datumDogadjaj = datumDogadjaj;
	}

	public String getNazivDogadjaj() {
		return this.nazivDogadjaj;
	}

	public void setNazivDogadjaj(String nazivDogadjaj) {
		this.nazivDogadjaj = nazivDogadjaj;
	}

	public String getText1Dogadjaj() {
		return this.text1Dogadjaj;
	}

	public void setText1Dogadjaj(String text1Dogadjaj) {
		this.text1Dogadjaj = text1Dogadjaj;
	}

	public String getText2Dogadjaj() {
		return this.text2Dogadjaj;
	}

	public void setText2Dogadjaj(String text2Dogadjaj) {
		this.text2Dogadjaj = text2Dogadjaj;
	}

	public String getText3Dogadjaj() {
		return this.text3Dogadjaj;
	}

	public void setText3Dogadjaj(String text3Dogadjaj) {
		this.text3Dogadjaj = text3Dogadjaj;
	}

	public List<Epoha> getEpohas() {
		return this.epohas;
	}

	public void setEpohas(List<Epoha> epohas) {
		this.epohas = epohas;
	}

	public Epoha addEpoha(Epoha epoha) {
		getEpohas().add(epoha);
		epoha.setZnacajnidogadjaj(this);

		return epoha;
	}

	public Epoha removeEpoha(Epoha epoha) {
		getEpohas().remove(epoha);
		epoha.setZnacajnidogadjaj(null);

		return epoha;
	}

}