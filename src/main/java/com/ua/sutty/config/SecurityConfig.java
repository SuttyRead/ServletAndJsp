package com.ua.sutty.config;

import java.util.*;

public class SecurityConfig {

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<>();
    private static final List<String> url = new ArrayList<>();

    static {
        init();
    }

    private static void init() {

        // Конфигурация для роли "EMPLOYEE".
        List<String> pageForAdmin = new ArrayList<String>();

        pageForAdmin.add("/admin");
        pageForAdmin.add("/user");
        pageForAdmin.add("/home");
        pageForAdmin.add("/add");
        pageForAdmin.add("/edit");

        mapConfig.put(ROLE_USER, pageForAdmin);

        // Конфигурация для роли "MANAGER".
        List<String> pageForUser = new ArrayList<String>();

        pageForUser.add("/user");
        pageForUser.add("/home");

        mapConfig.put(ROLE_ADMIN, pageForUser);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}