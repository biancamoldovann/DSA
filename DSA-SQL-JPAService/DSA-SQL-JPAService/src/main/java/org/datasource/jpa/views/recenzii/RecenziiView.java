package org.datasource.jpa.views.recenzii;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.datasource.jpa.views.recenzii.RecenziiView;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the RecenziiS database table.
 * 
 */
@SqlResultSetMapping(
		name = "RecenziiViewMapping",
		classes = {
				@ConstructorResult(
						columns = {
								@ColumnResult(name = "Id", type = Integer.class),
								@ColumnResult(name = "rating", type = Integer.class),
								@ColumnResult(name = "data", type = String.class),
						},
						targetClass = RecenziiView.class
				)
		}
)
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity @Table(name="Recenzii")
@NamedQuery(name="RecenziiView.findAll", query="SELECT p FROM RecenziiView p")
public class RecenziiView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private Integer Id;

	@Column(name="rating")
	private Integer rating;

	@Column(name="data")
	private String data;

}