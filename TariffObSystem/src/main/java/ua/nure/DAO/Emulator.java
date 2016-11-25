package ua.nure.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import ua.nure.entities.*;
import ua.nure.util.*;

@Component
public class Emulator {

    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private OperatorDAO operatorDAO;
    @Autowired
    private TariffDAO tariffDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ParameterDAO parameterDAO;


    public void emul(){
        parameterDAO.saveParameter(new Parameter(1, "Цена"));
        parameterDAO.saveParameter(new Parameter(2, "3G"));
        parameterDAO.saveParameter(new Parameter(3, "Звонки в сети"));
        parameterDAO.saveParameter(new Parameter(4, "Звонки на других операторов, минут"));
        parameterDAO.saveParameter(new Parameter(5, "Безлимит соц.сети"));
        parameterDAO.saveParameter(new Parameter(6, "SMS"));
        //Generate roles
        roleDAO.saveRole(new Role(1, "User"));
        roleDAO.saveRole(new Role(2, "Admin"));
        //------------------------------------------------
        //Generate operators
        Operator op = new Operator("Vodafone", "Vodafone operator");
        op.setId(1);
        operatorDAO.saveOperator(op);

        Operator op2 = new Operator("KyivStar", "Kyivstar operator");
        op2.setId(2);
        operatorDAO.saveOperator(op2);

        Operator op3 = new Operator("Lifecell", "Lifecell operator");
        op3.setId(3);
        operatorDAO.saveOperator(op3);
        //-------------------------------------------------
        //Generate tariffs
        Tariff tar1 = new Tariff(1, "Vodafone 3D Red", "Vodafone 3D Red of Vodafone Operator", "Vodafone 3D Red of Vodafone Operator");
        tar1.setOperator(operatorDAO.findOperator(1).get(0));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(1), "35"));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(2), "1000"));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(3), "Безлимит"));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(4), "100"));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(5), "VK, Facebook"));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(6), "35"));
        operatorDAO.updateTariffList(1, tar1);
        tariffDAO.saveTariff(tar1);

        Tariff tar2 = new Tariff(2, "Vodafone Super+", "Vodafone Super+ of Vodafone Operator", "Vodafone Super+ of Vodafone Operator");
        tar2.setOperator(operatorDAO.findOperator(1).get(0));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(1), "45"));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(2), "1500"));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(3), "Безлимит"));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(4), "50"));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(5), "VK, Facebook, OK"));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(6), "100"));
        operatorDAO.updateTariffList(1, tar2);
        tariffDAO.saveTariff(tar2);

        Tariff tar3 = new Tariff(3, "KyivStar 3g+", "KyivStar 3g+ of KyivStar Operator", "KyivStar 3g+ of KyivStar Operator");
        tar3.setOperator(operatorDAO.findOperator(2).get(0));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(1), "50"));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(2), "Безлимит"));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(3), "Безлимит"));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(4), "50"));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(5), "Безлимит"));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(6), "100"));
        operatorDAO.updateTariffList(2, tar3);
        tariffDAO.saveTariff(tar3);

        Tariff tar4 = new Tariff(4, "Lifecell Family", "Lifecell Family of Lifecell Operator", "Lifecell Family of Lifecell Operator");
        tar4.setOperator(operatorDAO.findOperator(3).get(0));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(1), "25"));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(2), "500"));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(3), "100"));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(4), "20"));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(5), "-"));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(6), "30"));
        operatorDAO.updateTariffList(3, tar4);
        tariffDAO.saveTariff(tar4);
        //-------------------------------------------------
        //Generate users
        User usr = new User("Sallamander", DigestUtils.md5DigestAsHex("root".getBytes()), "Александр", "Доротенко", "Sallamanderdr@gmail.com");
        usr.setRole(roleDAO.findRole(1).get(0));
        userDAO.saveUser(usr);
    }

}
