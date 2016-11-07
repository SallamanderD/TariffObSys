package ua.nure.entities;

/**
 * Created by Александр Доротенко on 07.11.2016.
 */
public class User {
    public User(String username, String password, String name, String surname){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
    private int id;
    private String username;
    private String password;

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

    private String name;
    private String surname;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Role role;
}
