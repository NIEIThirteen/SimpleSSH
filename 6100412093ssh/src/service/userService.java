package service;
import po.User;
import java.util.List;
public interface userService {
	public boolean addUser(User user);
	public boolean iflogin(User user);
	public User getUser(String username);
	public List<User> findAllUser();
	public void updateUser(User user);
	public User getUserByName(String name);
}
