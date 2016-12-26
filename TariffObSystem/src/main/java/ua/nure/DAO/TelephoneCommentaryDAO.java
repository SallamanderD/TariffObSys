package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import ua.nure.entities.TariffCommentary;
import ua.nure.entities.TelephoneCommentary;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelephoneCommentaryDAO {
    @Autowired
    private MongoOperations mongoOperations;

    public void save(TelephoneCommentary commentary){
        mongoOperations.save(commentary);
    }

    public void remove(int id){
        mongoOperations.remove(new Query().addCriteria(Criteria.where("id").is(id)), TelephoneCommentary.class);
    }

    public TelephoneCommentary findById(int id){
        return mongoOperations.findOne(new Query().addCriteria(Criteria.where("id").is(id)), TelephoneCommentary.class);
    }

    public List<TelephoneCommentary> findAll(){
        return mongoOperations.findAll(TelephoneCommentary.class);
    }

    public List<TelephoneCommentary> findByTelephoneId(int id){
        List<TelephoneCommentary> comment = mongoOperations.find(new Query().addCriteria(Criteria.where("telephoneId").is(id)), TelephoneCommentary.class);
        for(TelephoneCommentary t : comment){
            if(t.isDeleted() == true)
                comment.remove(t);
        }
        return comment;
    }

    public List<TelephoneCommentary> findUndeleted(){
        List<TelephoneCommentary> result = new ArrayList<>();
        for(TelephoneCommentary t : findAll())
            if(t.isDeleted() == false)
                result.add(t);
        return result;
    }

    public void delete(int id){
        Update update = new Update();
        update.set("deleted", true);
        mongoOperations.updateFirst(new Query().addCriteria(Criteria.where("id").is(id)), update, TelephoneCommentary.class);
    }
}
