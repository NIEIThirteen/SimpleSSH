package action;
import com.opensymphony.xwork2.ActionSupport;

import util.Stime;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import service.classService;
import po.Sign;
import po.Class;
import po.User;
import util.Stime;
import service.signService;
import service.userService;
public class userAction {
	private String username;
	private String password;
	private String upassword;
	private String name;
	private int classid;
	private String time;
	private String ems;
	private String sex;
	private String classname;
	private signService signservice;
	private classService classservice;
	private userService userservice;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEms() {
		return ems;
	}
	public void setEms(String ems) {
		this.ems = ems;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public signService getSignservice() {
		return signservice;
	}
	public void setSignservice(signService signservice) {
		this.signservice = signservice;
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
	public String studentindex() throws Exception{
		List<User> userlist = userservice.findAllUser();
		List<Class> classlist = classservice.findAllClass();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("classlist1", classlist);
		request.setAttribute("userlist1", userlist);
		return "studentindex";
	}
	public String view() throws Exception{
		User user= new User();
		user.setUsername(username);
		user= userservice.getUser(user.getUsername());
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("userview", user);
		return "studentview";
	}
	public String update() throws Exception{
		User user=new User();
		user.setUsername(username);
		user= userservice.getUser(username);
		user.setPassword(password);
		user.setSex(sex);
		userservice.updateUser(user);
		return "studentupdate";
	}
	public String register() throws Exception{
		List<Class> classlist = classservice.findAllClass();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("registerclasslist", classlist);
		return "registerpage";
	}
	public String registerConf() throws Exception{
		User user = new User();
		Stime time=new Stime();
		List<Class> classlist =classservice.findAllClass();
		String classnamee= classname;
		int id =0;
		for(int i=0;i<classlist.size();i++){
			if(classnamee.equals(classlist.get(i).getClassname())){
				id=classlist.get(i).getClassid();
			}
		}
		String u=upassword;
		
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setClassid(id);
		user.setTime(time.getCurrentTime());
		user.setEms(null);
		
		if(!u.equals(user.getPassword())){
			return "registerfalse";
			
		}
		else{
			Sign sign = new Sign();
			sign.setUsername(user.getUsername());
			sign.setName(user.getName());
			sign.setDate(null);
			sign.setTimein(null);
			sign.setTimeout(null);
			signservice.addSign(sign);
			userservice.addUser(user);
			
			return "registersuccess";
		}
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
}
