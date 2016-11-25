package ua.nure.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "telephoneCommentaries")
public class TelephoneCommentary {
    private int id;
    private User author;
    private String text;

    public TelephoneCommentary(int id, User author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }

    public TelephoneCommentary() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
