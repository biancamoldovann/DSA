package org.datasource.jpa.views.produse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.datasource.jpa.views.recenzii.RecenziiView;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the ProduseS database table.
 * 
 */
@SqlResultSetMapping(
		name = "SalesViewMapping",
		classes = {
				@ConstructorResult(
						columns = {
								@ColumnResult(name = "Id", type = Integer.class),
								@ColumnResult(name = "nume", type = String.class),
								@ColumnResult(name = "pret", type = Double.class),
								@ColumnResult(name = "stoc", type = Integer.class)
						},
						targetClass = RecenziiView.class
				)
		}
)
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity @Table(name="Produse")
@NamedQuery(name="ProduseView.findAll", query="SELECT p FROM ProduseView p")
public class ProduseView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private Integer Id;

	@Column(name="nume")
	private String nume;

	@Column(name="pret")
	private Double pret;

	@Column(name="stoc")
	private Integer stoc;
}