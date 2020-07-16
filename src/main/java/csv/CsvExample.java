package csv;

import csv.been.Person;
import csv.been.PersonField;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvExample {
    final CSVFormat csvFormat = CSVFormat.DEFAULT
            .withDelimiter(';')
            .withRecordSeparator("\r\n");
    final String INPUT_FILE = "src/main/resources/csv_test.csv";
    public final String OUT_FILE = "src/main/resources/csv_write.csv";


    public static void main(String[] args) {
        CsvExample csvExample = new CsvExample();
        List<Person> personList = csvExample.readCsvToListPerson();
        csvExample.writeToCsv(personList);
        csvExample.sortPersonList(personList);
        //System.out.println(personList);
    }


    //recordToSort.add(String.valueOf(sortPerson.getNumber()).compareTo(String.valueOf(sortPerson.getNumber())));
    private void sortPersonList(List<Person> sortList) {
        List<String> recordToSort = new ArrayList<>();
        for (Person sortPerson : sortList) {
            Iterator<Person> iter = sortList.iterator();
            while (iter.hasNext()) {
                if (sortPerson.getName().compareTo(iter.next().getName()) == 1) {
                    System.out.println("da");
                } else {
                    System.out.println("net");
                }
                //System.out.println(sortPerson);
            }
        }
    }


    private void writeToCsv(List<Person> people) {
        try (FileWriter fileWriter = new FileWriter(OUT_FILE);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
        ) {
            for (Person person : people) {
                List<String> record = new ArrayList<>();
                record.add(String.valueOf(person.getNumber()));
                record.add(person.getSurName());
                record.add(person.getName());
                record.add(person.getPatronymic());
                record.add(person.getBirthDate().toString());
                csvPrinter.printRecord(record);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    private List<Person> readCsvToListPerson() {
        List<Person> personList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try (BufferedReader reader
                     = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(reader, csvFormat)) {
            for (CSVRecord record : csvParser) {
                Person person = new Person(Integer.parseInt(record.get(PersonField.NUMBER.ordinal())),
                        record.get(PersonField.SURNAME.ordinal()),
                        record.get(PersonField.NAME.ordinal()),
                        record.get(PersonField.PATRONYMIC.ordinal()),
                        simpleDateFormat.parse(record.get(PersonField.BIRTHDATE.ordinal())));
                personList.add(person);
                //System.out.println(person.toString());
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return personList;
    }
}


