package org.datasource;

import org.datasource.csv.custcategories.FurnizoriView;
import org.datasource.csv.custcategories.FurnizoriCSVViewBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


import org.datasource.csv.custcategories.FurnizoriView;
import org.datasource.csv.custcategories.FurnizoriCSVViewBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/*	REST Service URL
	http://localhost:8097/DSA-DOC-CSVService/rest/customers/FurnizoriView
*/

@RestController
@RequestMapping("/customers")
public class RESTViewServiceCSV {
	private static Logger logger = Logger.getLogger(RESTViewServiceCSV.class.getName());

	@Autowired
	private FurnizoriCSVViewBuilder furnizoriCSVViewBuilder;

	@RequestMapping(value = "/FurnizoriView", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public List<FurnizoriView> getFurnizoriCSV() throws Exception {
		List<FurnizoriView> viewList;
		if (this.furnizoriCSVViewBuilder.getViewList().isEmpty()) {
			viewList = this.furnizoriCSVViewBuilder.build().getViewList();
		} else {
			viewList = this.furnizoriCSVViewBuilder.getViewList();
		}
		return viewList;
	}
}