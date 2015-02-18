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
 * Spécifie des méthodes propres à des utilisateurs
 */
@Stateful
public class UserDAO extends AbstractDAO<User>{

		public UserDAO() {
			super(User.class,"User");
		}
		

		
		
		/**Retourne un User correspondant au Username et password transmit en argument 
		 * Méthode utilisé en cas de connexion à l'application
		 * @param username User Name de l'utilisateur
		 * @param password PassWord de l'utilisateur
		 * @return Le User correspondant au password et username, sinon NULL
		 */
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
		
		/**
		 * Verifie si le username est déja présent dans la base de donnée
		 * @param username Username à tester
		 * @return true si déja présent, false sinon
		 */
		public boolean checkUserName(String username) {
			Query q = em.createQuery("SELECT u FROM User u WHERE u.username=:username");
			q.setParameter("username", username);
			try {
				q.getSingleResult();
				return true;
			} catch (NoResultException e) {
				return false;
			} catch (NonUniqueResultException e) {
				return true;
			}
		}
		
		/**
		 * Récupère une list de User associer à une entreprise
		 * @param id ID de l'entreprise
		 * @return une liste des User ou null si aucun User n'est associer à l'id
		 */
		@SuppressWarnings("unchecked")
		public List<User> usersFromEntreprise(Long id) {
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
