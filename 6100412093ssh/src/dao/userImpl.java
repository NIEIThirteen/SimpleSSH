package dao;

import hibernate.HibernateSessionFactory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.User;

public class userImpl extends HibernateDaoSupport implements userDAO{

	@Override
	public void addUser(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public User getUser(String username) {
		String hql = "from User as u " +
				"where u.username=?";
		List<User> user = getHibernateTemplate().find(hql,username);
		if(user.size() > 0) {
			return user.get(0);
		}else {
			return null;
		}
	}

	@Override
	public void updateUser(User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public List<User> findALLUser() {
		String hql = "from User";						
		List<User> user = getHibernateTemplate().find(hql);
		return user;
	}

	@Override
	public void deleteUser(String username) {
		User user=getUser(username);
		getHibernateTemplate().delete(user);
		
	}

	@Override
	public User getUserByName(String name) {
		String hql = "from User as u " +
				"where u.name=?";
		List<User> userl = getHibernateTemplate().find(hql,name);
		if(userl.size() > 0) {
			return userl.get(0);
		}else {
			return null;
		}
	}

}
