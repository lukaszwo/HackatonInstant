package com.infullmobile.hackatoninstant.feature.data;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * Created by andrii.kovalchuk on 01/09/2017.
 */

public class CsvToJsonConverter {

    public String csvToJson(String json) throws IOException {
        List<Map<?, ?>> data = readObjectsFromCsv(json);

        Writer writer = new StringWriter();
        writeAsJson(data, writer);

        return writer.toString();
    }

    private static List<Map<?, ?>> readObjectsFromCsv(String stringCSV) throws IOException {
        CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(bootstrap).readValues(stringCSV);

        return mappingIterator.readAll();
    }

    private static void writeAsJson(List<Map<?, ?>> data, Writer writer) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, data);
    }
}
