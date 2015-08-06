package service;
import po.Class;
import java.util.List;
public interface classService {
	public boolean addClass(Class clazz);
	public List<Class> findAllClass();
	public void delete(int classid);
}
