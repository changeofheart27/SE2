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
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteProvince")
public class DeleteProvinceServlet extends HttpServlet {
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
				if (action.equals("/deleteProvince")) {
					deleteProvince(request, response);
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
	
	//deleteProvince() method for deleting existing province
    private void deleteProvince(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        adminDAO.deleteProvince(id);
        response.sendRedirect("selectAll");
    }
    
}
