package org.datasource.neo4j.views.locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.datasource.neo4j.convertors.LocalDateConverter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import java.io.Serializable;
import java.time.LocalDate;
import org.datasource.neo4j.convertors.LocalDateConverter;
@NodeEntity( label = "Comanda")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ComandaView implements Serializable{
	@Id
	private Integer id;

	@Convert(LocalDateConverter.class)
	private LocalDate data_comanda;
	private String produse;
}

