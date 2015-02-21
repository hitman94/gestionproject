package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import comportement.Ability;
import utilisateur.User;
import dao.UserDAO;

/**
 * this servlet will manage the register of a new user
 * 
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

		User user = (User) request.getSession().getAttribute("user");

		if (checkValidity(username) && checkValidity(password)
				&& checkValidity(role)) {

			Ability roleAbility = Ability.valueOf(role);
			Ability userAb = user.getAbility();
			if (userAb.equals(Ability.User)) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
						"Vous n'avez pas les droits suffissants pour creer un utilisateur quelconques");
			} else if (roleAbility.equals(Ability.Patron)) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
						"Vous n'avez pas les droits requis pour creer un utilisateur ayant les droits "
								+ roleAbility);

			} else {
				dao.persist(new User(username, DigestUtils.sha1Hex(password),
						roleAbility));
				response.setStatus(200);
			}

		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,
					"La requete est mal formee");
		}

	}

	/**
	 * to verify if a string is not null or empty
	 * 
	 * @param toTest
	 * @return
	 */
	private boolean checkValidity(String toTest) {
		return !(toTest == null || toTest.isEmpty());
	}

}
