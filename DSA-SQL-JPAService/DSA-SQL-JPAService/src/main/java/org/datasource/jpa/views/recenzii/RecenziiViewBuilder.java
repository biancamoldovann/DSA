package org.datasource.jpa.views.recenzii;

import lombok.Getter;
import org.datasource.jpa.JPADataSourceConnector;
import org.datasource.jpa.views.recenzii.RecenziiView;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
@Service
public class RecenziiViewBuilder {
	private static Logger logger = Logger.getLogger(RecenziiViewBuilder.class.getName());

	protected String JPQL_PRODUCTS_SELECT =
			"SELECT NEW org.datasource.jpa.views.product.ProductView("
			+ "p.productCode, p.basePrice, p.prodCategory, p.prodName) "
			+ "FROM ProductView p";

	@Getter
	protected List<RecenziiView> recenziiViewList = new ArrayList<>();

	public RecenziiViewBuilder build(){
		return this.select();
	}

	protected RecenziiViewBuilder select(){
		EntityManager em = dataSourceConnector.getEntityManager();
		//Query viewQuery = em.createQuery(JPQL_PRODUCTS_SELECT);
		Query viewQuery = em.createNamedQuery("RecenziiView.findAll");
		this.recenziiViewList = viewQuery.getResultList();

		return this;
	}

	//
	protected JPADataSourceConnector dataSourceConnector;

	public RecenziiViewBuilder(JPADataSourceConnector dataSourceConnector) {
		super();
		this.dataSourceConnector = dataSourceConnector;
	}
	
}