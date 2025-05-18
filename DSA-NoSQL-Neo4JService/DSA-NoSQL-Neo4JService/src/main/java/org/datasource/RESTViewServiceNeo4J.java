package org.datasource;

import org.datasource.neo4j.views.locations.ComandaView;
import org.datasource.neo4j.views.locations.ComandaViewBuilder;
import org.datasource.neo4j.views.locations.DetaliiComandaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


/*	REST Service URL
	http://localhost:8094/DSA-NoSQL-Neo4JService/rest/locations/ComandaView
	http://localhost:8094/DSA-NoSQL-Neo4JService/rest/locations/DetaliiComandaView
*/
@RestController @RequestMapping("/locations")
public class RESTViewServiceNeo4J {
	private static Logger logger = Logger.getLogger(RESTViewServiceNeo4J.class.getName());
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET,
		produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public String pingDataSource() {
		logger.info(">>>> org.datasource.rest.RESTViewService(JSON) is Up!");
		return "Ping response from RESTViewServiceMongoDB!";
	}
	
	@RequestMapping(value = "/DetaliiComandaView", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<DetaliiComandaView> get_detaliiComandaView() throws Exception {
		List<DetaliiComandaView> viewList = this.viewBuilder.build().getDetaliiComandaViewList();
		return viewList;
	}
	
	@RequestMapping(value = "/ComandaView", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<ComandaView> get_ComandaView() throws Exception {
		List<ComandaView> viewList = this.viewBuilder.build().getComandaViewList();
		return viewList;
	}

	// Set-up 
	@Autowired private ComandaViewBuilder viewBuilder;
}