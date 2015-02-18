package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilisateur.User;

import comportement.Role;

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
		User user = (User) request.getAttribute("user");

		if(user == null || user.getAbility().getRole() != Role.Patron || idVolume == null){
			response.setStatus(400);
			return;
		}

		if(user.getAbility().getRole() == Role.Patron){
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
