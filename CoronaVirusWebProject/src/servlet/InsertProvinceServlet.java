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
import model.Vietnam;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insertProvince")
public class InsertProvinceServlet extends HttpServlet {
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
				if (action.equals("/insertProvince")) {
					insertProvince(request, response);
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
		doGet(request, response);
	}
	
	//insertProvince() method for adding new province
    private void insertProvince(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String province_name = request.getParameter("province_name");
        String current_infected = request.getParameter("current_infected");
        String current_death = request.getParameter("current_death");
        String current_recover = request.getParameter("current_recover");
        String date = request.getParameter("date");
        Vietnam newProvince = new Vietnam(province_name, current_infected, current_death, current_recover, date);
        adminDAO.insertProvince(newProvince);  
        response.sendRedirect("selectAll");
    }
    
}
