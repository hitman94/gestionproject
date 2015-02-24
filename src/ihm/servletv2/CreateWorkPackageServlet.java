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
import wpws.WorkPackage;
import wpws.WorkSpace;
import dao.VolumeDAO;
import dao.WorkPackageDAO;
import dao.WorkSpaceDAO;

/**
 * Servlet implementation class CreateWorkPackageServlet
 */
@WebServlet("/CreateWorkPackageServlet")
public class CreateWorkPackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	 private WorkSpaceDAO workSpaceDao;
	
	@Inject
	private WorkPackageDAO workPackageDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateWorkPackageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idWS = request.getParameter("idWorkSpace");
		String nameWP = request.getParameter("nameWP");
		WorkSpace ws = workSpaceDao.findById(new Long(idWS));
		User user = (User) request.getSession().getAttribute("user");
		if(ws != null){
			if( user == null){
				response.sendError(400, "Aucun utilisateur connect�");
				return;
			}
			if(user.getAbility() == Ability.User){
				response.sendError(400, "L'utilisateur connect� n'as pas les droits requis pour cr�er un workPackage");
				return;
			}
			WorkPackage wp = new WorkPackage(ws,nameWP);
			workPackageDAO.persist(wp);
		}else{
			response.sendError(400,"l'id " + idWS + "ne correspond � aucun workspace de la base de donn�es");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
