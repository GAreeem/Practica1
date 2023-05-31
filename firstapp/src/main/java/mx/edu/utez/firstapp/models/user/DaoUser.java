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
        return null;
    }

    @Override
    public boolean save(user object) {
        return false;
    }

    @Override
    public boolean update(user object) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
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