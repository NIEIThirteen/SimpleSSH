package service;
import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import dao.classDAO;
import po.Class;

public class classServiceImpl implements classService{
	private classDAO classDAO;
	private PlatformTransactionManager transactionManager;
	public classDAO getClassDAO() {
		return classDAO;
	}
	public void setClassDAO(classDAO classDAO) {
		this.classDAO = classDAO;
	}
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	@Override
	public boolean addClass(Class clazz) {
		classDAO.addClass(clazz);
		return true;
	}
	@Override
	public List<Class> findAllClass() {
		List<Class> clazzlist=classDAO.findALLClass();
		
		return clazzlist;
	}
	@Override
	public void delete(int classid) {
		classDAO.deleteClass(classid);
		
	}

}
