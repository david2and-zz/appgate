package com.appgate.util;

import com.appgate.repository.model.AppgateEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class Utilities {

    private final String COMMA_DELIMITER = ",";

    public List getFileData() throws IOException {
        List<AppgateEntity> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ipgeo.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                records.add(new AppgateEntity(
                        row[0].replace("\"", ""),
                        row[1].replace("\"", ""),
                        row[2].replace("\"", ""),
                        row[3].replace("\"", ""),
                        row[4].replace("\"", ""),
                        row[5].replace("\"", ""),
                        row[6].replace("\"", ""),
                        row[7].replace("\"", ""),
                        row[8].replace("\"", "")
                ));


            }
        }

        return records;
    }
}
