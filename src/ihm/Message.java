package ihm;


//Define Message CDI for type and content of message
// Message Welcome
// Message create / modify user
// Message error
public class Message {
	
	//Type mgs 0 = normal, 1 = error
	private int type;
	
	//Content message
	private String msg;
	
	
	public Message(int type, String msg)
	{
		this.type=type;
		this.msg=msg;
	}
	
	public int getTypeMsg()
	{
		return type;
	}
	
	public void setTypeMsg(int type)
	{
		this.type=type;
	}
	
	public String getMessage()
	{
		return msg;
	}

	
	public void setMessage(String msg)
	{
		this.msg=msg;
	}
}
