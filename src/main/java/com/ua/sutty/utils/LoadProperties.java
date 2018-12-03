package com.ua.sutty.utils;

import org.h2.tools.RunScript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoadProperties {

    private final Logger LOGGER = LoggerFactory
            .getLogger(LoadProperties.class.getName());

    public void loadProperties(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("test");
        String url = resourceBundle.getString("jdbc.url");
        System.out.println(url);
        String user = resourceBundle.getString("jdbc.username");
        String password = resourceBundle.getString("jdbc.password");
        String schema = resourceBundle.getString("sql.schema");
        try {
            RunScript.execute(url, user, password, schema, Charset.forName("UTF-8"), false);
        } catch (SQLException e) {
            LOGGER.error("Error in time loadProperties");
            throw new RuntimeException(e);
        }
    }

}
