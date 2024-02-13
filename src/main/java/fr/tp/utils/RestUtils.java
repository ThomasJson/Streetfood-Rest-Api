package fr.tp.utils;

import org.mindrot.jbcrypt.BCrypt;

public class RestUtils {

    public static String encodePassword(String passwordClean){
        return BCrypt.hashpw(passwordClean,BCrypt.gensalt(9));
    }

}
