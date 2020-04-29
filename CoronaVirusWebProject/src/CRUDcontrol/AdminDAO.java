package CRUDcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
    
    //login
    public boolean adminLogin(String username, String password) {
        
        Connection connection = connect.getConnection();
        try {
            
            String admlogin = "select * from se2db_admin where ( username = ? and password = ?)";
            PreparedStatement stm = connection.prepareStatement(admlogin);
            stm.setString(1, username);
            stm.setString(2, password);
            
            ResultSet result = stm.executeQuery();
            
            int rowcount = 0;
            if (result.last()) {
              rowcount = result.getRow();
              result.beforeFirst(); 
            }
            
            if (rowcount==0) return false;
            
            if (rowcount>0) {
            	ResultSetMetaData rsmd = result.getMetaData();
            	int columnsNumber = rsmd.getColumnCount();
            	while (result.next()) {
            	    for (int i = 1; i <= columnsNumber; i++) {
            	        if (i > 1) System.out.print(",  ");
            	        String columnValue = result.getString(i);
            	        System.out.print(columnValue + " " + rsmd.getColumnName(i));
            	    }
            	    System.out.println("");
            	}
            	return true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
            		"insert into se2db_vietnam (province_name, current_infected, current_death, current_recovered, date) values (?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(INSERT_PROVINCE);
            stm.setString(1, vietnam.getProvinceName());
            stm.setString(2, vietnam.getCurrentInfected());
            stm.setString(3, vietnam.getCurrentDeath());
            stm.setString(4, vietnam.getCurrentRecover());
            stm.setString(5, vietnam.getDate());

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
            stm.setString(1, vietnam.getProvinceName());
            stm.setString(2, vietnam.getCurrentInfected());
            stm.setString(3, vietnam.getCurrentDeath());
            stm.setString(4, vietnam.getCurrentRecover());
            stm.setString(5, vietnam.getDate());
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
            		"insert into se2db_world (country_name, current_infected, current_death, current_recovered, date) values (?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(INSERT_COUNTRY);
            stm.setString(1, world.getCountryName());
            stm.setString(2, world.getCurrentInfected());
            stm.setString(3, world.getCurrentDeath());
            stm.setString(4, world.getCurrentRecover());
            stm.setString(5, world.getDate());
            
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
            stm.setString(1, world.getCountryName());
            stm.setString(2, world.getCurrentInfected());
            stm.setString(3, world.getCurrentDeath());
            stm.setString(4, world.getCurrentRecover());
            stm.setString(5, world.getDate());
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
