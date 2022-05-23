package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConexaoFactory;
import model.OfferBicos;
import model.PostBicos;

public class OfferBicosDAO {

	private Connection conexao;

	public OfferBicosDAO() {
		this.conexao = new ConexaoFactory().getConexao();
	}

	public Object initialize() {

		String sql = "SELECT * FROM offer_bicos";

		List<OfferBicos> listOfferBicos = new ArrayList<>();

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OfferBicos ob = new OfferBicos();
				ob.setId(rs.getInt("id"));
				ob.setId_post_bicos(rs.getInt("id_post_bicos"));
				ob.setId_user(rs.getInt("id_user"));
				ob.setDescription(rs.getString("description"));
				ob.setPrice(rs.getDouble("price"));
				ob.setStatus(rs.getString("status"));

				String created_at = String.valueOf(rs.getTimestamp("created_at"));
				String updated_at = String.valueOf(rs.getTimestamp("updated_at"));

				ob.setCreated_at(created_at);
				ob.setUpdated_at(updated_at);

				listOfferBicos.add(ob);
			}
			ps.close();

			return listOfferBicos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	public Object findById(int id) {

		String sql = "SELECT id, id_post_bicos, id_user, description, price, status, created_at, updated_at FROM offer_bicos WHERE id = ?";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			rs.next();

			OfferBicos ob = new OfferBicos();
			ob.setId(rs.getInt("id"));
			ob.setId_post_bicos(rs.getInt("id_post_bicos"));
			ob.setId_user(rs.getInt("id_user"));
			ob.setDescription(rs.getString("description"));
			ob.setPrice(rs.getDouble("price"));
			ob.setStatus(rs.getString("status"));

			String created_at = String.valueOf(rs.getTimestamp("created_at"));
			String updated_at = String.valueOf(rs.getTimestamp("updated_at"));

			ob.setCreated_at(created_at);
			ob.setUpdated_at(updated_at);

			ps.close();

			return ob;

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}

	}

	public Object findByIdPostBicos(int id) {
		String sql = "SELECT id_post_bicos, id_user, description, price, status, created_at, updated_at FROM offer_bicos WHERE id_post_bicos = ?";

		List<OfferBicos> listOfferBicos = new ArrayList<>();

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				OfferBicos ob = new OfferBicos();
				ob.setId_post_bicos(rs.getInt("id_post_bicos"));
				ob.setId_user(rs.getInt("id_user"));
				ob.setDescription(rs.getString("description"));
				ob.setPrice(rs.getDouble("price"));
				ob.setStatus(rs.getString("status"));

				String created_at = String.valueOf(rs.getTimestamp("created_at"));
				String updated_at = String.valueOf(rs.getTimestamp("updated_at"));

				ob.setCreated_at(created_at);
				ob.setUpdated_at(updated_at);

				listOfferBicos.add(ob);
			}
			ps.close();

			return listOfferBicos;

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}
	}

	public String store(OfferBicos ob) {

		String sql = "INSERT INTO offer_bicos (id_post_bicos, id_user, description, price, status) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, ob.getId_post_bicos());
			ps.setInt(2, ob.getId_user());
			ps.setString(3, ob.getDescription());
			ps.setDouble(4, ob.getPrice());
			ps.setString(5, "A");

			ps.execute();
			ps.close();

			return "true";

		} catch (SQLException e) {
			e.printStackTrace();

			String messageError = "message_error: " + e.getMessage() + ", type_error_sql: " + e.getErrorCode();

			return messageError;
		}

	}

	public String update(OfferBicos ob) {

		String sql = "UPDATE offer_bicos SET id_post_bicos = ?, id_user = ?, description = ?, price = ?, status = ? WHERE id = ?";

		try {
			PreparedStatement ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, ob.getId_post_bicos());
			ps.setInt(2, ob.getId_user());
			ps.setString(3, ob.getDescription());
			ps.setDouble(4, ob.getPrice());
			ps.setString(5, ob.getStatus());
			ps.setInt(6, ob.getId());

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

		String sql = "DELETE FROM offer_bicos WHERE id = ?";

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
