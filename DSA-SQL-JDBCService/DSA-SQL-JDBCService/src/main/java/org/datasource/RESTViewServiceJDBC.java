package org.datasource;

import org.datasource.jdbc.JDBCDataSourceConnector;
import org.datasource.jdbc.views.customerdetails.PlatiView;
import org.datasource.jdbc.views.customerdetails.PlatiViewBuilder;
import org.datasource.jdbc.views.customers.ClientiView;
import org.datasource.jdbc.views.customers.ClientiViewBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/*	REST Service URL
 	http://localhost:8090/DSA-SQL-JDBCService/rest/customers/ClientiView
 	http://localhost:8090/DSA-SQL-JDBCService/rest/customers/PlatiView
*/
@RestController
@RequestMapping("/customers")
public class RESTViewServiceJDBC {
	private static Logger logger = Logger.getLogger(RESTViewServiceJDBC.class.getName());
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET,
			produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public String ping() {
		logger.info(">>>> DSA-SQL-JDBCService:: RESTViewService is Up!");
		return "Ping response from DSA-SQL-JDBCService!";
	}
	
	@RequestMapping(value = "/ClientiView", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<ClientiView> get_ClientiView() {
		List<ClientiView> viewList = customersViewBuilder.build().getViewList();
		return viewList;
	}

	@RequestMapping(value = "/PlatiView", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<PlatiView> get_PlatiView() {
		List<PlatiView> viewList = customersDetailsViewBuilder.build().getViewList();
		return viewList;
	}
	// Set-up
	@Autowired private JDBCDataSourceConnector jdbcConnector;
	//
	@Autowired private ClientiViewBuilder customersViewBuilder;
	@Autowired private PlatiViewBuilder customersDetailsViewBuilder;
	//
}