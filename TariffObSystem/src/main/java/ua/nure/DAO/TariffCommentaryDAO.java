package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ua.nure.entities.TariffCommentary;

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
}
