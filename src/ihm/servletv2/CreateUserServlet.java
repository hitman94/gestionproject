package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comportement.Ability;
import utilisateur.User;
import dao.UserDAO;

/**
 * this servlet will manage the register of a new user
 * @author emmanuel
 *
 */
@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	UserDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		if (checkValidity(username) && checkValidity(password)
				&& checkValidity(role)) {

			Ability roleAbility = Ability.valueOf(role);
			dao.persist(new User(username, password, roleAbility));
		}

	}
	
	/**
	 * to verify if a string is not null or empty
	 * @param toTest
	 * @return
	 */
	private boolean checkValidity(String toTest) {
		return !(toTest == null || toTest.isEmpty());
	}

}
