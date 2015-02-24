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
 * Servlet implementation class CreateChapterServlet
 */
@WebServlet("/CreateChapterServlet")
public class CreateChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ChapterDAO chapterDAO;

	@Inject
	private VolumeDAO volumeDAO;

	@Inject
	private WorkPackageDAO wpDao;

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
		String workPackageId = request.getParameter("wpId");
		String idVolume = request.getParameter("idVolume");
		User user = (User) request.getSession().getAttribute("user");

		if(user == null || chapterTitle == null || idVolume == null || workPackageId == null)
			response.sendError(400, "Un des paramètres est incorrect.");

		else if(user.getAbility() != Ability.CompanyChief)
			response.sendError(400, "L'utilisateur n'est pas un chef d'entreprise");

		else if(user.getAbility() == Ability.CompanyChief){
			Chapter toAdd = new Chapter(chapterTitle, volumeDAO.findById(new Long(idVolume)), wpDao.findById(new Long(workPackageId)));
			chapterDAO.persist(toAdd);

//			toAdd.getVolume().addChapter(toAdd);
//			toAdd.getWp().addChapter(toAdd);
//
//			volumeDAO.update(toAdd.getVolume());
//			wpDao.update(toAdd.getWp());

			String path=getServletContext().getRealPath("/chapters/");
			File toCreate = new File(path+"/"+toAdd.getId()+".docx");
			toCreate.createNewFile();
			response.setStatus(200);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
