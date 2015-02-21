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

import dao.ChapterDAO;

/**
 * Servlet implementation class DeleteChapterServlet
 */
@WebServlet("/DeleteChapterServlet")
public class DeleteChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ChapterDAO chapterDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteChapterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idChapter = request.getParameter("idChapter");
		User user = (User) request.getSession().getAttribute("user");

		if(user == null  || idChapter == null)
			response.sendError(400, "Un des paramètres est incorrect.");
		
		if(user.getAbility() != Ability.CompanyChief)
			response.sendError(400, "L'utilisateur n'est pas un CompanyChief");			

		if(user.getAbility() == Ability.CompanyChief){
			response.setStatus(200);
			chapterDAO.remove(chapterDAO.findById(new Long(idChapter)));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
