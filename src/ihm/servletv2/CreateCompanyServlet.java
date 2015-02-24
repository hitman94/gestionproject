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
import dao.EntrepriseDAO;
import dao.UserDAO;
import entreprise.Entreprise;

/**
 * Servlet implementation class CreateCompanyServlet
 */
@WebServlet("/CreateCompanyServlet")
public class CreateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private EntrepriseDAO entrepriseDAO;
    
	@Inject
	private UserDAO userDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("companyName");
		String idChief = request.getParameter("idChief");
		User chief = userDAO.findById(new Long(idChief));
	
		User user = (User) request.getSession().getAttribute("user");
		if(chief!=null){
			if( user == null){
				response.sendError(400, "Aucun utilisateur connect�");
				return;
			}
			if(user.getAbility() != Ability.Patron){
				response.sendError(400, "L'utilisateur connecté n'as pas les droits requis pour créer un workPackage");
				return;
			}
			Entreprise ent = new Entreprise(name, chief);
			entrepriseDAO.persist(ent);
		}else{
			response.sendError(400,"l'id " + idChief + "ne correspond à aucun utilisateur dans la base de données");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}

}
