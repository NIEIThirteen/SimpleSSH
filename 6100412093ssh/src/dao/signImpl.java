package dao;

import hibernate.HibernateSessionFactory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import po.Sign;
import po.User;

public class signImpl extends HibernateDaoSupport implements signDAO{

	@Override
	public void addSign(Sign sign) {
		getHibernateTemplate().save(sign);
	}

	@Override
	public Sign getSign(String username) {
		
		String hql = "from Sign as u " +
				"where u.username=?";
		List<Sign> sign = getHibernateTemplate().find(hql,username);
		
		if(sign.size() > 0) {
			return sign.get(0);
		}else {
			return null;
		}
	}

	@Override
	public void updatesign(Sign sign) {
		getHibernateTemplate().update(sign);
		
	}

	@Override
	public List<Sign> findALLSign() {
		String hql = "from Sign";						
		List<Sign> Signl = getHibernateTemplate().find(hql);
		return Signl;
	}

	@Override
	public void deletesign(String username) {
		Sign user=getSign(username);
		getHibernateTemplate().delete(user);
		
	}

}
