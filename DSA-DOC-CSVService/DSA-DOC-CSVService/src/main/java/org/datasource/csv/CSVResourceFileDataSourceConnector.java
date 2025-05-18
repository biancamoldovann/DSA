package org.datasource.csv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

import java.io.File;

@Component
public class CSVResourceFileDataSourceConnector {

	private File csvFile;

	public CSVResourceFileDataSourceConnector(@Value("${csv.data.source.file.path}") String filePath) {
		this.csvFile = new File(filePath);
	}

	public File getCSVFile() {
		return csvFile;
	}
}

