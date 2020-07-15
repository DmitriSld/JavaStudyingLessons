package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CsvPrinterList {

    public static void main(String[] args) {
        final String fileReaderName = "G:\\csv examples\\list.csv";
        final String fileWriterName = "G:\\csv examples\\writeResult.csv";
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileReaderName), "CP1251"))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        } catch (Exception eread) {
            System.out.println("Error reading file:" + eread.getCause());
        }
        //Collections.reverse(list);
        //try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileWriterName), "CP1251"))) {
        try (BufferedWriter writer = Files.newBufferedReader(Paths.get(fileWriterName))) {
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.EXCEL.withHeader(list.get(0).split(";")));
        } catch (Exception ewrite) {
            System.out.println("Error writing file:" + ewrite.getCause());
        }


        for (String so : list) {
            System.out.println(so);
        }
    }
}


