package org.datasource.neo4j.views.locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NodeEntity( label = "DetaliiComanda")
@Data @AllArgsConstructor @NoArgsConstructor(force = true)
public class DetaliiComandaView implements Serializable{
	@Id
	private Integer id;
	private Integer cantitate;
	private Double pretUnitar;
}


