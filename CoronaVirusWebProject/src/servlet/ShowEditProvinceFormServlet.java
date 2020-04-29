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
 * Servlet implementation class ShowUpdateFormServlet
 */
@WebServlet("/editProvince")
public class ShowEditProvinceFormServlet extends HttpServlet {
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
				if (action.equals("/editProvince")) {
					showEditProvinceForm(request, response);
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
	
	//showEditProvinceForm() method which navigates to EDIT PROVINCE view (edit-province.jsp)
    private void showEditProvinceForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Vietnam existingProvince = adminDAO.selectProvince(id);
        request.setAttribute("vietnam", existingProvince);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-province.jsp");
        dispatcher.forward(request, response);
    }
    
}
