package ua.nure.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import ua.nure.entities.*;
import ua.nure.util.*;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Autowired
    private TelephoneDAO telephoneDAO;
    @Autowired
    private TariffCommentaryDAO tariffCommentaryDAO;


    public void emul(){
        roleDAO.saveRole(new Role(1, "User"));
        roleDAO.saveRole(new Role(2, "Admin"));
        User usr = new User("Sallamander", DigestUtils.md5DigestAsHex("root".getBytes()), "Александр", "Доротенко", "Sallamanderdr@gmail.com");
        usr.setId(1);
        usr.setRole(roleDAO.findRole(1).get(0));
        userDAO.saveUser(usr);
        usr = new User("root", DigestUtils.md5DigestAsHex("root".getBytes()), "admin", "admin", "TariffObSys@gmail.com");
        usr.setId(2);
        usr.setRole(roleDAO.findRole(2).get(0));
        userDAO.saveUser(usr);
        Telephone telephone = new Telephone(1, "0664935720", "Cool man", 1);
        Telephone telephone1 = new Telephone(2, "0956766110", "Cool man too", 1);
        telephoneDAO.save(telephone);
        telephoneDAO.save(telephone1);
        parameterDAO.saveParameter(new Parameter(1, "Цена"));
        parameterDAO.saveParameter(new Parameter(2, "3G"));
        parameterDAO.saveParameter(new Parameter(3, "Звонки в сети, минут"));
        parameterDAO.saveParameter(new Parameter(4, "Звонки на других операторов, минут"));
        parameterDAO.saveParameter(new Parameter(5, "Безлимит соц.сети"));
        parameterDAO.saveParameter(new Parameter(6, "SMS"));
        //Generate roles

        //------------------------------------------------
        //Generate operators
        Operator op = new Operator("Vodafone", "Vodafone operator");
        op.setId(1);
        operatorDAO.saveOperator(op);

        Operator op2 = new Operator("Kyivstar", "Kyivstar operator");
        op2.setId(2);
        operatorDAO.saveOperator(op2);

        Operator op3 = new Operator("Lifecell", "Lifecell operator");
        op3.setId(3);
        operatorDAO.saveOperator(op3);
        //-------------------------------------------------
        //Generate tariffs
        Tariff tar1 = new Tariff(1, "Vodafone Red XS", "Отличный тариф от Vodafone, который включает все, что нужно среднестатистическому пользователю, от смс и звонков до быстрого 3g интернета.", "<h3>Как подключить?</h3> <br> Если вы уже клиент операторамобильной сети Vodafone, вы можете перейти на тариф Vodafone Red XS по номеру \"*250*350#\"<br><h3>«Зимова акція» в тарифі Vodafone Red XS</h3> Тільки цієї зими!<br>" +
                "<br>" +
                "Більше телефонуйте на інші мережі: Vodafone збільшує кількість хвилин у пакеті та знижує вартість дзвінків на інші мобільні оператори України понад пакет — до 25 копійок!\n" +
                "<br>" +
                "Акція діє з 18.11.2016 року до 28.02.2017 року.<br>" +
                "Протягом всієї усієї акції щомісяця Вам будуть надаватися додаткові обсяги хвилин.", new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        tar1.setOperator(operatorDAO.findOperator(1).get(0));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(1), "35"));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(2), "12000"));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(3), "Безлимит"));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(4), "225"));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(5), "Все"));
        tar1.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(6), "150"));
        TariffCommentary tc1 = new TariffCommentary(1, userDAO.findUser(1).get(0), "Best Tariff", 1);
        TariffCommentary tc2 = new TariffCommentary(2, userDAO.findUser(1).get(0), "Worst Tariff", 1);
        TariffCommentary tc3 = new TariffCommentary(3, userDAO.findUser(1).get(0), "I AM A TROLL BLO-BLO-BLO OLOLOOLOLOOLOLOOLOLOOL OLOOLOLOOLOLOOLOLOOLOLOOL OLOOLOLOOL OLOO LOLOO LOLOOLOLOOL OLOOLOLOOLOL OOLOLOO LOLOOLOLOO LOLOOLOLOOL OLOOLOLOOL OLOOLOLOOL OLOOLOLOOLOL OOLOLOOLOLOO LOLOOLOLOOLOL OOLOLOOLOLOOL OLOOLOLOOL OLOOLOLOOLOL OOLOL OOLOLOOLOLOO LOLOOLOL OOLOLOOLOLOO LOLOOLOLOOLOLOOLOLO OLOLOOLOLO OLOLOOLO LOOLOLOOLOLOOL OLOOLOLOOLOLO OLOLOOLOLOOL O LOOLO OOLOLOOLOLO OLOLOOLOLO OLOLOO LOLOOLOL OOLOL OOLOLOOL OLOOLOLOOL OLOOLOL OOLO LOOL OLOOLOLOOLO LOOLOLOOLOL OOLOLOO LOLOO LOLOOLOL OOLOLOOLO LOOLOLO HAHA", 1);
        tariffDAO.saveTariff(tar1);
        tariffCommentaryDAO.save(tc1);
        tariffCommentaryDAO.save(tc2);
        tariffCommentaryDAO.save(tc3);
        tariffDAO.addCommentaries(1, tariffCommentaryDAO.findById(1));
        tariffDAO.addCommentaries(1, tariffCommentaryDAO.findById(2));
        tariffDAO.addCommentaries(1, tariffCommentaryDAO.findById(3));
        operatorDAO.addTariff(1, tar1);


        Tariff tar2 = new Tariff(2, "Vodafone Red L", "Максимальный тариф от Vodafone, который вы можете оплатить только в день пользования", "<h3>Как подключить?</h3> <br> Если вы уже клиент операторамобильной сети Vodafone, вы можете перейти на тариф Vodafone Red XS по номеру \"*250*350#\" <br> «Зимова акція» в тарифі Vodafone Red S, M, L\n" +
                "<br>" +
                "Тільки цієї зими!\n" +
                "<br>" +
                "Більше телефонуйте на інші мережі та не обмежуйте себе в Інтернеті: Vodafone збільшує кількість хвилин і Гігабайт у пакеті, а також знижує вартість дзвінків на інші мобільні оператори України понад пакет — до 25 копійок!<br>" +
                "<br>" +
                "Акція діє з 18.11.2016 року до 28.02.2017 року.<br>" +
                "Протягом всієї усієї акції щомісяця Вам будуть надаватися додаткові обсяги хвилин і Гігабайт", new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        tar2.setOperator(operatorDAO.findOperator(1).get(0));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(1), "150"));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(2), "1500"));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(3), "Безлимит"));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(4), "50"));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(5), "VK, Facebook, OK"));
        tar2.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(6), "100"));
        operatorDAO.addTariff(1, tar2);
        tariffDAO.saveTariff(tar2);

        Tariff tar3 = new Tariff(3, "Kyivstar Online+", "<b>Kiyvstar Online+</b> один из лучших тарифов для вашего смартфона. В нем вы найдете все что вам нужно, включая безлимитную игру в PokemonGO", "<b>Как подключить тариф «Киевстар Онлайн+. Регион 2»</b><br>" +
                "Если вы желаете стать абонентом Киевстар, приобретите стартовый пакет с этим тарифным планом и активируйте его в соответствии с инструкциями на упаковке. Вы также можете активировать стартовый пакет с другим тарифным планом, а потом подать заявку на смену тарифного плана.<br>" +
                "Если вы уже наш абонент и хотите изменить свой тарифный план на «Киевстар Онлайн+. Регион 2», позвоните <kbd>477*1</kbd> или воспользуйтесь системой Мой Киевстар. <br> Проверяйте счет с помощью запроса <kbd>*111#</kbd><br><h3>Как активировать тариф?</h3>Рекомендуемая сумма пополнения счета для тарифного плана «Киевстар Онлайн+. Регион 2» – от 65 грн одним платежом любым способом, кроме перевода средств. Без этого пополнения тарифный план не считается активированным.", new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        tar3.setOperator(operatorDAO.findOperator(2).get(0));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(1), "65"));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(2), "4000"));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(3), "Безлимит"));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(4), "100"));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(5), "VK, Facebook, OK, Twitter, Viber, WatsApp"));
        tar3.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(6), "50"));
        operatorDAO.addTariff(2, tar3);
        tariffDAO.saveTariff(tar3);

        Tariff tar4 = new Tariff(4, "Lifecell Family", "Lifecell Family of Lifecell Operator", "Lifecell Family of Lifecell Operator", new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        tar4.setOperator(operatorDAO.findOperator(3).get(0));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(1), "25"));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(2), "500"));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(3), "100"));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(4), "20"));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(5), "-"));
        tar4.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(6), "30"));
        operatorDAO.addTariff(3, tar4);
        tariffDAO.saveTariff(tar4);
        //-------------------------------------------------
        //Generate users

    }

}
