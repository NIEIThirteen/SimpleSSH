package service;
import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import dao.signDAO;
import po.Sign;
public class signServiceImpl implements signService{
	private signDAO signDAO;
	private PlatformTransactionManager transactionManager;
	public signDAO getSignDAO() {
		return signDAO;
	}
	public void setSignDAO(signDAO signDAO) {
		this.signDAO = signDAO;
	}
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	@Override
	public boolean addSign(Sign sign) {
		signDAO.addSign(sign);
		return true;
	}
	@Override
	public boolean updateSign(Sign sign) {
		signDAO.updatesign(sign);
		return true;
	}
	@Override
	public Sign getSign(String username) {
		Sign sign=signDAO.getSign(username);
		return sign;
	}
	@Override
	public List<Sign> findAllSign() {
		
		List<Sign> signlist=signDAO.findALLSign();
		
		return signlist;
	}

}
