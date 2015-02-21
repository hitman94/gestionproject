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
import comportement.Ability;
import dao.EntrepriseDAO;
import entreprise.Entreprise;

/**
 * Servlet implementation class DeleteEntrepriseServlet
 */
@WebServlet("/DeleteEntrepriseServlet")
public class DeleteEntrepriseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Inject
       private EntrepriseDAO entrepriseDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEntrepriseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idEntreprise = request.getParameter("idEntreprise");
		User user = (User) request.getSession().getAttribute("user");
			if( user == null){
				response.sendError(400, "Aucun utilisateur connect�");
				return;
			}
			if(user.getAbility() != Ability.Patron){
				response.sendError(400, "L'utilisateur connecté n'as pas les droits requis pour cr�er un workPackage");
				return;
			}
			Entreprise ent = entrepriseDAO.findById(new Long(idEntreprise));
			if( ent == null){
				response.sendError(400, "Aucune entreprise ne correspond � l'id " + idEntreprise);
				return;
			}
			entrepriseDAO.remove(ent);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
