package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ua.nure.entities.TariffCommentary;
import ua.nure.entities.TelephoneCommentary;

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
        return mongoOperations.find(new Query().addCriteria(Criteria.where("telephoneId").is(id)), TelephoneCommentary.class);
    }
}
