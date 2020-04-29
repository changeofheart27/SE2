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

import CRUDcontrol.UserDAO;
import model.Vietnam;
import model.World;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    
    public void init() {
    	userDAO = new UserDAO();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			if (action.equals("/home")) {
				selectAll(request, response);
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
        List<Vietnam> listVietnam = userDAO.selectAllProvinces();
        request.setAttribute("listVietnam", listVietnam);
        
        List<World> listWorld = userDAO.selectAllCountries();
        request.setAttribute("listWorld", listWorld);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

}
