package ua.nure.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.nure.util.Pair;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "tariffs")
public class Tariff {

    public Tariff(int id, String name, String shortDescription, String description, String time) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.time = time;
        this.rating = 0;
    }

    @Id
    private int id;
    private String shortDescription;
    private String time;
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
    private String name;
    private Operator operator;
    private List<Pair<Parameter, String>> parameters = new ArrayList<>();

    public List<TariffCommentary> getTariffCommentaries() {
        return tariffCommentaries;
    }

    public void setTariffCommentaries(List<TariffCommentary> tariffCommentaries) {
        this.tariffCommentaries = tariffCommentaries;
    }

    private List<TariffCommentary> tariffCommentaries = new ArrayList<>();
    public List<Pair<Parameter, String>> getParameters() {
        return parameters;
    }

    public void setParameters(List<Pair<Parameter, String>> parameters) {
        this.parameters = parameters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortDescription() { return shortDescription; }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

}
