package mx.edu.utez.firstapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    final String DBNAME = "PelisPlus",
    USER = "root",
    PASSWORD = "root",
    TIMEZONE = "America/Mexico_City",
    USESSL = "false",
    PUBLICKEY = "true",
    DOLAUTO = "true", HOST ="localhost";
    public Connection connect() {
        String dataSource = String.format(
                "jdbc:mysql://%s:3306/%s?user=%s&" + "password=%s&serverTimezone=%s&useSSL=%s&" + "allowPublicKeyRetrieval=%s&createDatabaseIfNotExist=%s",
                HOST, DBNAME, USER, PASSWORD, TIMEZONE, USESSL, PUBLICKEY, DOLAUTO
        );
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try{
            Connection conn = new MySQLConnection().connect();
            if (conn != null) {
                System.out.println("Conexión realizada");
                conn.close();
            } else {
                System.out.println("conexion fallida");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}