package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConexaoFactory;
import model.UserHasBicosCategory;

public class UserHasBicosCategoryDAO {

	private Connection conexao;

	public UserHasBicosCategoryDAO() {
		this.conexao = new ConexaoFactory().getConexao();
	}

	public Object initialize() {

		String sql = "SELECT * FROM user_has_bicos_category";

		List<UserHasBicosCategory> listUserHasBicosCategory = new ArrayList<>();

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserHasBicosCategory userHasBicosCategory = new UserHasBicosCategory();
				userHasBicosCategory.setId_bicos_category(rs.getInt("id_bicos_category"));
				userHasBicosCategory.setId_user(rs.getInt("id_user"));

				listUserHasBicosCategory.add(userHasBicosCategory);
			}
			ps.close();

			return listUserHasBicosCategory;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	public Object findByIdUser(int id) {

		String sql = "SELECT * FROM user_has_bicos_category WHERE id_user = ?";

		List<UserHasBicosCategory> listUserHasBicosCategory = new ArrayList<>();

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserHasBicosCategory userHasBicosCategory = new UserHasBicosCategory();
				userHasBicosCategory.setId_bicos_category(rs.getInt("id_bicos_category"));
				userHasBicosCategory.setId_user(rs.getInt("id_user"));

				listUserHasBicosCategory.add(userHasBicosCategory);
			}
			ps.close();

			return listUserHasBicosCategory;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	public UserHasBicosCategory findById(int id) {

		// String sql = "SELECT id_bicos_category, id_user FROM user_has_bicos_category
		// WHERE id_user = ?";
		//
		// try {
		// PreparedStatement ps = this.conexao.prepareStatement(sql);
		// ps.setInt(1, id);
		//
		// ResultSet rs = ps.executeQuery();
		// rs.next();
		//
		// User user = new User();
		// user.setId(rs.getInt("id"));
		// user.setName(rs.getString("name"));
		// user.setEmail(rs.getString("email"));
		// user.setPhone(rs.getString("phone"));
		//
		// ps.close();
		//
		// return user;
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		//
		// return null;
		// }

		return null;
	}

	public String store(UserHasBicosCategory userHasBicosCategory) {

		String sql = "INSERT INTO user_has_bicos_category (id_user, id_bicos_category) VALUES (?,?)";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, userHasBicosCategory.getId_user());
			ps.setInt(2, userHasBicosCategory.getId_bicos_category());

			ps.execute();
			ps.close();

			return "true";

		} catch (SQLException e) {
			e.printStackTrace();

			String messageError = "message_error: " + e.getMessage() + ", type_error_sql: " + e.getErrorCode();

			return messageError;
		}

	}

	public String update(UserHasBicosCategory userHasBicosCategory) {

		// String sql = "UPDATE user SET name = ?, email = ?, phone = ?, type = ? WHERE
		// id = ?";
		//
		// try {
		// PreparedStatement ps = this.conexao.prepareStatement(sql);
		// ps.setString(1, user.getName());
		// ps.setString(2, user.getEmail());
		// ps.setString(3, user.getPhone());
		// ps.setString(4, user.getType());
		// ps.setInt(5, user.getId());
		//
		// ps.execute();
		// ps.close();
		//
		// return "true";
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		//
		// String messageError = "message_error: " + e.getMessage() + ", type_error_sql:
		// " + e.getErrorCode();
		//
		// return messageError;
		// }

		return null;

	}

	public String delete(int id) {

		// String sql = "DELETE FROM user_has_bicos_category WHERE id_user = ? AND
		// id_user = ?";
		//
		// try {
		// PreparedStatement ps = this.conexao.prepareStatement(sql);
		// ps.setInt(1, id);
		//
		// ps.execute();
		// ps.close();
		//
		// return "true";
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		//
		// String messageError = "message_error: " + e.getMessage() + ", type_error_sql:
		// " + e.getErrorCode();
		//
		// return messageError;
		// }

		return null;

	}

	public String deleteRelationships(int idUser, int idBicosCategory) {

		String sql = "DELETE FROM user_has_bicos_category WHERE id_user = ? AND id_bicos_category = ?";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, idUser);
			ps.setInt(2, idBicosCategory);

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
