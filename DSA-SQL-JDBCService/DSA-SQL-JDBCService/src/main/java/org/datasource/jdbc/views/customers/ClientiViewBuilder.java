package org.datasource.jdbc.views.customers;

import org.datasource.jdbc.JDBCDataSourceConnector;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientiViewBuilder {
	// SQL Map
	private String SQL_CUSTOMERS_SELECT = "SELECT id, nume, email, telefon, adresa FROM clienti";

	// DataCache
	private List<ClientiView> customersViewList = new ArrayList<>();

	public List<ClientiView> getViewList() {
		// building workflow
		// this.build().filter().getViewList();
		return this.customersViewList;
	}

	// building steps
	public ClientiViewBuilder build() {
		try (Connection jdbcConnection = jdbcConnector.getConnection()) {
			// extract data
			Statement selectStmt = jdbcConnection.createStatement();
			ResultSet rs = selectStmt.executeQuery(SQL_CUSTOMERS_SELECT);

			// map data to EntityView
			customersViewList = new ArrayList<>();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nume = rs.getString("nume");
				String email = rs.getString("email").trim();
				String telefon = rs.getString ("telefon");
				String adresa = rs.getString ("adresa");
				this.customersViewList.add(new ClientiView(id, nume, email, telefon, adresa));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return this;
	}

	/* JDBC Session Management ---------------------------------------- */
	private JDBCDataSourceConnector jdbcConnector;

	public ClientiViewBuilder(JDBCDataSourceConnector jdbcConnector) {
		this.jdbcConnector = jdbcConnector;
	}
}
