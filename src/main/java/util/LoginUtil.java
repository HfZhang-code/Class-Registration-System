package util;

import java.util.concurrent.ConcurrentHashMap;

//store the user information who logged in
public class LoginUtil {

    private static final ConcurrentHashMap<String, String> sessionMap = new ConcurrentHashMap<>();

    private static final String CURRENT_USER = "currentUser";

    public static void setLoginUser(String stuId) {
        sessionMap.put(CURRENT_USER, stuId);
    }

    public static String getLoginUser() {
        return sessionMap.get(CURRENT_USER);
    }

    public static void removeLoginUser() {
        sessionMap.remove(CURRENT_USER);
    }
}
