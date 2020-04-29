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
 * Servlet implementation class ShowNewFormServlet
 */
@WebServlet("/newCountry")
public class ShowNewCountryFormServlet extends HttpServlet {
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
    	try {
			if(logged_in) {
				if (action.equals("/newCountry")) {
					showNewCountryForm(request, response);
				}
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp?error=Access%20Denied");
			    dispatcher.forward(request, response);
			}
		} 
		catch (ServletException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//showNewCountryForm() method which navigates to ADD COUNTRY view (add-country.jsp)
    private void showNewCountryForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-country.jsp");
        dispatcher.forward(request, response);
    }

}
