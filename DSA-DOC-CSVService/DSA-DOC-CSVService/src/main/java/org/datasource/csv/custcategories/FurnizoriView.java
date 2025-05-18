package org.datasource.csv.custcategories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor(force = true)
public class FurnizoriView {
	private Integer id;
	private String nume;
	private String email;
	private String telefon;
}
