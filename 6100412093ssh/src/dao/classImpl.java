package dao;

import java.util.List;

import po.Class;
import po.Sign;
import po.User;
import hibernate.HibernateSessionFactory;







import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import hibernate.HibernateSessionFactory;

public class classImpl extends HibernateDaoSupport implements classDAO{

	@Override
	public void addClass(Class classs) {
		getHibernateTemplate().save(classs);
	}

	@Override
	public Class getClass(int classid) {
		String hql = "from Class as u " +
				"where u.classid=?";
		List<Class> clazz = getHibernateTemplate().find(hql,classid);
		if(clazz.size() > 0) {
			return clazz.get(0);
		}else {
			return null;
		}
	}

	@Override
	public void updateClass(Class classs) {
		getHibernateTemplate().update(classs);
	}

	@Override
	public List<Class> findALLClass() {
		String hql = "from Class";						
		List<Class> clazz = getHibernateTemplate().find(hql);
		return clazz;
	}

	@Override
	public void deleteClass(int classid) {
		Class user=getClass(classid);
		getHibernateTemplate().delete(user);
	}

}
