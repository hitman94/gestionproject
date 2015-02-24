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
import comportement.Ability;
import dao.ChapterDAO;

/**
 * Servlet implementation class DownloadFileServlet
 */
@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	ChapterDAO dao;
	
    public DownloadFileServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chapterId = request.getParameter("chapterId"); 	
		User user = (User) request.getSession().getAttribute("user");
		

		if(user==null) {
			response.setStatus(400);
			return;
		}
		
		
		if(user.getAbility() == Ability.User) { 
			 Chapter chapter = dao.findById(new Long(chapterId));
			 
			 if(chapter.getTakenDate() != -1) {
				 response.setStatus(400);
				return;
			 }
			 Long time = System.currentTimeMillis();
			 
			 chapter.setTakenDate(time);
			 
			 String path=getServletContext().getRealPath("/chapters/");
			 File toSend = new File(path+"/"+chapterId+".docx");
			 response.setContentType("application/octet-stream");
			 response.setContentLength((int) toSend.length());
			 OutputStream out = response.getOutputStream();
			 InputStream in = new FileInputStream(toSend);
			 try {
				 int a;
				 while((a=in.read())!=-1)
					 out.write((char)a);
			 }finally {
				 out.close();
				 in.close();
			 }
			 response.setStatus(200);
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
