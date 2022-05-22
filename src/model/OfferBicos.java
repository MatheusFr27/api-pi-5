package model;

import java.sql.Timestamp;

public class OfferBicos {

	private int id_post_bicos;
	private int id_user;
	private String description;
	private double price;
	private String status;
	private Timestamp created_at;
	private Timestamp updated_at;

	public int getId_post_bicos() {
		return id_post_bicos;
	}

	public void setId_post_bicos(int id_post_bicos) {
		this.id_post_bicos = id_post_bicos;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

}
