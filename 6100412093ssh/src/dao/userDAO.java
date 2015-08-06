package dao;

import java.util.List;

import po.User;

public interface userDAO {
	public void addUser(User user);//����û�
	public User getUser(String username);//�����û�����ѯ
	public void updateUser(User user);//�޸����� ���ǹ����ò���
	public List<User> findALLUser();//��ȡ�����û���Ϣ
	public void deleteUser(String username);//ɾ��
	public User getUserByName(String name);
}
