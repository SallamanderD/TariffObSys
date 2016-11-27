package ua.nure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "telephones")
public class Telephone {
    @Id
    private int id;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    private int authorId;
    private String number;

    public List<TelephoneCommentary> getTelephoneCommentaries() {
        return telephoneCommentaries;
    }

    public void setTelephoneCommentaries(List<TelephoneCommentary> telephoneCommentaries) {
        this.telephoneCommentaries = telephoneCommentaries;
    }

    private List<TelephoneCommentary> telephoneCommentaries = new ArrayList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public Telephone(int id, String number, String text, int authorId) {
        this.id = id;
        this.number = number;
        this.text = text;
        this.authorId = authorId;
    }

    public Telephone() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
