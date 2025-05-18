package org.datasource.jpa.views.produse;

import org.datasource.jpa.JPADataSourceConnector;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
@Service
public class ProduseViewBuilder {
	private static Logger logger = Logger.getLogger(ProduseViewBuilder.class.getName());

	protected String JPQL_PRODUCTS_SELECT =
			"SELECT NEW org.datasource.jpa.views.product.ProductView("
			+ "p.productCode, p.basePrice, p.prodCategory, p.prodName) "
			+ "FROM ProductView p";

	protected List<ProduseView> produseViewList = new ArrayList<>();

	public List<ProduseView> getProduseViewList() {
		return produseViewList;
	}

	public ProduseViewBuilder build(){
		return this.select();
	}

	protected ProduseViewBuilder select(){
		EntityManager em = dataSourceConnector.getEntityManager();
		//Query viewQuery = em.createQuery(JPQL_PRODUCTS_SELECT);
		Query viewQuery = em.createNamedQuery("ProduseView.findAll");
		this.produseViewList = viewQuery.getResultList();

		return this;
	}

	//
	protected JPADataSourceConnector dataSourceConnector;

	public ProduseViewBuilder(JPADataSourceConnector dataSourceConnector) {
		super();
		this.dataSourceConnector = dataSourceConnector;
	}
	
}