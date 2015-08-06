package service;
import po.Sign;
import java.util.List;
public interface signService {
	public boolean addSign(Sign sign);
	public boolean updateSign(Sign sign);
	public Sign getSign(String username);
	public List<Sign> findAllSign();
}
