package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import ua.nure.entities.Role;

import java.util.List;

@Component
public class RoleDAO {
    @Autowired
    private MongoOperations mongoOperation;

    public void saveRole(Role role){
        mongoOperation.save(role);
    }

    public void removeRole(int id){
        mongoOperation.remove(new Query().
                addCriteria(Criteria.where("id").is(id)), Role.class);
    }

    public void updateRole(int id, Role role){
        Update update = new Update();
        update.set("value", role.getValue());
        mongoOperation.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)), update, Role.class);
    }

    public List<Role> findRole(int id){
        return mongoOperation.find(new Query().
                addCriteria(Criteria.where("id").is(id)), Role.class);
    }
}
