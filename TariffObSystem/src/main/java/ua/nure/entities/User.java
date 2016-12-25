package ua.nure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "users")
public class User {
    public User(){
        this.telephoneCommentarySent = 0;
        this.tariffCommentarySent = 0;
        this.feedbackSent = 0;
        this.telephonePageCreated = 0;
    }
    public User(String username, String password, String name, String surname, String mail){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.telephoneCommentarySent = 0;
        this.tariffCommentarySent = 0;
        this.feedbackSent = 0;
        this.telephonePageCreated = 0;
    }
    @Id
    private int id;
    private Role role;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String mail;

    public int getTelephoneCommentarySent() {
        return telephoneCommentarySent;
    }

    public void setTelephoneCommentarySent(int telephoneCommentarySent) {
        this.telephoneCommentarySent = telephoneCommentarySent;
    }

    public int getTariffCommentarySent() {
        return tariffCommentarySent;
    }

    public void setTariffCommentarySent(int tariffCommentarySent) {
        this.tariffCommentarySent = tariffCommentarySent;
    }

    public int getTelephonePageCreated() {
        return telephonePageCreated;
    }

    public void setTelephonePageCreated(int telephonePageCreated) {
        this.telephonePageCreated = telephonePageCreated;
    }

    public int getFeedbackSent() {
        return feedbackSent;
    }

    public void setFeedbackSent(int feedbackSent) {
        this.feedbackSent = feedbackSent;
    }

    private int telephoneCommentarySent;
    private int tariffCommentarySent;
    private int telephonePageCreated;
    private int feedbackSent;

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    private  String activated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
