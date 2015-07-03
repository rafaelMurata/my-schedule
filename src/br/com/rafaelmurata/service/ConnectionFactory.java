package br.com.rafaelmurata.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException{  
        String url = "jdbc:mysql://127.0.0.1/javaweb";  
        String login = "root";  
        String senha = "";  
          
        try{  
              
            Class.forName("com.mysql.jdbc.Driver");  
            return DriverManager.getConnection(url, login, senha);    
        }catch(ClassNotFoundException e){  
            throw new SQLException(e.getMessage());  
        }  
          
    }  }
