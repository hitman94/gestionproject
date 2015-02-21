package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livre.Chapter;
import utilisateur.User;

import comportement.Ability;

import dao.ChapterDAO;
import dao.VolumeDAO;

/**
 * Servlet implementation class CreateChapterServlet
 */
@WebServlet("/CreateChapterServlet")
public class CreateChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ChapterDAO chapterDAO;
	
	@Inject
	private VolumeDAO volumeDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateChapterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chapterTitle = request.getParameter("title");
		String idVolume = request.getParameter("idVolume");
		User user = (User) request.getSession().getAttribute("user");

		if(user == null || chapterTitle == null || idVolume == null)
			response.sendError(400, "Un des paramètres est incorrect.");
		
		if(user.getAbility() != Ability.CompanyChief)
			response.sendError(400, "L'utilisateur n'est pas un CompanyChief");

		if(user.getAbility() == Ability.CompanyChief){
			response.setStatus(200);
			chapterDAO.persist(new Chapter(chapterTitle, volumeDAO.findById(new Long(idVolume))));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
