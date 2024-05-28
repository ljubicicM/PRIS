package Backend.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idAuthor;

	private String nameAuthor;

	private String surnameAuthor;

	private String text1Author;

	private String text2Author;

	private String text3Author;

	public Author() {
	}

	public int getIdAuthor() {
		return this.idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getNameAuthor() {
		return this.nameAuthor;
	}

	public void setNameAuthor(String imeAuthor) {
		this.nameAuthor = imeAuthor;
	}

	public String getSurnameAuthor() {
		return this.surnameAuthor;
	}

	public void setSurnameAuthor(String prezimeAuthor) {
		this.surnameAuthor = prezimeAuthor;
	}

	public String getText1Author() {
		return this.text1Author;
	}

	public void setText1Author(String text1Author) {
		this.text1Author = text1Author;
	}

	public String getText2Author() {
		return this.text2Author;
	}

	public void setText2Author(String text2Author) {
		this.text2Author = text2Author;
	}

	public String getText3Author() {
		return this.text3Author;
	}

	public void setText3Author(String text3Author) {
		this.text3Author = text3Author;
	}

}