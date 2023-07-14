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
                PokemonType pokemonType = new PokemonType();
                pokemonType.setId(rs.getLong("typeId"));
                pokemonType.setDescription(rs.getString("description"));
                pokemon.setPokemonType(PokemonType);
                pokemons.add(pokemon);
            }
            /*if(rs.next())
                Long id = rs.getLong(1);
            String querySaveImg = "INSERT INTO pokemin_img (file, person_id)"+"values(?,?);";
            ps = conn.prepareStatement(querySaveImg);
            ps.setBytes();
            ps.setLong(2, id);*/
        } catch (SQLException e) {
            Logger.getLogger(DaoPokemon.class.getName())
                    .log(Level.SEVERE, "ERROR findAll" + e.getMessage());
        } finally {
            close();
        }
        return pokemons;
    }

    public List<Pokemon> findOne(Long id) {
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM pokemons WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getLong("id"));
                pokemon.setName(rs.getString("name"));
                pokemon.setPs(rs.getDouble("ps"));
                pokemon.setHp(rs.getDouble("health"));
                pokemon.setPower(rs.getDouble("power"));
                pokemon.setWeight(rs.getDouble("weigth"));
                pokemon.setHeight(rs.getDouble("heigth"));
                pokemon.setAbilities(rs.getString("abilities"));
                pokemon.setPokemonType(rs.getString("type"));
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPokemon.class.getName())
                    .log(Level.SEVERE, "Error findOne", e);
        } finally {
            close();
        }
        return null;
    }

    public boolean update(Pokemon pokemon) {
        try {
            conn = new MySQLConnection().connect();
            String query = "UPDATE pokemons SET name = ?, type = ?, health = ?," +
                    "power = ?, weigth = ?, heigth = ? WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, pokemon.getName());
            ps.setString(2, pokemon.getPokemonType());
            ps.setDouble(3, pokemon.getHp());
            ps.setDouble(4, pokemon.getPower());
            ps.setDouble(5, pokemon.getWeight());
            ps.setDouble(6, pokemon.getHeight());
            ps.setLong(7, pokemon.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPokemon.class.getName())
                    .log(Level.SEVERE, "Error update", e);
            return false;
        } finally {
            close();
        }
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
