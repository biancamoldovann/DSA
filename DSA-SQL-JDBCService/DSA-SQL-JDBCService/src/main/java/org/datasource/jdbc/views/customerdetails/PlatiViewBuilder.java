package org.datasource.jdbc.views.customerdetails;

import org.datasource.jdbc.JDBCDataSourceConnector;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlatiViewBuilder {
	// SQL Map
	private String SQL_CUSTOMERS_DETAILS_SELECT =
			"SELECT id, metoda, suma, data_plata FROM plati";

	// DataCache
	private List<PlatiView> platiViewList = new ArrayList<>();

	public List<PlatiView> getViewList() {
		// building workflow
		// this.build().filter().getViewList();
		return this.platiViewList;
	}

	// building steps
	public PlatiViewBuilder build() {
		try (Connection jdbcConnection = jdbcConnector.getConnection()) {
			// extract data
			Statement selectStmt = jdbcConnection.createStatement();
			ResultSet rs = selectStmt.executeQuery(SQL_CUSTOMERS_DETAILS_SELECT);

			// map data to EntityView
			platiViewList = new ArrayList<>();
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String metoda = rs.getString("metoda");
				Double suma = rs.getDouble("suma");
				String data_plata = rs.getString("data_plata");
				this.platiViewList.add(new PlatiView(id, metoda, suma,
						data_plata));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return this;
	}

	/* JDBC Session Management ---------------------------------------- */
	private JDBCDataSourceConnector jdbcConnector;
	public PlatiViewBuilder(JDBCDataSourceConnector jdbcConnector) {
		this.jdbcConnector = jdbcConnector;
	}
}
