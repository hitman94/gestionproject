package dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;

import utilisateur.User;





@Stateful
public class UserDAO extends AbstractDAO<User>{

		public UserDAO() {
			super(User.class,"user");
		}
}
