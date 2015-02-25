package ihm.servletv2;

import java.io.IOException;
import java.util.Objects;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import utilisateur.User;
import comportement.Ability;
import dao.UserDAO;
import entreprise.Entreprise;

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

		if (dao.checkUserName(username)) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"Username déjà pris");
			return;
		}
		User user = (User) request.getSession().getAttribute("user");

		if (checkValidity(username) && checkValidity(password)) {

			// Ability roleAbility = Ability.valueOf(role);

			Ability userAb = user.getAbility();
			if (userAb.equals(Ability.User)) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
						"Vous n'avez pas les droits suffissants pour creer un utilisateur quelconques");
			} else {
				if (userAb.equals(Ability.Patron)) {
					dao.persist(new User(username, DigestUtils
							.sha1Hex(password), Ability.CompanyChief));
				} else {
					Entreprise entreprise = user.getEntreprise();
					if (Objects.isNull(entreprise)) {
						dao.persist(new User(username, DigestUtils
								.sha1Hex(password), Ability.User));
					} else {
						User u2 = new User(username,
								DigestUtils.sha1Hex(password), Ability.User);
						u2.setEntreprise(entreprise);
						dao.persist(u2);
					}

				}

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
