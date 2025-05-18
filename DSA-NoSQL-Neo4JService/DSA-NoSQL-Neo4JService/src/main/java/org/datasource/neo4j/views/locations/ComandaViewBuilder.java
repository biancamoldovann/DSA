package org.datasource.neo4j.views.locations;

import org.datasource.neo4j.Neo4JDataSourceConnector;
import org.neo4j.ogm.session.Session;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ComandaViewBuilder {
	private static Logger logger = Logger.getLogger(ComandaViewBuilder.class.getName());
	// Data cache
	private List<DetaliiComandaView> detaliiComandaViewList;
	private List<ComandaView> comandaViewList;

	public List<DetaliiComandaView> getDetaliiComandaViewList() {
		return detaliiComandaViewList;
	}
	public List<ComandaView> getComandaViewList() {
		return comandaViewList;
	}
	//
	private Neo4JDataSourceConnector dataSourceConnector;
	
	
	public ComandaViewBuilder(Neo4JDataSourceConnector dataSourceConnector) {
		this.dataSourceConnector = dataSourceConnector;
	}

	// Builder Workflow
	public ComandaViewBuilder build() throws Exception{
		return this.select();
	}

//	private ComandaViewBuilder map() {}
	
	public ComandaViewBuilder select() throws Exception {
		Session session = dataSourceConnector.getNeo4JSession();
		logger.info(">>> Building DepartamentView ... session open!");
		try{
			logger.info(">>> Building DepartamentView ... query RegionsView!");
			this.comandaViewList = new ArrayList<>(session.loadAll(ComandaView.class));
			logger.info(">>> Building DepartamentView ... query DepartamentView!");
			this.detaliiComandaViewList = new ArrayList<>(session.loadAll(DetaliiComandaView.class));
			//
			session.clear();
		} catch (Exception e) {
			session.clear();
			throw new RuntimeException(e);
		}
		return this;
	}
}
