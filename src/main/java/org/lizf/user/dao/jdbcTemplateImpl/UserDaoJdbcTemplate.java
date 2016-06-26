package org.lizf.user.dao.jdbcTemplateImpl;

import java.sql.Types;

import org.lizf.user.dao.UserDao;
import org.lizf.user.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoJdbcTemplate implements UserDao {

	private JdbcTemplate jdbcTemplate;
	private RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setRowMapper(RowMapper<User> rowMapper) {
		this.rowMapper = rowMapper;
	}

	@Override
	public User login(String username, String password) {
		String sql = "select * from t_user where username = ? and password = ?";
		String[] params = new String[] { username, password };
		return jdbcTemplate.queryForObject(sql, params, rowMapper);
	}

	@Override
	public User findUserById(String id) {
		String sql = "select * from t_user where id = ? ";
		String[] params = new String[] { id };
		return jdbcTemplate.queryForObject(sql, params, rowMapper);
	}

	@Override
	public boolean changePassword(User user) {
		String sql = "update t_user set password = ? where id = ?";
		String[] params = new String[] { user.getUsername(), user.getPassword() };
		int[] paramTypes = new int[] { Types.VARCHAR, Types.VARCHAR };
		jdbcTemplate.update(sql, params, paramTypes);
		return true;
	}

	@Override
	public boolean removeUserById(String id) {
		String sql = "delete t_user where id = ?";
		String[] params = new String[] { id };
		int[] paramTypes = new int[] { Types.INTEGER };
		jdbcTemplate.update(sql, params, paramTypes);
		return true;
	}

}
