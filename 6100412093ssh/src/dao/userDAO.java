package dao;

import java.util.List;

import po.User;

public interface userDAO {
	public void addUser(User user);//添加用户
	public User getUser(String username);//按照用户名查询
	public void updateUser(User user);//修改密码 但是估计用不上
	public List<User> findALLUser();//获取所有用户信息
	public void deleteUser(String username);//删除
	public User getUserByName(String name);
}
