package ua.nure.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ua.nure.entities.Parameter;

@Component
public class ParameterDAO {
    @Autowired
    private MongoOperations mongoOperations;

    public void saveParameter(Parameter parameter){
        mongoOperations.save(parameter);
    }

    public void removeParameter(int id){
        mongoOperations.remove(new Query().addCriteria(Criteria.where("id").is(id)), Parameter.class);
    }

    public Parameter findFirst(int id){
        return mongoOperations.findOne(new Query().addCriteria(Criteria.where("id").is(id)), Parameter.class);
    }

}
