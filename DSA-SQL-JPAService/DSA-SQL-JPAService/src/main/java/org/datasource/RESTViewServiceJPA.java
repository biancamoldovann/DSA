package org.datasource;

import org.datasource.jpa.JPADataSourceConnector;
import org.datasource.jpa.views.produse.ProduseView;
import org.datasource.jpa.views.produse.ProduseViewBuilder;
import org.datasource.jpa.views.recenzii.RecenziiView;
import org.datasource.jpa.views.recenzii.RecenziiViewBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/*	REST Service URL
	http://localhost:8091/DSA_SQL_JPAService/rest/sales/RecenziiView
	http://localhost:8091/DSA_SQL_JPAService/rest/sales/ProduseView

*/
@RestController
@RequestMapping("/sales")
public class RESTViewServiceJPA {
	private static Logger logger = Logger.getLogger(RESTViewServiceJPA.class.getName());
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET,
			produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public String pingDataSource() {
		logger.info(">>>> DSA-SQL-JPAService:: RESTViewService is Up!");
		return "Ping response from DSA-SQL-JPAService!";
	}
	
	@RequestMapping(value = "/RecenziiView", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<RecenziiView> get_RecenziiView() {
		List<RecenziiView> viewList = this.recenziiViewBuilder.build().getRecenziiViewList();
		return viewList;
	}

	@RequestMapping(value = "/ProduseView", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<ProduseView> get_ProduseView() {
		List<ProduseView> viewList = this.produseViewBuilder.build().getProduseViewList();
		return viewList;
	}
	
	// Set-up
	@Autowired private JPADataSourceConnector dataSourceConnector;
	@Autowired private RecenziiViewBuilder recenziiViewBuilder;
	@Autowired private ProduseViewBuilder produseViewBuilder;
	//

}