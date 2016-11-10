package ua.nure.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.entities.Operator;
import ua.nure.entities.Role;
import ua.nure.entities.Tariff;
import ua.nure.entities.User;

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

    public void emul(){
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
        Tariff tar1 = new Tariff(1, "Vodafone 3D Red", "Vodafone 3D Red of Vodafone Operator");
        tar1.setOperator(operatorDAO.findOperator(1).get(0));
        operatorDAO.updateTariffList(1, tar1);
        tariffDAO.saveTariff(tar1);

        Tariff tar2 = new Tariff(2, "Vodafone Super+", "Vodafone Super+ of Vodafone Operator");
        tar2.setOperator(operatorDAO.findOperator(1).get(0));
        operatorDAO.updateTariffList(1, tar2);
        tariffDAO.saveTariff(tar2);

        Tariff tar3 = new Tariff(3, "KyivStar 3g+", "KyivStar 3g+ of KyivStar Operator");
        tar3.setOperator(operatorDAO.findOperator(2).get(0));
        operatorDAO.updateTariffList(2, tar3);
        tariffDAO.saveTariff(tar3);

        Tariff tar4 = new Tariff(4, "Lifecell Family", "Lifecell Family of Lifecell Operator");
        tar4.setOperator(operatorDAO.findOperator(3).get(0));
        operatorDAO.updateTariffList(3, tar4);
        tariffDAO.saveTariff(tar4);
        //-------------------------------------------------
        //Generate users
        User usr = new User("Sallamander", "root", "Александр", "Доротенко", "Sallamanderdr@gmail.com");
        usr.setRole(roleDAO.findRole(1).get(0));
        userDAO.saveUser(usr);
    }

}