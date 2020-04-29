package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CRUDcontrol.AdminDAO;
import model.World;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateCountry")
public class UpdateCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO;   
    HttpSession session;
    
    public void init() {
    	adminDAO = new AdminDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		session=request.getSession();  
		boolean logged_in= false;
    	if(session.getAttribute("admin")== null) System.out.println("Not logged in");
    	if(session.getAttribute("admin")!= null) {
    		System.out.println("Logged in");
    		logged_in= (boolean) session.getAttribute("admin");
    	}
    	try {
			if(logged_in) {
				if (action.equals("/updateCountry")) {
					updateCountry(request, response);
				}
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp?error=Access%20Denied");
		        dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//updateCountry() method for updating existing country
    private void updateCountry(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String country_name = request.getParameter("country_name");
        String current_infected = request.getParameter("current_infected");
        String current_death = request.getParameter("current_death");
        String current_recover = request.getParameter("current_recover");
        String date = request.getParameter("date");
        World updateCountry = new World(id, country_name, current_infected, current_death, current_recover, date);
        adminDAO.updateCountry(updateCountry);
        response.sendRedirect("selectAll");
    }

}
