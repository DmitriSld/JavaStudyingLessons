package csv.been;

import java.util.Date;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private int number;
    private String name;
    private String surName;
    private String patronymic;
    private Date birthDate;

    public Person(int number, String surName, String name, String patronymic, Date birthDate) {
        this.number = number;
        this.surName = surName;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person preson = (Person) o;
        return number == preson.number &&
                Objects.equals(name, preson.name) &&
                Objects.equals(surName, preson.surName) &&
                Objects.equals(patronymic, preson.patronymic) &&
                Objects.equals(birthDate, preson.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, surName, birthDate, patronymic);
    }

    @Override
    public String toString() {
        return "Preson{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", lastLogin=" + birthDate +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return (this.number - o.number);
    }
}
