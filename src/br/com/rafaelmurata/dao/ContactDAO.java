package br.com.rafaelmurata.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.rafaelmurata.model.Contact;
import br.com.rafaelmurata.service.ConnectionFactory;

public class ContactDAO {

	private java.sql.Connection connection;

	public ContactDAO() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void add(Contact contact) {
		String sql = "insert into contacts (name,email,adress,dateOfBirth) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAdress());
			stmt.setDate(4, new Date(contact.getDateOfBirth().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contact> getList() {
		try {
			List<Contact> ct = new ArrayList<Contact>();
			PreparedStatement st = this.connection.prepareStatement("select * from contacts");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getLong("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAdress(rs.getString("adress"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dateOfBirth"));
				contact.setDateOfBirth(data);
				ct.add(contact);
			}
			rs.close();
			st.close();

			return ct;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void change(Contact contact){
		String sql = "update contacts set name=?,email=?,adress=?,dateOfBirth=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getAdress());
			stmt.setDate(4, new Date(contact.getDateOfBirth().getTimeInMillis()));
			stmt.setLong(5, contact.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void remove(Long id){
		String sql = "delete from contacts where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1,id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
