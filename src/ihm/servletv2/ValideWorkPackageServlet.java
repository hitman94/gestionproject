package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comportement.Ability;
import dao.WorkPackageDAO;
import utilisateur.User;
import wpws.WPMaturity;
import wpws.WorkPackage;

/**
 * Servlet implementation class ValideWorkPackageServlet
 */
@WebServlet("/ValideWorkPackageServlet")
public class ValideWorkPackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private WorkPackageDAO workPackageDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValideWorkPackageServlet() {
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
		if(user.getAbility() != Ability.CompanyChief){
			response.sendError(400, "L'utilisateur connecté n'as pas les droits requis pour créer un workPackage");
			return;
		}
		WorkPackage wp = workPackageDAO.findById(new Long(idWP));
		wp.setStatus(WPMaturity.Done);
		workPackageDAO.update(wp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
