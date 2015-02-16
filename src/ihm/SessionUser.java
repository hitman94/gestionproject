/**
 * 
 */
package ihm;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import utilisateur.User;

/**
 * @author doquanghuy
 *
 */

//SessionUser service the session's each user while they connect to system 
@Named
@SessionScoped
public class SessionUser {
	
	//After login,if true we get instance's object user from database 
	//if false user = null
    private User user;
    
    //After connect, we set connect to true, else = false
    private boolean isConnected=false;
    
    //Object Message which service us to pass the type message and content of message 
    //between pages Servlet and JSP
    private Message message;
    
    public SessionUser() {
    }
    
    public User getUser()
    {
        return user;
    }
    
    public void setUser(User user)
    {
        this.user=user;
    }
    
    public boolean getIsConnected()
    {
        return isConnected;
    }
    
    public void setIsConnected(boolean isConnected)
    {
        this.isConnected=isConnected;
    }
    
    public Message getMessage()
    {
    	if(message==null)
    	{
    		message=new Message(0,"");
    	}
    	return message;
        
    }
    
    public void setMessage(Message message)
    {
        this.message=message;
    }
	

}
