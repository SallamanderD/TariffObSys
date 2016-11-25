package ua.nure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "telephones")
public class Telephone {
    @Id
    private int id;
    private String number;

    public Telephone(int id, String number) {
        this.id = id;
        this.number = number;
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
