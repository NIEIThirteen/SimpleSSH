package action;
import com.opensymphony.xwork2.ActionSupport;

import util.Stime;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import service.classService;
import po.Sign;
import po.Class;
import po.User;
import service.signService;
import service.userService;
public class signAction {
	private String username;
	private String name;
	private String date;
	private String timein;
	private String timeout;
	private signService signservice;
	private classService classservice;
	private userService userservice;
	public signService getSignservice() {
		return signservice;
	}
	public void setSignservice(signService signservice) {
		this.signservice = signservice;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimein() {
		return timein;
	}
	public void setTimein(String timein) {
		this.timein = timein;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	public String  timein() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		String s=(String) session.getAttribute("Name");
		List<Sign> signlist = signservice.findAllSign();
		Sign sign = new Sign();
		for(int i=0;i<signlist.size();i++){
			if(signlist.get(i).getName().equals(s)){
				sign=signlist.get(i);
			}
		}
		
		if(sign.getUsername().equals(null)||sign.getUsername().equals("")){
			return "infalse";
		}else{
			Stime time=new Stime();
			sign.setDate(time.getDate());
			sign.setTimein(time.gettime());
			sign.setTimeout("");
			signservice.updateSign(sign);
			 return "successin";
		}
	}
	public String  timeout() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(); 
		String s=(String) session.getAttribute("Name");
		
		List<Sign> signlist = signservice.findAllSign();
		Sign sign = new Sign();
		for(int i=0;i<signlist.size();i++){
			if(signlist.get(i).getName().equals(s)){
				sign=signlist.get(i);
			}
		}
		if(sign.getUsername().equals(null)||sign.getUsername().equals("")){
			return "outfalse";
		}else{
			if(sign.getTimein().equals(null)||sign.equals("")){
				return "outfalse";
			}else{
				Stime time=new Stime();
				sign.setTimeout(time.gettime());
				signservice.updateSign(sign);
				return "successout";
			}
		}
	}
	public String indexshow() throws Exception{
		List<Sign> signlists = signservice.findAllSign();
		HttpServletRequest request=ServletActionContext.getRequest();
		List<Class> classlists = classservice.findAllClass();
		List<User>  userlists = userservice.findAllUser();
		request.setAttribute("signlists", signlists);
		request.setAttribute("classlists", classlists);
		request.setAttribute("userlists", userlists);
		return "showindex";
	}
	public classService getClassservice() {
		return classservice;
	}
	public void setClassservice(classService classservice) {
		this.classservice = classservice;
	}
	public userService getUserservice() {
		return userservice;
	}
	public void setUserservice(userService userservice) {
		this.userservice = userservice;
	}
	
}
