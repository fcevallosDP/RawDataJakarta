/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dp.util;

/**
 *
 * @author ZAMBRED
 */

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnector {

    private static DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:app/scraper");
        } catch (NamingException ex) {
            throw new RuntimeException("Error initializing DataSource via JNDI", ex);
        }
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException("Error getting database connection", ex);
        }
    }
}
