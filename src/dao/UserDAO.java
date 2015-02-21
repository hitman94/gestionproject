package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.apache.commons.codec.digest.DigestUtils;

import utilisateur.User;





/**
 * @author Florian
 * Dao utilis� pour les Users
 * Sp�cifie des m�thodes propres � des utilisateurs
 */
@Stateless
@Named
public class UserDAO extends AbstractDAO<User>{

		public UserDAO() {
			super(User.class,"User");
		}
		

		
		
		/**Retourne un User correspondant au Username et password transmit en argument 
		 * M�thode utilis� en cas de connexion � l'application
		 * @param username User Name de l'utilisateur
		 * @param password PassWord de l'utilisateur
		 * @return Le User correspondant au password et username, sinon NULL
		 */
		public User connexion(String username, String password) {
			Query q = em.createQuery("SELECT u FROM User u WHERE u.userName=:username AND u.passWord=:password");
			q.setParameter("username", username);
			q.setParameter("password",password);
			try {
				User u = (User) q.getSingleResult();
				return u;
			} catch (NoResultException e) {
				return null;
			}
		}
		
		/**
		 * Verifie si le username est d�ja pr�sent dans la base de donn�e
		 * @param username Username � tester
		 * @return true si d�ja pr�sent, false sinon
		 */
		public boolean checkUserName(String username) {
			Query q = em.createQuery("SELECT u FROM User u WHERE u.userName=:username");
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
		 * R�cup�re une list de User associer � une entreprise
		 * @param id ID de l'entreprise
		 * @return une liste des User ou null si aucun User n'est associer � l'id
		 */
		@SuppressWarnings("unchecked")
		public List<User> usersFromEntreprise(Long id) {
			Query q = em.createQuery("SELECT u FROM User AS u WHERE u.entreprise.name=:name");
			q.setParameter("name", id);
			try {
				List<User> result = q.getResultList();
				return result;
			} catch (NoResultException e) {
				return null;
			} 
		}

}
