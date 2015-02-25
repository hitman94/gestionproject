package ihm.servletv2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	ChapterDAO dao;
	

    public UploadFileServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chapterId = request.getParameter("chapterId"); // On recupere l'id du chapitre a mettre à jour
		Part file = request.getPart("chapterLocation"); //On récupere le fichier que l'utilisateur a envoyé ( c'est le contenu du chapitre )
		
		log("bonjour "+chapterId);
		//On récupère dans la session la classe qui représente l'utilisateur qui a appelé ce Servlet
		User user = (User) request.getSession().getAttribute("user");
		
		//Si c'est null c'est que la personne n'est pas connectée
		if(user==null) {
			response.getWriter().write("<html><body><div id=\"answer\">non</div></body></html>");
			response.setStatus(400);//on met donc un message d'erreur
			return;//et on s'arrete là
		}
		
		//Si c'est bien un utilisateur ( car seul les utilisateurs ont le droit de soumettre un travail )
		//Alors on commence le traitement de mise à jour
		
		if(user.getAbility() == Ability.User) { 
			 Chapter chapter = dao.findById(new Long(chapterId));//On récupère le chapitre qu'on modifie
			 String path=getServletContext().getRealPath("/chapters/");
			 File toSave = new File(path+"/"+chapterId+".docx");
			 toSave.delete();
			 FileOutputStream out=null;
			 try  {
			  out= new FileOutputStream(toSave);
			 InputStream in = file.getInputStream();
			 int toRead;
			 while((toRead=in.read()) !=-1)
				 out.write((char)toRead);
			 
			 chapter.setTakenDate(-1L);//On met a jour la takenDate à -1 pour dire qu'on peut a nouveau l'éditer
			 dao.update(chapter);//On met à jour la BDD
			 response.getWriter().write("<html><body><div id=\"answer\">ok</div></body></html>");
			 response.setStatus(200);
			 } finally {
				 if(out!=null)
					 out.close();
			 }
			 
			return;
		}
		response.setStatus(400);
		response.getWriter().write("<html><body><div id=\"answer\">non</div></body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
