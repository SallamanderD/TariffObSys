package ua.nure.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Александр Доротенко on 09.11.2016.
 */
public class Validator {
    private static final String MAIL_REGEXP = "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$";
    private static final String USERNAME_REGEXP = "^[a-zA-Z0-9_-]{7,20}$";
    private static final String NAME_REGEXP = "^[a-zA-Z]{2,20}$|[а-яА-Я]{2,20}$";
    private static final String TEL_REGEXP = "(066|099|095|067|098)[0-9]{7}";
    public static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(MAIL_REGEXP);
        Matcher m = pattern.matcher(email.toLowerCase());
        return m.matches();
    }

    public static boolean validateTelephone(String telephone){
        Pattern pattern = Pattern.compile(TEL_REGEXP);
        Matcher m = pattern.matcher(telephone.toLowerCase());
        return m.matches();
    }

    public static  boolean validatePass(String pass){
        if(pass.length() <= 7){
            return false;
        }
        return true;
    }

    public static boolean validateUsername(String username){
        Pattern pattern = Pattern.compile(USERNAME_REGEXP);
        Matcher m = pattern.matcher(username);
        return m.matches();
    }

    public static boolean validateName(String name){
        Pattern pattern = Pattern.compile(NAME_REGEXP);
        Matcher m = pattern.matcher(name);
        return m.matches();
    }

    public static String createPass(){
        String symbols = "ABCDEFGHIJKLMOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder randString = new StringBuilder();
        int count = 5;
        for(int i=0;i<count;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));

        return randString.toString();
    }

    public static String createLinkToEmail(String mail){
        if(mail.contains("@gmail.com") || mail.contains("@nure.ua")){
            return "http://mail.google.com";
        } else if(mail.contains("@mail.ru")){
            return "http://mail.ru";
        } else if (mail.contains("@yandex")){
            return "http://mail.yandex.ua";
        } else {
            return null;
        }
    }
}
