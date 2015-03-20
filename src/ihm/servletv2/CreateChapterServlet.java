package ihm.servletv2;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livre.Chapter;
import livre.Volume;
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
		String numberInVolume = request.getParameter("numberInVolume");
		User user = (User) request.getSession().getAttribute("user");

		response.setCharacterEncoding("UTF-8");
		
		if(user == null || chapterTitle == null || idVolume == null || workPackageId == null)
			response.sendError(400, "Un des paramètres est incorrect.");

		else if(user.getAbility() != Ability.CompanyChief)
			response.sendError(400, "L'utilisateur n'est pas un chef d'entreprise");

		else if(user.getAbility() == Ability.CompanyChief){
			Volume v =volumeDAO.findById(new Long(idVolume));

				if(chapterDAO.chapterNumberInVolumeCheck(new Long(numberInVolume), new Long(idVolume))) {
					response.sendError(400, "Ce numero de chapitre est deja attribue.");
					return;
				}
				for(Entry<Long,Chapter> entry : v.getChapters().entrySet()) {
					if(entry.getValue().getTitle().equals(chapterTitle)) {
						response.sendError(400, "Un chapitre portant ce nom existe deja dans le volume.");
						return;
					}
				}
			
			Chapter toAdd = new Chapter(chapterTitle, v, wpDao.findById(new Long(workPackageId)), new Long(numberInVolume));
			chapterDAO.persist(toAdd);


			String path=getServletContext().getRealPath("/chapters/");
			File chapterDir = new File(path+"/");
			File tmpChapterDir = new File(path+"/temp/");
			if(!chapterDir.exists()) 
				chapterDir.mkdir();
			if(!tmpChapterDir.exists())
				tmpChapterDir.mkdir();
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
