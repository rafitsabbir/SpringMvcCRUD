package springmvccrud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvccrud.dao.UserDao;
import springmvccrud.model.User;
import springmvccrud.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	UserDao userdao;
	
	
	@Autowired
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	public List<User> listAllUsers() {
		// TODO Auto-generated method stub
		return userdao.listAllUsers();
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userdao.addUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userdao.updateUser(user);
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userdao.deleteUser(id);

	}

	public User findUserbyId(int id) {
		// TODO Auto-generated method stub
		return userdao.findUserbyId(id);
	}

}
