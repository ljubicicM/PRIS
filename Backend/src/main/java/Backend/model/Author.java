package Backend.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nameAuthor;

	private String surnameAuthor;

	private String text1Author;

	private String text2Author;

	private String text3Author;

	@JsonIgnore
	@OneToMany(mappedBy = "author")
	private List<ArtPiece> artPieces;

	public Author() {
	}

	public Author(String nameAuthor, String surnameAuthor, String text1Author, String text2Author,
			String text3Author) {
		this.nameAuthor = nameAuthor;
		this.surnameAuthor = surnameAuthor;
		this.text1Author = text1Author;
		this.text2Author = text2Author;
		this.text3Author = text3Author;
	}

	public int getid() {
		return this.id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getNameAuthor() {
		return this.nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	public String getSurnameAuthor() {
		return this.surnameAuthor;
	}

	public void setSurnameAuthor(String surnameAuthor) {
		this.surnameAuthor = surnameAuthor;
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

	public List<ArtPiece> getArtPieces() {
		return this.artPieces;
	}

	public void setArtPieces(List<ArtPiece> artPieces) {
		this.artPieces = artPieces;
	}

}