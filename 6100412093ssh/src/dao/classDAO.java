package dao;

import java.util.List;
import po.Class;
public interface classDAO {
	public void addClass(Class classs);//��Ӱ༶
	public Class getClass(int classid);//���հ༶��Ų�ѯ
	public void updateClass(Class classs);//�޸İ༶��Ϣ
	public List<Class> findALLClass();//��ȡ���а༶��Ϣ
	public void deleteClass(int classid);//ɾ���༶
}
