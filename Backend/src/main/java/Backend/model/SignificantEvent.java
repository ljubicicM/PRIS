package Backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class SignificantEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date eventDate;

	private String eventName;

	private String text1Event;

	private String text2Event;

	private String text3Event;

	@ManyToOne
	private Epoch epoch;

	public SignificantEvent() {
	}

	public SignificantEvent(Date eventDate, String eventName, String text1Event, String text2Event, String text3Event) {
		this.eventDate = eventDate;
		this.eventName = eventName;
		this.text1Event = text1Event;
		this.text2Event = text2Event;
		this.text3Event = text3Event;
	}

	public int getid() {
		return this.id;
	}

	public void setid(int id) {
		this.id = id;
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

	public Epoch getEpoch() {
		return this.epoch;
	}

	public void setEpoch(Epoch epoch) {
		this.epoch = epoch;
	}

}