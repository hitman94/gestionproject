package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comportement.Ability;

import utilisateur.User;
import dao.UserDAO;

public class RemoveUserServlet extends HttpServlet {

	@Inject
	UserDAO userdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		User ownerRequest = (User) req.getSession().getAttribute("user");
		if (id == null || id.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
					"La requete est mal formee");
			return;
		}
		
		User userTodelete = userdao.findById(new Long(id));
		if (userTodelete == null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
					"L'utilisateur n'existe pas");
			return;
		} 
		Ability userTodeleteAbility = userTodelete.getAbility();
		Ability userAb = ownerRequest.getAbility();

		// if a user try to delete other user or if the user to delete is the
		// patron
		if (userAb.equals(Ability.User)
				|| userTodeleteAbility.equals(Ability.Patron)) {
			resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"Vous n'avez pas les droits requis pour cette opération");
		} else {
					
				userdao.remove(userTodelete);
				resp.setStatus(200);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
