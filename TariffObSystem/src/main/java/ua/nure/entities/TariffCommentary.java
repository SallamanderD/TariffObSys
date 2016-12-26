package ua.nure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;


@Document(collection = "tariffCommentaries")
public class TariffCommentary {
    @Id
    private int id;
    private User author;
    private String text;
    private int tariffId;
    private String date;
    private boolean deleted;

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDate() {
        return DateFormat.getInstance().format(createDate);
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    private Date createDate;

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
        createDate = Calendar.getInstance().getTime();
        this.deleted = false;

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
