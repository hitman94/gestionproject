package ihm.servletv2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import livre.Chapter;
import utilisateur.User;
import wpws.WPMaturity;
import wpws.WorkPackage;
import comportement.Ability;
import dao.ChapterDAO;
import dao.WorkPackageDAO;

/**
 * Servlet implementation class DownloadFileServlet
 */
@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ChapterDAO dao;

	@Inject
	WorkPackageDAO wpDao;

	public DownloadFileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chapterId = request.getParameter("chapterId");
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.setStatus(400);
			return;
		}

		if (user.getAbility() == Ability.User) {
			Chapter chapter = dao.findById(new Long(chapterId));

			if (chapter.getTakenDate() != -1) {
				response.setStatus(400);
				return;
			}
			Long time = System.currentTimeMillis();

			chapter.setTakenDate(time);

			String path = getServletContext().getRealPath("/chapters/");
			File toSend = new File(path + "/" + chapterId + ".docx");
			if (toSend.exists()) {
				WorkPackage wp = wpDao.findById(chapter.getWp().getId());
				if (wp.getStatus().equals(WPMaturity.Create)) {
					wp.setStatus(WPMaturity.Start);
					wpDao.update(wp);
				}
				dao.update(chapter);
				response.setStatus(200);
				response.setHeader("url", "chapters/" + chapterId + ".docx");
				return;
			}
			response.setStatus(400);

		} else if (user.getAbility() == Ability.CompanyChief) {
			Chapter chapter = dao.findById(new Long(chapterId));
			if (chapter.getTakenDate() == -2)
				response.setHeader("url", "chapters/temp/" + chapterId
						+ ".docx");
			else
				response.setHeader("url", "chapters/" + chapterId + ".docx");

			response.setStatus(200);
			return;

		}
		response.setStatus(400);
		return;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
