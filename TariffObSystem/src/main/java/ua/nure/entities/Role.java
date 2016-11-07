package ua.nure.entities;

/**
 * Created by Александр Доротенко on 07.11.2016.
 */
public class Role {
    public Role(int id, String value) {
        this.id = id;
        this.value = value;
    }

    private int id;
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
