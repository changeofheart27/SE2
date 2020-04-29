package servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		session=request.getSession();
        session.invalidate();
//         Get an HttpSession related to this request, if no session exist don't
//         create a new one. This is just a check to see after invalidation the
//         session will be null.
//        session = request.getSession(false);
//        System.out.println("Session : " + session);
		if (action.equals("/logout")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home"); //using URL of targeted servlet
		    dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	


}
