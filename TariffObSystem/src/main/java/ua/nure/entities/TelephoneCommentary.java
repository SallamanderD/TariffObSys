package ua.nure.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Document(collection = "telephoneCommentaries")
public class TelephoneCommentary {
    private int id;
    private User author;
    private String text;
    private Date createDate;
    private String date;

    public String getDate() {
        return DateFormat.getInstance().format(createDate);
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getTelephoneId() {
        return telephoneId;
    }

    public void setTelephoneId(int telephoneId) {
        this.telephoneId = telephoneId;
    }

    private int telephoneId;

    public TelephoneCommentary(int id, User author, String text, int telephoneId) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.telephoneId = telephoneId;
        createDate = Calendar.getInstance().getTime();
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
