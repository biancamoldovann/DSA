package org.datasource.jdbc.views.customers;

import lombok.Value;

@Value
public class ClientiView {
	private Integer Id;
	private String nume;
	private String email;
	private String telefon;
	private String adresa;
}
