package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilisateur.User;

import comportement.Ability;

import dao.VolumeDAO;

/**
 * Servlet implementation class DeleteVolumeServlet
 */
@WebServlet("/DeleteVolumeServlet")
public class DeleteVolumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private VolumeDAO volumeDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteVolumeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idVolume = request.getParameter("idVolume");
		User user = (User) request.getSession().getAttribute("user");

		if(user == null  || idVolume == null)
			response.sendError(400, "Un des paramètres est incorrect.");
		
		if(user.getAbility() != Ability.Patron)
			response.sendError(400, "L'utilisateur n'est pas le Patron du livre.");	

		if(user.getAbility() == Ability.Patron){
			volumeDAO.remove(volumeDAO.findById(new Long(idVolume)));
			response.setStatus(200);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
