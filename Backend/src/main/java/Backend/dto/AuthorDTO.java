package Backend.dto;

import Backend.model.ArtPiece;

import java.util.List;

public class AuthorDTO {
    private String nameAuthor;
    private String surnameAuthor;
    private String text1Author;
    private String text2Author;
    private String text3Author;

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getSurnameAuthor() {
        return surnameAuthor;
    }

    public void setSurnameAuthor(String surnameAuthor) {
        this.surnameAuthor = surnameAuthor;
    }

    public String getText1Author() {
        return text1Author;
    }

    public void setText1Author(String text1Author) {
        this.text1Author = text1Author;
    }

    public String getText2Author() {
        return text2Author;
    }

    public void setText2Author(String text2Author) {
        this.text2Author = text2Author;
    }

    public String getText3Author() {
        return text3Author;
    }

    public void setText3Author(String text3Author) {
        this.text3Author = text3Author;
    }

}
