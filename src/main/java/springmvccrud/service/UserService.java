package springmvccrud.service;

import java.util.List;

import springmvccrud.model.User;

public interface UserService {
	public List<User> listAllUsers();

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);

	public User findUserbyId(int id);

}
