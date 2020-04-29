package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CRUDcontrol.AdminDAO;
import model.Vietnam;
import model.World;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {
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
				if (action.equals("/selectAll")) {
					selectAll(request, response);
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
	
	private void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException   {
        List<Vietnam> listVietnam = adminDAO.selectAllProvinces();
        request.setAttribute("listVietnam", listVietnam);
        
        List<World> listWorld = adminDAO.selectAllCountries();
        request.setAttribute("listWorld", listWorld);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-list.jsp");
        dispatcher.forward(request, response);
    }
}
