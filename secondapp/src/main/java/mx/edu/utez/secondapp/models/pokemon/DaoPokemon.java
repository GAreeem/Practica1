package mx.edu.utez.secondapp.models.pokemon;

import mx.edu.utez.secondapp.models.user.Person;
import mx.edu.utez.secondapp.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPokemon {
    //crear los metodos de CRUD
    //ALL, ONE, CREATE, UPDATE, ENABLE, DISABLED
    private Connection conn;
    private PreparedStatement ps;
    private CallableStatement cs;
    private ResultSet rs;

    public List<Pokemon> findAll() {
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon = null;
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT p.*," +
                    "       p2.id as personId," +
                    "       p2.name as personName," +
                    "       p2.surname," +
                    "       p2.lastname," +
                    "       t.id as typeId," +
                    "       t.description" +
                    " FROM pokemons p" +
                    "         INNER JOIN people p2 on p.people_id = p2.id" +
                    "         INNER JOIN types t on p.types_id = t.id;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                pokemon = new Pokemon();
                pokemon.setId(rs.getLong("id"));
                pokemon.setName(rs.getString("name"));
                pokemon.setHeight(rs.getDouble("height"));
                pokemon.setWeight(rs.getDouble("weight"));
                pokemon.setPs(rs.getDouble("ps"));
                pokemon.setHp(rs.getDouble("hp"));
                pokemon.setPower(rs.getDouble("power"));
                pokemon.setAbilities(rs.getString("abilities"));
                Person person = new Person();
                person.setId(rs.getLong("personId"));
                person.setName(rs.getString("personName"));
                person.setSurname(rs.getString("surname"));
                person.setLastname(rs.getString("lastname"));
                pokemon.setPerson(person);
                PokemonType type = new PokemonType();
                type.setId(rs.getLong("typeId"));
                type.setDescription(rs.getString("description"));
                pokemon.setType(type);
                pokemons.add(pokemon);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPokemon.class.getName())
                    .log(Level.SEVERE, "ERROR findAll" + e.getMessage());
        } finally {
            close();
        }
        return pokemons;
    }

    public void close() {
        try {
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (cs != null)
                cs.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {

        }
    }
}
