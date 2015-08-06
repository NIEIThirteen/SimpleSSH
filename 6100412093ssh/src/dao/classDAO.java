package dao;

import java.util.List;
import po.Class;
public interface classDAO {
	public void addClass(Class classs);//添加班级
	public Class getClass(int classid);//按照班级编号查询
	public void updateClass(Class classs);//修改班级信息
	public List<Class> findALLClass();//获取所有班级信息
	public void deleteClass(int classid);//删除班级
}
