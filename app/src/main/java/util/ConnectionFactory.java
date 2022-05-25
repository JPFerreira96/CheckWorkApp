package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * @author julio
 */
public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/checkworkapp";
    public static final String USER = "root";
    public static final String PASS = "";

    public static Connection getConnection() {
       // throw new UnsupportedOperationException("Not supported yet.");
       // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar conexão com o Banco de Dados", ex); 
        }
    }

    public static void closeConnection(Connection connection) {
        //throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            if (connection != null){
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados", ex);
        }
    }   
    
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        //throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados", ex);
        }    
    }
    
    public static void closeConnection(Connection connection,
            PreparedStatement statement, ResultSet resultSet) {
        //throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados", ex);
        }    
    }
}
