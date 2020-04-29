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
 * Servlet implementation class HomeServlet
 */
@WebServlet("/verifyLogin")
public class VerifyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO;
    HttpSession session;
    
    
    public void init() {
    	adminDAO= new AdminDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		session=request.getSession();
		try {
			if (action.equals("/verifyLogin")) {
				attemptLogin(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
    private void attemptLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String username = (String)(request.getParameter("username"));
        String password = (String)(request.getParameter("password"));
        System.out.println(username+ " " + password);
        boolean flag= true;
        if(adminDAO.adminLogin(username, password)) {
        	
        	session.setAttribute("admin", flag);
        	System.out.println(session.getAttribute("admin"));
        	System.out.println("Login success");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("selectAll"); // go to /selectAll
        	dispatcher.forward(request, response);
        	
        }
        else {
        	System.out.println("Login failed");
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/login?error=Invalid%20Credentials");
        	rd.forward(request, response);
        	
//        	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//        	dispatcher.forward(request, response);
        }
    }

}
