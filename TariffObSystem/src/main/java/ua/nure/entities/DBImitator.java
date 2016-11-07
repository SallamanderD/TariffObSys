package ua.nure.entities;

import java.util.List;

/**
 * Created by Александр Доротенко on 07.11.2016.
 */
public class DBImitator {

    public DBImitator(){}
    public DBImitator(List<Role> roles, List<Operator> operators, List<User> users, List<Tariff> tariffs) {
        this.roles = roles;
        this.operators = operators;
        this.users = users;
        this.tariffs = tariffs;
    }

    public List<Role> roles;
    public List<Operator> operators;
    public List<User> users;
    public List<Tariff> tariffs;
}
