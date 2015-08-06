package action;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import po.User;
import util.Counter;
import service.userService;
public class dengluAction extends ActionSupport{
	private userService userservice;
	private String username;
	private  String upassword;
	public userService getUserService() {
		return userservice;
	}
	public void setUserService(userService userservice) {
		this.userservice = userservice;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public   String getUpassword(){
		return upassword;
	}
	public void setUpassword(String upassword){
		this.upassword=upassword;
	}
	public String execute() throws Exception {
		User user = new User();			
		user.setUsername(username);		
		user.setPassword(upassword);
		if(userservice.iflogin(user)) {	
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession(); 
      		session.setAttribute("Name",userservice.getUser(username).getName());
      		ServletContext application = ServletActionContext.getServletContext();
      		Counter counter=new Counter();
      		int count =counter.readFile();
      		count++;
      		application.setAttribute("count",count);
      		counter.writeFile(count);
			return "success";
		}else {
			return "shibai";
		}
	}
	
}
