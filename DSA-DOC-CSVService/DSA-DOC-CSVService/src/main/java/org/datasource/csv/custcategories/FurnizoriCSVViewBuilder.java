package org.datasource.csv.custcategories;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.datasource.csv.CSVResourceFileDataSourceConnector;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;

import org.apache.commons.csv.CSVRecord;

import org.datasource.csv.CSVResourceFileDataSourceConnector;

import org.springframework.stereotype.Service;

import java.io.File;

import java.io.FileReader;

import java.io.Reader;

import java.util.ArrayList;

import java.util.List;

@Service

public class FurnizoriCSVViewBuilder {

    private List<FurnizoriView> viewList = new ArrayList<>();

    private CSVResourceFileDataSourceConnector dataSourceConnector;

    private File csvFile;

    // Constructor

    public FurnizoriCSVViewBuilder(CSVResourceFileDataSourceConnector dataSourceConnector) throws Exception {

        this.dataSourceConnector = dataSourceConnector;

        this.csvFile = dataSourceConnector.getCSVFile();

    }

    public List<FurnizoriView> getViewList() {

        return viewList;

    }

    // Builder Workflow

    public FurnizoriCSVViewBuilder build() throws Exception {

        Reader in = new FileReader(this.csvFile);

        CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader().withDelimiter(',');

        Iterable<CSVRecord> records = format.parse(in);

        viewList = new ArrayList<>();

        for (CSVRecord record : records) {

            this.viewList.add(new FurnizoriView(

                    Integer.parseInt(record.get("id")),

                    record.get("nume"),

                    record.get("email"),

                    record.get("telefon")

            ));

        }

        in.close();

        return this;

    }

}


