package ihm.servletv2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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

/**
 * Servlet implementation class PromoteChapterServlet
 */
@WebServlet("/PromoteChapterServlet")
public class PromoteChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	ChapterDAO dao;

	public PromoteChapterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chapterId = request.getParameter("chapterId");
		String validate = request.getParameter("validate");
		User user = (User) request.getSession().getAttribute("user");
		if (user.getAbility().equals(Ability.CompanyChief)) {
			
			String tmpPath = getServletContext().getRealPath("/chapters/temp/");
			File tmpFile = new File(tmpPath + "/" + chapterId + ".docx");

			String path = getServletContext().getRealPath("/chapters/");
			File file = new File(path + "/" + chapterId + ".docx");
			
			Chapter chapter = dao.findById(new Long(chapterId));
			if (validate.equals("ok")) {
				
				file.delete();
				file.createNewFile();
				FileOutputStream out = null;
				InputStream in = null;
				try {
					out = new FileOutputStream(file);
					in = new FileInputStream(tmpFile);
					int toRead;
					while ((toRead = in.read()) != -1)
						out.write((char) toRead);

					
				} finally {
					if (out != null)
						out.close();
					if (in != null)
						in.close();

				}
				
			}
			tmpFile.delete();
			chapter.setTakenDate(-1L);
			dao.update(chapter);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
