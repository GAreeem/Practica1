package mx.edu.utez.firstapp.models.user;
import mx.edu.utez.firstapp.models.crud.DaoRepository;
import mx.edu.utez.firstapp.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser implements DaoRepository<user>{
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    @Override
    public List<user> findAll() {
        List<user> users = new ArrayList<>();
        try{
            conn= new MySQLConnection().connect();
            String query ="SELECT * FROM users;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                user user = new user();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setLastname(rs.getString("lastname"));
                user.setBirthday(rs.getString("birthday"));
                user.setUsername(rs.getString("username"));
                user.setStatus(rs.getString("status"));
                users.add(user);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findAll "+ e.getMessage());
        }finally {
            close();
        }
        return users;
    }

    @Override
    public user findOne(Long id) {
        try{
            conn= new MySQLConnection().connect();
            String query ="SELECT * FROM users where id=?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            rs = pstm.executeQuery();
            user user = new user();
            if (rs.next()){
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setLastname(rs.getString("lastname"));
                user.setBirthday(rs.getString("birthday"));
                user.setUsername(rs.getString("username"));
                user.setStatus(rs.getString("status"));

            }
            return user;
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error findOne "+ e.getMessage());
        }finally {
            close();
        }
        return null;
    }

    @Override
    public boolean save(user object) {
        try{
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO users (name,surname,lastname,username,birthday,status)" + " VALUES (?, ?, ?, ?, ?, ?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,object.getName());
            pstm.setString(2,object.getSurname());
            pstm.setString(3, object.getLastname());
            pstm.setString(4, object.getUsername());
            pstm.setString(5,object.getBirthday());
            pstm.setString(6, object.getStatus());
            return pstm.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error save" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean update(user object) {
        try {
            conn = new MySQLConnection().connect();
            String query="update  users set name = ?, surname = ?, lastname = ?, username = ?, birthday = ?, status = ? where = id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,object.getName());
            pstm.setString(2,object.getSurname());
            pstm.setString(3, object.getLastname());
            pstm.setString(4,object.getUsername());
            pstm.setString(5, object.getBirthday());
            pstm.setString(6, object.getStatus());
            return pstm.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"Error update" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        try{
            conn = new MySQLConnection().connect();
            String query = "Delete users Where id=?;";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1,id);
            return pstm.executeUpdate()==1;
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName())
                    .log(Level.SEVERE, "Error delete " + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    public void close(){
        try{
            if (conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        }catch (SQLException e){

        }
    }
}