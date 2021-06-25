package org.test.config;

import org.hibernate.cfg.Environment;

public class DBConfig {
    private static final String DB_HOST = System.getenv("DB_HOST");
    private static final String DB_PORT = System.getenv("DB_PORT");
    private static final String DB_NAME = System.getenv("DB_NAME");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    public static String getConnectionUrl(){
        return String.format("jdbc:postgresql:%s:%s/%s", DB_HOST,DB_PORT, DB_NAME);
    }
    public static String getUsername(){
        return DB_USER;
    }
    public static String getPassword(){
        return DB_PASSWORD;
    }
}
