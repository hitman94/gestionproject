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
 * Servlet implementation class CreateVolumeServlet
 */
@WebServlet("/CreateVolumeServlet")
public class CreateVolumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private VolumeDAO volumeDAO;

	@Inject
	private WorkPackageDAO workPackageDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateVolumeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String volumeTitle = request.getParameter("title");
		String idWP = request.getParameter("idWorkPackage");
		User user = (User) request.getSession().getAttribute("user");

		if(user == null || volumeTitle == null || idWP == null)
			response.sendError(400, "Un des paramètres est incorrect.");

		else if(user.getAbility() != Ability.Patron)
			response.sendError(400, "L'utilisateur n'est pas le Patron du livre.");

		else if(volumeDAO.checkVolumeExist(volumeTitle) ==true){
			response.sendError(400, "Le nom du volume existe déja .");
		}
		else if(user.getAbility() == Ability.Patron){

			Volume toAdd=new Volume(volumeTitle, workPackageDAO.findById(new Long(idWP)));
			volumeDAO.persist(toAdd);
			//			toAdd.getWp().addVolume(toAdd);
			//			workPackageDAO.update(toAdd.getWp());
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
