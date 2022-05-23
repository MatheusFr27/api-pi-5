package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConexaoFactory;
import model.PostBicos;

public class PostBicosDAO {

	private Connection conexao;

	public PostBicosDAO() {
		this.conexao = new ConexaoFactory().getConexao();
	}

	public Object initialize() {

		String sql = "SELECT * FROM post_bicos";

		List<PostBicos> listPostBicos = new ArrayList<>();

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PostBicos pb = new PostBicos();
				pb.setId(rs.getInt("id"));
				pb.setId_user(rs.getInt("id_user"));
				pb.setTitle(rs.getString("title"));
				pb.setDescription(rs.getString("description"));

				String created_at = String.valueOf(rs.getTimestamp("created_at"));
				String updated_at = String.valueOf(rs.getTimestamp("updated_at"));

				pb.setCreated_at(created_at);
				pb.setUpdated_at(updated_at);

				listPostBicos.add(pb);
			}
			ps.close();

			return listPostBicos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	public PostBicos findById(int id) {

		String sql = "SELECT id, id_user, title, description, created_at, updated_at FROM post_bicos WHERE id = ?";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			rs.next();

			PostBicos pb = new PostBicos();
			pb.setId(rs.getInt("id"));
			pb.setId_user(rs.getInt("id_user"));
			pb.setTitle(rs.getString("title"));
			pb.setDescription(rs.getString("description"));

			String created_at = String.valueOf(rs.getTimestamp("created_at"));
			String updated_at = String.valueOf(rs.getTimestamp("updated_at"));

			pb.setCreated_at(created_at);
			pb.setUpdated_at(updated_at);

			ps.close();

			return pb;

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}

	}

	public String store(PostBicos pb) {

		String sql = "INSERT INTO post_bicos (id_user, title, description) VALUES (?,?,?)";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, pb.getId_user());
			ps.setString(2, pb.getTitle());
			ps.setString(3, pb.getDescription());

			ps.execute();
			ps.close();

			return "true";

		} catch (SQLException e) {
			e.printStackTrace();

			String messageError = "message_error: " + e.getMessage() + ", type_error_sql: " + e.getErrorCode();

			return messageError;
		}

	}

	public String update(PostBicos pb) {

		String sql = "UPDATE post_bicos SET id_user = ?, title = ?, description = ? WHERE id = ?";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, pb.getId_user());
			ps.setString(2, pb.getTitle());
			ps.setString(3, pb.getDescription());
			ps.setInt(4, pb.getId());

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

		String sql = "DELETE FROM post_bicos WHERE id = ?";

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
