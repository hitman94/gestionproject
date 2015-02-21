package ihm.servletv2;

import java.io.File;
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
import dao.WorkPackageDAO;

/**
 * Servlet implementation class DeleteChapterServlet
 */
@WebServlet("/DeleteChapterServlet")
public class DeleteChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ChapterDAO chapterDAO;

	@Inject
	private VolumeDAO volDao;

	@Inject
	private WorkPackageDAO wpDao;

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
			Chapter toDelete=chapterDAO.findById(new Long(idChapter));
			toDelete.getVolume().removeChapter(toDelete);
			toDelete.getWp().removeChapter(toDelete);
			chapterDAO.remove(toDelete);
			volDao.update(toDelete.getVolume());
			wpDao.update(toDelete.getWp());
			String path=getServletContext().getRealPath("/chapters/");
			File toRemove = new File(path+"/"+idChapter+".docx");
			toRemove.delete();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
