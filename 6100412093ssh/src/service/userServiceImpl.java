package service;
import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import po.User;
import dao.userDAO;
public class userServiceImpl implements userService{
	private userDAO userDAO;
	private PlatformTransactionManager transactionManager;
	public userDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(userDAO userDAO) {
		this.userDAO = userDAO;
	}
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	@Override
	public boolean addUser(User user) {
		userDAO.addUser(user);
		return true;
	}
	@Override
	public boolean iflogin(User user) {
		User xuser=userDAO.getUser(user.getUsername());
		String suser=xuser.getPassword();
		String ssuser=user.getPassword();
		if(suser.equals(ssuser)){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public User getUser(String username) {
		User user=userDAO.getUser(username);
		return user;
	}
	@Override
	public List<User> findAllUser() {
		List<User> userl = userDAO.findALLUser();
		return userl;
	}
	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
		
	}
	@Override
	public User getUserByName(String name) {
		User user=userDAO.getUserByName(name);
		return user;
	}

}
