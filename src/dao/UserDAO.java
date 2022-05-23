package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConexaoFactory;
import helper.Hash;
import model.User;

public class UserDAO {
	private Connection conexao;

	public UserDAO() {
		this.conexao = new ConexaoFactory().getConexao();
	}

	public Object initialize() {

		String sql = "SELECT * FROM user";

		List<User> listUser = new ArrayList<>();

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setType(rs.getString("type"));
				user.setStatus(rs.getString("status"));

				listUser.add(user);
			}
			ps.close();

			return listUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	public User findById(int id) {

		String sql = "SELECT id, name, email, phone, type, status FROM user WHERE id = ?";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			rs.next();

			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone"));
			user.setType(rs.getString("type"));
			user.setStatus(rs.getString("status"));

			ps.close();

			return user;

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}

	}

	public String store(User user) {

		String sql = "INSERT INTO user (name, email, phone, password, type, status) VALUES (?,?,?,?,?,?)";

		try {
			Hash hash = new Hash();
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, hash.encript(user.getPassword()));
			ps.setString(5, user.getType());
			ps.setString(6, "A");

			ps.execute();
			ps.close();

			return "true";

		} catch (SQLException e) {
			e.printStackTrace();

			String messageError = "message_error: " + e.getMessage() + ", type_error_sql: " + e.getErrorCode();

			return messageError;
		}

	}

	public String update(User user) {

		String sql = "UPDATE user SET name = ?, email = ?, phone = ?, type = ?, status = ? WHERE id = ?";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getType());
			ps.setString(5, user.getStatus());
			ps.setInt(6, user.getId());

			ps.execute();
			ps.close();

			return "true";

		} catch (SQLException e) {
			e.printStackTrace();

			String messageError = "message_error: " + e.getMessage() + ", type_error_sql: " + e.getErrorCode();

			return messageError;
		}

	}

	public String delete(int id) {

		String sql = "DELETE FROM user WHERE id = ?";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, id);

			ps.execute();
			ps.close();

			return "true";

		} catch (SQLException e) {
			e.printStackTrace();

			String messageError = "message_error: " + e.getMessage() + ", type_error_sql: " + e.getErrorCode();

			return messageError;
		}

	}

}
