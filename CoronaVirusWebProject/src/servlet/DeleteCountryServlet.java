package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import CRUDcontrol.AdminDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteCountry")
public class DeleteCountryServlet extends HttpServlet {
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
				if (action.equals("/deleteCountry")) {
					deleteCountry(request, response);
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
//    	if(logged_in) {
//    		if (action.equals("/deleteCountry")) 
//    		{
//    			try {
//    				deleteCountry(request, response);
//    			}
//    			catch (SQLException e){
//    				e.printStackTrace();
//    			}
//    		}
//    	}
//   		else {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp?error=Access%20Denied");
//			dispatcher.forward(request, response);
//		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
  //deleteCountry() method for deleting existing country
    private void deleteCountry(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        adminDAO.deleteCountry(id);
        response.sendRedirect("selectAll");
    }
	
}
