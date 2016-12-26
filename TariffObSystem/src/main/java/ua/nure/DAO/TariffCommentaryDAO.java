package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import ua.nure.entities.TariffCommentary;

import java.util.ArrayList;
import java.util.List;

@Component
public class TariffCommentaryDAO {
    @Autowired
    private MongoOperations mongoOperations;

    public void save(TariffCommentary commentary){
        mongoOperations.save(commentary);
    }

    public void remove(int id){
        mongoOperations.remove(new Query().addCriteria(Criteria.where("id").is(id)), TariffCommentary.class);
    }

    public TariffCommentary findById(int id){
        return mongoOperations.findOne(new Query().addCriteria(Criteria.where("id").is(id)), TariffCommentary.class);
    }

    public List<TariffCommentary> findAll(){
        return mongoOperations.findAll(TariffCommentary.class);
    }

    public List<TariffCommentary> findByTariffId(int id){
        List<TariffCommentary> comment = mongoOperations.find(new Query().addCriteria(Criteria.where("tariffId").is(id)), TariffCommentary.class);
        for(TariffCommentary t : comment){
            if(t.isDeleted() == true)
                comment.remove(t);
        }
        return comment;
    }

    public List<TariffCommentary> findUndeleted(){
        List<TariffCommentary> result = new ArrayList<>();
        for(TariffCommentary t : findAll())
            if(t.isDeleted() == false)
                result.add(t);
        return result;
    }

    public void delete(int id){
        Update update = new Update();
        update.set("deleted", true);
        mongoOperations.updateFirst(new Query().addCriteria(Criteria.where("id").is(id)), update, TariffCommentary.class);
    }
}
