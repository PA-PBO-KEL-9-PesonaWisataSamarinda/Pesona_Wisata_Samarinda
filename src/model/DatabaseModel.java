package model;

import java.sql.*;

public class DatabaseModel {
    public static Connection connection = null;
    protected static Statement statement;
    protected static PreparedStatement preparedstatement;
    protected static ResultSet resulset;
    
    private final static String DB_HOST = "localhost";
    private final static String DB_NAME = "wisata_samarinda_terbaru";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "";
    
    public DatabaseModel(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("");
        } catch (ClassNotFoundException e){
            System.out.println("");
        }
    }
    
    public final static Connection connect(){
        try{
            String url = "jdbc:mysql://" + DB_HOST + "/" + DB_NAME;
            connection = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
            System.out.println("");
        } catch(SQLException e){
            System.out.println("");
        }
        return connection;
        
    }
    
    public final static void disconnect() {
        try {
            connection.close();
            System.out.println("");
        } catch (SQLException e) {
            System.out.println("");
        }
    } 
}
