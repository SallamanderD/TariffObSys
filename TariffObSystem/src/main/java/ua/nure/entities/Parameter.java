package ua.nure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parameters")
public class Parameter {
    @Id
    private int id;
    private String name;

    public Parameter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Parameter() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
