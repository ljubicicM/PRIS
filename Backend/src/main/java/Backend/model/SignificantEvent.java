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
	private Date eventDate;

	private String eventName;

	private String text1Event;

	private String text2Event;

	private String text3Event;

	//bi-directional many-to-one association to Epoha
	@OneToMany(mappedBy="significantEvent")
	private List<Epoch> epochs;

	public SignificantEvent() {
	}

	public int getIdSignificantEvent() {
		return this.idSignificantEvent;
	}

	public void setIdSignificantEvent(int idSignificantEvent) {
		this.idSignificantEvent = idSignificantEvent;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getText1Event() {
		return this.text1Event;
	}

	public void setText1Event(String text1Event) {
		this.text1Event = text1Event;
	}

	public String getText2Event() {
		return this.text2Event;
	}

	public void setText2Event(String text2Event) {
		this.text2Event = text2Event;
	}

	public String getText3Event() {
		return this.text3Event;
	}

	public void setText3Event(String text3Event) {
		this.text3Event = text3Event;
	}

	public List<Epoch> getEpochs() {
		return this.epochs;
	}

	public void setEpochs(List<Epoch> epochs) {
		this.epochs = epochs;
	}

	public Epoch addEpoch(Epoch epoch) {
		getEpochs().add(epoch);
		epoch.setSignificantEvent(this);

		return epoch;
	}

	public Epoch removeEpoch(Epoch epoch) {
		getEpochs().remove(epoch);
		epoch.setSignificantEvent(null);

		return epoch;
	}

}