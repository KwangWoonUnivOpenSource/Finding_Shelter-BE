package com.example.demo.util;

import com.example.demo.pharmacy.dto.PharmacyDto;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CsvUtils {

    public static List<PharmacyDto> convertToPharmacyDtoList() {

        String file = "/Users/jang-won-yong/lecture/pharmacy.csv";
        List<List<String>> csvList = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(file))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                csvList.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return IntStream.range(1, csvList.size()).mapToObj(index -> {
            List<String> rowList = csvList.get(index);

            return PharmacyDto.builder()
                    .pharmacyName(rowList.get(0))
                    .pharmacyAddress(rowList.get(1))
                    .latitude(Double.parseDouble(rowList.get(4)))
                    .longitude(Double.parseDouble(rowList.get(5)))
                    .build();
        }).collect(Collectors.toList());
    }
}
