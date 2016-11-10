package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import ua.nure.entities.Tariff;
import ua.nure.entities.User;

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
        update.set("description",tariff.getDescription());
        update.set("name",tariff.getName());
        mongoOperation.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)),update,Tariff.class);
    }

    public List<Tariff> findTariff(int id){
        return mongoOperation.find(new Query().
                addCriteria(Criteria.where("id").is(id)), Tariff.class);
    }

    public List<Tariff> findAllTariff(){
        return mongoOperation.findAll(Tariff.class);
    }
}
