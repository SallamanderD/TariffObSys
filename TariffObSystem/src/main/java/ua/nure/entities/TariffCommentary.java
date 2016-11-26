package ua.nure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "tariffCommentaries")
public class TariffCommentary {
    @Id
    private int id;
    private User author;
    private String text;
    private int tariffId;

    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public TariffCommentary(int id, User author, String text, int tariffId) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.tariffId = tariffId;
    }

    public TariffCommentary() {

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
