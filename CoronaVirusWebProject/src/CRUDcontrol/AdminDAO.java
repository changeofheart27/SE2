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
public class AdminDAO {
    public AdminDAO() {
    }
    
    //VIETNAM TABLE
    
    public List<Vietnam> selectAllProvinces() {
        List<Vietnam> vietnams = new ArrayList<>();
        
        //Step 1: Establishing a Connection
        Connection connection = connect.getConnection();
        try {
            //Step 2: Create a statement using connection object
            String SELECT_ALL_PROVINCES = "select * from se2db_vietnam";
            PreparedStatement stm = connection.prepareStatement(SELECT_ALL_PROVINCES);
            
            //Step 3: Execute the query or update query
            ResultSet result = stm.executeQuery();
            
            //Step 4: Process the ResultSet object
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
    
    //selectProvince() method to select particular Province by ID (use in UPDATE function)
    public Vietnam selectProvince(int id) {
        Vietnam vietnam = null;
        
        Connection connection = connect.getConnection();
        try {
            
            String SELECT_PROVINCE = "select * from se2db_vietnam where id = ?";
            PreparedStatement stm = connection.prepareStatement(SELECT_PROVINCE);
            stm.setInt(1, id);
            
            ResultSet result = stm.executeQuery();
            
            if (result.next()) {
                String province_name = result.getString("province_name");
                String current_infected = result.getString("current_infected");
                String current_death = result.getString("current_death");
                String current_recovered = result.getString("current_recovered");
                String date = result.getString("date");
                vietnam = new Vietnam(id, province_name, current_infected, current_death, current_recovered, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vietnam;
    }
    
    //insertProvince() method to add a new record to vietnam table
    public void insertProvince(Vietnam vietnam) throws SQLException {
        Connection connection = connect.getConnection();
        try {
            String INSERT_PROVINCE = 
            		"insert into se2db_vietnam (id, province_name, current_infected, current_death, current_recovered, date) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(INSERT_PROVINCE);
            stm.setInt(1, vietnam.getId());
            stm.setString(2, vietnam.getProvince());
            stm.setString(3, vietnam.getInfected());
            stm.setString(4, vietnam.getDeath());
            stm.setString(5, vietnam.getRecover());
            stm.setString(6, vietnam.getDay());

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //updateProvince() method to update record to table vietnam
    public boolean updateProvince(Vietnam vietnam) throws SQLException {
        Connection connection = connect.getConnection();
        boolean rowUpdated = false;
        try {
            String UPDATE_PROVINCE = 
            		"update se2db_vietnam set province_name = ?, current_infected = ?, current_death = ?, current_recovered = ?, date = ? where id = ?";
            PreparedStatement stm = connection.prepareStatement(UPDATE_PROVINCE);
            stm.setString(1, vietnam.getProvince());
            stm.setString(2, vietnam.getInfected());
            stm.setString(3, vietnam.getDeath());
            stm.setString(4, vietnam.getRecover());
            stm.setString(5, vietnam.getDay());
            stm.setInt(6, vietnam.getId());
            
            rowUpdated = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    //deleteProvince() method to delete record to table vietnam
    public boolean deleteProvince(int id) throws SQLException {
        Connection connection = connect.getConnection();
        boolean rowDeleted = false;
        try {
            String DELETE_PROVINCE = "delete from se2db_vietnam where id = ?";
            PreparedStatement stm = connection.prepareStatement(DELETE_PROVINCE);
            stm.setInt(1, id);
            
            rowDeleted = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
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
    
    //selectCountry() method to select particular Country by ID (use in UPDATE function)
    public World selectCountry(int id) {
        World world = null;
        
        Connection connection = connect.getConnection();
        try {
            
            String SELECT_COUNTRY = "select * from se2db_world where id = ?";
            PreparedStatement stm = connection.prepareStatement(SELECT_COUNTRY);
            stm.setInt(1, id);
            
            ResultSet result = stm.executeQuery();
            
            if (result.next()) {
                String country_name = result.getString("country_name");
                String current_infected = result.getString("current_infected");
                String current_death = result.getString("current_death");
                String current_recovered = result.getString("current_recovered");
                String date = result.getString("date");
                world = new World(id, country_name, current_infected, current_death, current_recovered, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return world;
    }
    
    //insertCountry() method to add a new record to world table
    public void insertCountry(World world) throws SQLException {
        Connection connection = connect.getConnection();
        try {
            String INSERT_COUNTRY = 
            		"insert into se2db_world (id, country_name, current_infected, current_death, current_recovered, date) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(INSERT_COUNTRY);
            stm.setInt(1, world.getId());
            stm.setString(2, world.getCountry());
            stm.setString(3, world.getInfected());
            stm.setString(4, world.getDeath());
            stm.setString(5, world.getRecover());
            stm.setString(6, world.getDay());

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //updateCountry() method to update record to table world
    public boolean updateCountry(World world) throws SQLException {
        Connection connection = connect.getConnection();
        boolean rowUpdated = false;
        try {
            String UPDATE_PROVINCE = 
            		"update se2db_world set country_name = ?, current_infected = ?, current_death = ?, current_recovered = ?, date = ? where id = ?";
            PreparedStatement stm = connection.prepareStatement(UPDATE_PROVINCE);
            stm.setString(1, world.getCountry());
            stm.setString(2, world.getInfected());
            stm.setString(3, world.getDeath());
            stm.setString(4, world.getRecover());
            stm.setString(5, world.getDay());
            stm.setInt(6, world.getId());
            
            rowUpdated = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    //deleteCountry() method to delete record to table world
    public boolean deleteCountry(int id) throws SQLException {
        Connection connection = connect.getConnection();
        boolean rowDeleted = false;
        try {
            String DELETE_PROVINCE = "delete from se2db_world where id = ?";
            PreparedStatement stm = connection.prepareStatement(DELETE_PROVINCE);
            stm.setInt(1, id);
            
            rowDeleted = stm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
