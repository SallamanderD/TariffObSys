package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import ua.nure.entities.Role;
import ua.nure.entities.User;

import java.util.List;


@Component
public class UserDAO {

    @Autowired
    private MongoOperations mongoOperation;

    private int size;

    public int getSize() {
        return this.findAllUser().size();
    }

    public void saveUser(User user){
        mongoOperation.save(user);
    }

    public void removeUser(int id){
        mongoOperation.remove(new Query().
                addCriteria(Criteria.where("id").is(id)), User.class);
    }

    public void updateUserData(int id, User user){
        Update update=new Update();
        update.set("username",user.getUsername());
        update.set("name",user.getName());
        update.set("surname",user.getSurname());
        mongoOperation.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)),update,User.class);
    }

    public void updateActivated(int id, User user){
        Update update=new Update();
        update.set("activated",user.getActivated());
        mongoOperation.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)),update,User.class);
    }

    public void updateUserPass(int id, User user){
        Update update=new Update();
        update.set("password",user.getPassword());
        mongoOperation.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)),update,User.class);
    }

    public void updateUserRole(int id, Role role){
        Update update=new Update();
        update.set("role", role);
        mongoOperation.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)),update,User.class);
    }

    public List<User> findUser(int id){
        return mongoOperation.find(new Query().
                addCriteria(Criteria.where("id").is(id)), User.class);
    }

    public User findByUsername(String username){
        return mongoOperation.findOne(new Query().addCriteria(Criteria.where("username").is(username)), User.class);
    }

    public User findByEmail(String mail){
        return mongoOperation.findOne(new Query().addCriteria(Criteria.where("mail").is(mail)), User.class);
    }

    public List<User> findAllUser(){
        return mongoOperation.findAll(User.class);
    }
}
