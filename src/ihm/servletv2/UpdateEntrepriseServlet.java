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
import dao.EntrepriseDAO;
import dao.UserDAO;
import entreprise.Entreprise;

/**
 * Servlet implementation class UpdateEntrepriseServlet
 */
@WebServlet("/UpdateEntrepriseServlet")
public class UpdateEntrepriseServlet extends HttpServlet {

	@Inject
	private EntrepriseDAO entrepriseDAO;

	@Inject
	private UserDAO userDAO;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEntrepriseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idEntreprise = request.getParameter("idEntreprise");
		String idChief = request.getParameter("idChief");

		User user = userDAO.findById(new Long(idChief));
		Entreprise entreprise = entrepriseDAO.findById(new Long(idEntreprise));
		if (user == null || entreprise == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,
					"requete mal form�e");
		}

		User toUpdate = entreprise.getChief();
		toUpdate.setEntreprise(null);
		toUpdate.setAbility(Ability.User);
		userDAO.update(toUpdate);
		user.setEntreprise(entreprise);
		user.setAbility(Ability.CompanyChief);
		userDAO.update(user);
		entreprise.setChief(user);

		entrepriseDAO.update(entreprise);

	}

}
