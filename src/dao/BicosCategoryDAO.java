package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConexaoFactory;
import model.BicosCategory;
import model.User;

public class BicosCategoryDAO {

	private Connection conexao;

	public BicosCategoryDAO() {
		this.conexao = new ConexaoFactory().getConexao();
	}

	public Object initialize() {

		String sql = "SELECT * FROM bicos_category";

		List<BicosCategory> listBicosCategory = new ArrayList<>();

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BicosCategory bc = new BicosCategory();
				bc.setId(rs.getInt("id"));
				bc.setDescription(rs.getString("description"));

				String created_at = String.valueOf(rs.getTimestamp("created_at"));
				String updated_at = String.valueOf(rs.getTimestamp("updated_at"));

				bc.setCreated_at(created_at);
				bc.setUpdated_at(updated_at);

				listBicosCategory.add(bc);
			}

			ps.close();

			return listBicosCategory;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	public BicosCategory findById(int id) {

		String sql = "SELECT id, description, created_at, updated_at FROM bicos_category WHERE id = ?";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			rs.next();

			BicosCategory bc = new BicosCategory();
			bc.setId(rs.getInt("id"));
			bc.setDescription(rs.getString("description"));

			String created_at = String.valueOf(rs.getTimestamp("created_at"));
			String updated_at = String.valueOf(rs.getTimestamp("updated_at"));

			bc.setCreated_at(created_at);
			bc.setUpdated_at(updated_at);

			ps.close();

			return bc;

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}

	}

	public String store(BicosCategory bc) {

		String sql = "INSERT INTO bicos_category (description) VALUES (?)";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, bc.getDescription());

			ps.execute();
			ps.close();

			return "true";

		} catch (SQLException e) {
			e.printStackTrace();

			String messageError = "message_error: " + e.getMessage() + ", type_error_sql: " + e.getErrorCode();

			return messageError;
		}

	}

	public String update(BicosCategory bc) {

		String sql = "UPDATE bicos_category SET description = ? WHERE id = ?";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setString(1, bc.getDescription());
			ps.setInt(2, bc.getId());

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

		String sql = "DELETE FROM bicos_category WHERE id = ?";

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
