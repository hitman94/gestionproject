package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comportement.Ability;
import comportement.Role;
import dao.EntrepriseDAO;
import entreprise.Entreprise;
import utilisateur.User;

@WebServlet("/CreateCompanyServlet")
public class CreateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private EntrepriseDAO dao;
	
	public CreateCompanyServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = (String) req.getParameter("name");
		User chief = (User) req.getSession().getAttribute("user");
//		if(chief.getAbility().getRole()==Role.Patron)
//		{
			dao.persist(new Entreprise("entreprise",
					new User("Patron","salade")));
//		}
//		else 
//			resp.setStatus(400);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
