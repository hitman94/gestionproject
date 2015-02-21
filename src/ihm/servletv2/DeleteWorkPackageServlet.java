package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilisateur.User;
import wpws.WorkPackage;
import wpws.WorkSpace;
import comportement.Ability;
import dao.WorkPackageDAO;

/**
 * Servlet implementation class DeleteWorkPackageServlet
 */
@WebServlet("/DeleteWorkPackageServlet")
public class DeleteWorkPackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private WorkPackageDAO workPackageDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWorkPackageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idWP = request.getParameter("idWorkPackage");
		User user = (User) request.getSession().getAttribute("user");
			if( user == null){
				response.sendError(400, "Aucun utilisateur connecté");
				return;
			}
			if(user.getAbility() == Ability.User){
				response.sendError(400, "L'utilisateur connecté n'as pas les droits requis pour créer un workPackage");
				return;
			}
			WorkPackage wp = workPackageDAO.findById(new Long(idWP));
			if(wp == null){
				response.sendError(400, "Aucun workpackage ne correspond à l'id " + idWP);
				return;
			}
			workPackageDAO.remove(wp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
