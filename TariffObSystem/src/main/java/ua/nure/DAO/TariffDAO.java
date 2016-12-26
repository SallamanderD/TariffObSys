package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import ua.nure.entities.Operator;
import ua.nure.entities.Tariff;
import ua.nure.entities.TariffCommentary;

import java.util.ArrayList;
import java.util.List;

@Component
public class TariffDAO {
    @Autowired
    private MongoOperations mongoOperation;

    public void saveTariff(Tariff tariff){
        mongoOperation.save(tariff);
    }

    public void removeTariff(int id){
        mongoOperation.remove(new Query().
                addCriteria(Criteria.where("id").is(id)), Tariff.class);
    }

    public void updateTariff(int id, Tariff tariff){
        Update update=new Update();
        update.set("description",tariff.getShortDescription());
        update.set("name",tariff.getName());
        mongoOperation.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)),update,Tariff.class);
    }

    public void updateOperator(int id, Operator operator){
        Update update=new Update();
        update.set("operator", operator);
        mongoOperation.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)),update,Tariff.class);
    }

    public List<Tariff> findTariff(int id){
        return mongoOperation.find(new Query().
                addCriteria(Criteria.where("id").is(id)), Tariff.class);
    }

    public List<Tariff> findUndeleted(){
        List<Tariff> result = new ArrayList<>();
        for(Tariff t : findAllTariff()){
            if(t.isDeleted() == false)
                result.add(t);
        }
        return result;
    }

    public void addCommentaries(int id, TariffCommentary commentary){
        Update update = new Update();
        update.addToSet("tariffCommentaries", commentary);
        mongoOperation.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)), update, Tariff.class);
    }

    public List<Tariff> findAllTariff(){
        return mongoOperation.findAll(Tariff.class);
    }
}
