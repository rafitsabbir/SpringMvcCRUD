package springmvccrud.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvccrud.dao.UserDao;
import springmvccrud.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	final String listallusers = "SELECT id, firstname, lastname, address FROM users";
	final String adduser = "INSERT INTO users (firstname, lastname,address) values(:firstname,:lastname,:address)";
	final String updateuser = "UPDATE  users set firstname= :firstname, lastname= :lastname,address= :address WHERE id=:id";
	final String deleteuser = "DELETE FROM users where id=:id";
	final String finduserbyid = "SELECT id, firstname, lastname, address FROM users where id=:id";




	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
			throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<User> listAllUsers() {
		// TODO Auto-generated method stub
		List<User> list = namedParameterJdbcTemplate.query(listallusers, getSqlParameterByModel(null), new UserMapper());
		return null;
	}

	private SqlParameterSource getSqlParameterByModel(User user) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if(user != null) {
			paramSource.addValue("id", user.getId());
			paramSource.addValue("firstname", user.getFirstname());
			paramSource.addValue("lastname", user.getLastname());
			paramSource.addValue("address", user.getAddress());
		}
		return paramSource;
	}

	private static final class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setAddress(rs.getString("address"));
			return user;
		}
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		namedParameterJdbcTemplate.update(adduser, getSqlParameterByModel(user));

	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		namedParameterJdbcTemplate.update(updateuser, getSqlParameterByModel(user));

	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		namedParameterJdbcTemplate.update(deleteuser, getSqlParameterByModel(new User(id)));

	}

	public User findUserbyId(int id) {
		// TODO Auto-generated method stub
		return namedParameterJdbcTemplate.queryForObject(finduserbyid, getSqlParameterByModel(new User(id)), new UserMapper());
	}

}
