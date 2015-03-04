package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livre.Volume;
import utilisateur.User;

import comportement.Ability;

import dao.VolumeDAO;
import dao.WorkPackageDAO;

/**
 * Servlet implementation class DeleteVolumeServlet
 */
@WebServlet("/EditVolumeServlet")
public class EditVolumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private VolumeDAO volumeDAO;

	@Inject
	private WorkPackageDAO wpDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditVolumeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idVolume = request.getParameter("idVolume");
		User user = (User) request.getSession().getAttribute("user");
		String title = request.getParameter("title");
		
		if(user == null  || idVolume == null)
			response.sendError(400, "Un des paramètres est incorrect.");

		else if(user.getAbility() != Ability.Patron)
			response.sendError(400, "L'utilisateur n'est pas le Patron du livre.");

		else if(volumeDAO.checkVolumeExist(title))
			response.sendError(400, "Le volume existe déjà.");

		else if(title.isEmpty())
			response.sendError(400, "Veuillez remplir le titre du volume.");

		else if(title.length() > 20)
			response.sendError(400, "Veuillez choisir un nom plus court pour votre volume. (< 20 caractères)");

		else if(user.getAbility() == Ability.Patron){
			Volume v=volumeDAO.findById(new Long(idVolume));
			v.setTitle(title);
			volumeDAO.update(v);
			response.setStatus(200);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
