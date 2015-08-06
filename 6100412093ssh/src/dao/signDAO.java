package dao;

import java.util.List;

import po.Sign;

public interface signDAO {
	public void addSign(Sign sign);
	public Sign getSign(String username);
	public void updatesign(Sign sign);
	public List<Sign> findALLSign();
	public void deletesign(String username);
}
