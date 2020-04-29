package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Automatically redirect to /home
 */
@WebServlet("/")
public class Default extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		session=request.getSession();  
		boolean logged_in= false;
    	if(session.getAttribute("admin")== null) System.out.println("Not logged in");
    	if(session.getAttribute("admin")!= null) {
    		System.out.println("Logged in");
    		logged_in= (boolean) session.getAttribute("admin");
    	}
		if (logged_in) {
			if (action.equals("/")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/selectAll");
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	


}
