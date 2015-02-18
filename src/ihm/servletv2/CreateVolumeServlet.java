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

import comportement.Role;

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
		User user = (User) request.getAttribute("user");

		if(user == null || user.getAbility().getRole() != Role.Patron
				|| volumeTitle == null || idWP == null){
			response.setStatus(400);
			return;
		}

		if(user.getAbility().getRole() == Role.Patron){
			volumeDAO.persist(new Volume(volumeTitle, workPackageDAO.findById(new Long(idWP))));
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
