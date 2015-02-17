package dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.codec.digest.DigestUtils;

import utilisateur.User;





/**
 * @author Florian
 * Dao utilisé pour les Users
 * Spécifie un des méthode propres à des utilisateur
 */
@Stateful
public class UserDAO extends AbstractDAO<User>{

		public UserDAO() {
			super(User.class,"user");
		}
		
		
		public User connexion(String username, String password) {
			Query q = em.createQuery("SELECT u FROM User u WHERE u.username=:username AND u.passWord=:password");
			q.setParameter("username", username);
			q.setParameter("password", DigestUtils.sha1Hex(password));
			try {
				User u = (User) q.getSingleResult();
				return u;
			} catch (NoResultException e) {
				return null;
			}
		}
		
		public boolean checkUserName(String username) {
			Query q = em.createQuery("SELECT u FROM User u WHERE u.username=:username");
			q.setParameter("username", username);
			try {
				q.getSingleResult();
				return false;
			} catch (NoResultException e) {
				return true;
			} catch (NonUniqueResultException e) {
				return false;
			}
		}
		
		@SuppressWarnings("unchecked")
		public List<User> userFromEntreprise(Long id) {
			Query q = em.createQuery("SELECT u FROM User u WHERE u.COMPANY_NAME=:COMPANY_NAME");
			q.setParameter("COMPANY_NAME", id);
			try {
				List<User> result = q.getResultList();
				return result;
			} catch (NoResultException e) {
				return null;
			} 
		}

}
