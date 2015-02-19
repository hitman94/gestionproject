package ihm.servletv2;

import java.io.IOException;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import comportement.Ability;

import utilisateur.User;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chapterId = request.getParameter("chapterId"); // On recupere l'id du chapitre a mettre à jour
		Part file = request.getPart("file"); //On récupere le fichier que l'utilisateur a envoyé ( c'est le contenu du chapitre )
		
		//On récupère dans la session la classe qui représente l'utilisateur qui a appelé ce Servlet
		User user = (User) request.getSession().getAttribute("user");
		
		//Si c'est null c'est que la personne n'est pas connectée
		if(user==null) {
			response.setStatus(400);//on met donc un message d'erreur
			return;//et on s'arrete là
		}
		
		//Si c'est bien un utilisateur ( car seul les utilisateurs ont le droit de soumettre un travail )
		//Alors on commence le traitement de mise à jour
		if(user.getAbility() == Ability.User) { 
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
