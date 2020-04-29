package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import CRUDcontrol.AdminDAO;
import model.Vietnam;
import model.World;
import java.util.List;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO adminDAO;
	
	public void init() {
		adminDAO = new AdminDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
        try {
            switch (action) {
                case "/newProvince":
                    showNewProvinceForm(request, response);
                    break;
                case "/editProvince":
                    showEditProvinceForm(request, response);
                    break;
                case "/insertProvince":
                    insertProvince(request, response);
                    break;
                case "/updateProvince":
                    updateProvince(request, response);
                    break;
                case "/deleteProvince":
                    deleteProvince(request, response);
                    break;
                case "/newCountry":
                    showNewCountryForm(request, response);
                    break;
                case "/editCountry":
                    showEditCountryForm(request, response);
                    break;
                case "/insertCountry":
                    insertCountry(request, response);
                    break;
                case "/updateCountry":
                    updateCountry(request, response);
                    break;
                case "/deleteCountry":
                    deleteCountry(request, response);
                    break;
                default:
                    listAll(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void listAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException   {
        List<Vietnam> listVietnam = adminDAO.selectAllProvinces();
        request.setAttribute("listVietnam", listVietnam);
        
        List<World> listWorld = adminDAO.selectAllCountries();
        request.setAttribute("listWorld", listWorld);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
	
	//VIETNAM TABLE
    
    //insertProvince() method for adding new province
    private void insertProvince(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
    	int id = request.getIntHeader("id");
        String province = request.getParameter("province");
        String infected = request.getParameter("infected");
        String death = request.getParameter("death");
        String recover = request.getParameter("recover");
        String day = request.getParameter("day");
        Vietnam newProvince = new Vietnam(id, province, infected, death, recover, day);
        adminDAO.insertProvince(newProvince);  
        response.sendRedirect("list");
    }
    
    //updateProvince() method for updating existing province
    private void updateProvince(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String province = request.getParameter("province");
        String infected = request.getParameter("infected");
        String death = request.getParameter("death");
        String recover = request.getParameter("recover");
        String day = request.getParameter("day");
        Vietnam updateProvince = new Vietnam(id, province, infected, death, recover, day);
        adminDAO.updateProvince(updateProvince);
        response.sendRedirect("list");
    }
    
    //deleteProvince() method for deleting existing province
    private void deleteProvince(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        adminDAO.deleteProvince(id);
        response.sendRedirect("list");
    }
    
    //showNewProvinceForm() method which navigates to ADD PROVINCE view (add-province.jsp)
    private void showNewProvinceForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-province.jsp");
        dispatcher.forward(request, response);
    }
    
    //showEditProvinceForm() method which navigates to EDIT PROVINCE view (edit-province.jsp)
    private void showEditProvinceForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Vietnam existingProvince = adminDAO.selectProvince(id);
        request.setAttribute("vietnam", existingProvince);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-province.jsp");
        dispatcher.forward(request, response);
    }
    
    //WORRLD TABLE
    
    //insertCountry() method for adding new country
    private void insertCountry(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
    	int id = request.getIntHeader("id");
        String country = request.getParameter("country");
        String infected = request.getParameter("infected");
        String death = request.getParameter("death");
        String recover = request.getParameter("recover");
        String day = request.getParameter("day");
        World newCountry = new World(id, country, infected, death, recover, day);
        adminDAO.insertCountry(newCountry);  
        response.sendRedirect("list");
    }
    
    //updateCountry() method for updating existing country
    private void updateCountry(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String country = request.getParameter("country");
        String infected = request.getParameter("infected");
        String death = request.getParameter("death");
        String recover = request.getParameter("recover");
        String day = request.getParameter("day");
        World updateCountry = new World(id, country, infected, death, recover, day);
        adminDAO.updateCountry(updateCountry);
        response.sendRedirect("list");
    }
    
    //deleteCountry() method for deleting existing country
    private void deleteCountry(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        adminDAO.deleteCountry(id);
        response.sendRedirect("list");
    }
    
    //showNewForm() method which navigates to ADD COUNTRY view (add-country.jsp)
    private void showNewCountryForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-country.jsp");
        dispatcher.forward(request, response);
    }
    
    //showEditForm() method which navigates to EDIT COUNTRY view (edit-country.jsp)
    private void showEditCountryForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        World existingCountry = adminDAO.selectCountry(id);
        request.setAttribute("world", existingCountry);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-country.jsp");
        dispatcher.forward(request, response);
    }
    
    //verify admin function...

}
