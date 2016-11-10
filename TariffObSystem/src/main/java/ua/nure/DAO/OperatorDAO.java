package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import ua.nure.entities.Operator;
import ua.nure.entities.Tariff;

import java.util.List;

@Component
public class OperatorDAO {
    @Autowired
    private MongoOperations mongoOperations;

    public void saveOperator(Operator operator){
        mongoOperations.save(operator);
    }

    public void removeOperator(int id){
        mongoOperations.remove(new Query().
                addCriteria(Criteria.where("id").is(id)), Operator.class);
    }

    public void updateOperator(int id, Operator operator){
        Update update = new Update();
        update.set("name", operator.getName());
        update.set("description", operator.getDescription());
        mongoOperations.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)), update, Operator.class);
    }

    public void updateTariffList(int id, Tariff tariff){
        Update update = new Update();
        update.addToSet("tariffs", tariff);
        mongoOperations.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)), update, Operator.class);
    }

    public List<Operator> findOperator(int id){
        return mongoOperations.find(new Query().
                addCriteria(Criteria.where("id").is(id)), Operator.class);
    }

    public List<Operator> findAllOperators(){
        return mongoOperations.findAll(Operator.class);
    }
}
