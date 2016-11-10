package ua.nure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tariffs")
public class Tariff {

    public Tariff(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Tariff(){

    }

    @Id
    private int id;
    private String description;
    private String name;
    private Operator operator;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
