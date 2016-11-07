package ua.nure.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Александр Доротенко on 07.11.2016.
 */
public class EmulateDB {
    public static DBImitator init(){
        DBImitator db = new DBImitator();
        /* Инициализация ролей пользователей */
        List<Role> tempRoles = new ArrayList<Role>();
        Role admin = new Role(1, "Admin");
        Role user = new Role(2, "User");
        tempRoles = Arrays.asList(admin, user);
        db.roles = tempRoles;
        /* END */
        /* Инициализация начальных пользователей */
        List<User> tempUsers = new ArrayList<User>();
        User firstUser = new User("Sallamander", "root", "Aleksandr", "Dorotenko");
        firstUser.role = db.roles.get(0);
        firstUser.setId(1);
        tempUsers.add(firstUser);
        db.users = tempUsers;
        /* END */
        /* Инициализация начальных операторов мобильной сети */
        List<Operator> tempOperators = new ArrayList<>();
        Operator vodafone = new Operator("Vodafone","Description of Vodafon operator");
        vodafone.setId(1);
        Operator life = new Operator("Lifecell","Description of Lifecell operator");
        life.setId(2);
        Operator kyivstar = new Operator("Kyivstar","Description of Kyivstar operator");
        kyivstar.setId(3);
        tempOperators = Arrays.asList(vodafone, life, kyivstar);
        db.operators = tempOperators;
        /* END */
        /* Инициализация начальных тарифов мобильной сети */
        List<Tariff> tempTariffs = new ArrayList<>();
        Tariff first = new Tariff(1, "Vodafont 3D Red", "Description of Vodafone 3D Red");
        first.operator = db.operators.get(0);
        Tariff second = new Tariff(2, "Vodafone Super", "Description of Vodafone Super");
        second.operator = db.operators.get(0);
        Tariff third = new Tariff(3, "Lifecell Smartphone 3g+", "Description of Lifecell Smartphone 3g+");
        third.operator = db.operators.get(1);
        Tariff fourth = new Tariff(4, "Kyivstar Speak+", "Description of Kyivstar Speak+");
        fourth.operator = db.operators.get(2);
        tempTariffs = Arrays.asList(first, second, third, fourth);
        db.tariffs = tempTariffs;
        return db;
    }
}
