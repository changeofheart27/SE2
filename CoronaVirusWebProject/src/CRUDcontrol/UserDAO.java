package CRUDcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBconnection.connect;
import model.Vietnam;
import model.World;

/**
 * This is a DAO (DATA ACCESS OBJECT) class which provides CRUD (CREATE - READ -
 * UPDATE - DELETE) database operations for the table user in the database
 */
public class UserDAO {
    public UserDAO() {
    }
    
    //VIETNAM TABLE
    
    public List<Vietnam> selectAllProvinces() {
        List<Vietnam> vietnams = new ArrayList<>();
        Connection connection = connect.getConnection();
        try {
            String SELECT_ALL_PROVINCES = "select * from se2db_vietnam";
            PreparedStatement stm = connection.prepareStatement(SELECT_ALL_PROVINCES);
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String province_name = result.getString("province_name");
                String current_infected = result.getString("current_infected");
                String current_death = result.getString("current_death");
                String current_recovered = result.getString("current_recovered");
                String date = result.getString("date");
                vietnams.add(new Vietnam(id, province_name, current_infected, current_death, current_recovered, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vietnams;
    }
    
    //WORLD TABLE
    
    public List<World> selectAllCountries() {
        List<World> countries  = new ArrayList<>();
        
        Connection connection = connect.getConnection();
        try {
            String SELECT_ALL_COUNTRIES = "select * from se2db_world";
            PreparedStatement stm = connection.prepareStatement(SELECT_ALL_COUNTRIES);
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String country_name = result.getString("country_name");
                String current_infected = result.getString("current_infected");
                String current_death = result.getString("current_death");
                String current_recovered = result.getString("current_recovered");
                String date = result.getString("date");
                countries.add(new World(id, country_name, current_infected, current_death, current_recovered, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }
    
}
