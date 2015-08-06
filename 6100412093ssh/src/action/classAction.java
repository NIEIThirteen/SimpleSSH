package action;
import com.opensymphony.xwork2.ActionSupport;

import util.Stime;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import po.Class;
import po.Sign;
import service.classService;
public class classAction {
	private classService classService;
	private int classid;
	private String classname;
	public classService getClassService() {
		return classService;
	}
	public void setClassService(classService classService) {
		this.classService = classService;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String findAllClass() throws Exception{
		
		return "findover";
	}
	public String showindex() throws Exception{
		List<Class> classlist = classService.findAllClass();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("classlist", classlist);
		return "clazzindex";
	}
	public String delete() throws Exception{
		classService.delete(classid);
		List<Class> classlist = classService.findAllClass();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("classlist", classlist);
		return "clazzdelete";
	}
	public String add() throws Exception{
		if(classid==0||classname==null||classname.equals("")){
			return "clazzadd";
		}else{
			Class clazz=new Class();
			clazz.setClassid(classid);
			clazz.setClassname(classname);
			classService.addClass(clazz);
			return "clazzadd";
		}
	}
}
