package ihm.servletv2;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilisateur.User;
import dao.UserDAO;

public class RemoveUserServlet extends HttpServlet {

	@Inject
	UserDAO userdao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		User user = (User) req.getSession().getAttribute("user");

		if (id == null || id.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
					"La requete est mal formee");
		} else {
			User userToDelete = userdao.findById(new Long(id));
			if (userToDelete == null) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
						"L'utilisateur n'existe pas");
			} else {
				userdao.remove(userToDelete);
				resp.setStatus(200);

			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
