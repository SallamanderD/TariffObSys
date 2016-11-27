package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import ua.nure.entities.Tariff;
import ua.nure.entities.TariffCommentary;
import ua.nure.entities.Telephone;
import ua.nure.entities.TelephoneCommentary;

import java.util.List;

@Component
public class TelephoneDAO {
    @Autowired
    private MongoOperations mongoOperations;

    public void save(Telephone telephone){
        mongoOperations.save(telephone);
    }

    public void remove(int id){
        mongoOperations.remove(new Query().addCriteria(Criteria.where("id").is(id)), Telephone.class);
    }

    public List<Telephone> findAll(){
        return mongoOperations.findAll(Telephone.class);
    }

    public List<Telephone> findByAuthorId(int authorId){
        return mongoOperations.find(new Query().addCriteria(Criteria.where("authorId").is(authorId)), Telephone.class);
    }

    public Telephone findById(int id){
        return mongoOperations.findOne(new Query().addCriteria(Criteria.where("id").is(id)), Telephone.class);
    }

    public void addCommentaries(int id, TelephoneCommentary commentary){
        Update update = new Update();
        update.addToSet("telephoneCommentaries", commentary);
        mongoOperations.updateFirst(new Query().
                addCriteria(Criteria.where("id").is(id)), update, Telephone.class);
    }
}
