package register;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationTest {
    final String REG_ALPH = "[а-яёА-ЯЁ]+";
    final String REG_ENG = "[a-zA-Z]";
    final String REG_PAS = "[a-zA-Z0-9]";
    final String SQL_CREATE_TABLE = "CREATE TABLE registrationPersonInDB " + "name VARCHAR(100), " + "surName VARCHAR(100), "
            + "email VARCHAR(100), " + "login VARCHAR(100), " + "password VARCHAR(100)";


    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        RegistrationTest registrationTest = new RegistrationTest();
        registrationTest.registerPerson();


    }

    public class RegistrationPerson {
        private String personName;
        private String personSurname;
        private String personEmail;
        private String personLogin;
        private String personPassword;

        public RegistrationPerson(String personName, String personSurname, String personEmail, String personLogin, String personPassword) {
            this.personName = personName;
            this.personSurname = personSurname;
            this.personEmail = personEmail;
            this.personLogin = personLogin;
            this.personPassword = personPassword;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getPersonSurname() {
            return personSurname;
        }

        public void setPersonSurname(String personSurname) {
            this.personSurname = personSurname;
        }

        public String getPersonEmail() {
            return personEmail;
        }

        public void setPersonEmail(String personEmail) {
            this.personEmail = personEmail;
        }

        public String getPersonLogin() {
            return personLogin;
        }

        public void setPersonLogin(String personLogin) {
            this.personLogin = personLogin;
        }

        public String getPersonPassword() {
            return personPassword;
        }

        public void setPersonPassword(String personPassword) {
            this.personPassword = personPassword;
        }

        @Override
        public String toString() {
            return "PersonInfo{" +
                    "name=" + personName +
                    ", surName='" + personSurname + '\'' +
                    ", e-mail='" + personEmail + '\'' +
                    ", login='" + personLogin + '\'' +
                    ", password=" + personPassword +
                    '}';
        }

    }

    private void registerPerson() {
        ArrayList<String> listPerson = new ArrayList<>();
        int flag = 0;
        Pattern pattern = Pattern.compile(REG_ALPH);
        System.out.println("Введите Ваше имя:");
        Scanner scanner = new Scanner(System.in);


        String registerName = scanner.nextLine();
        Matcher m = pattern.matcher(registerName);


        if (m.find()) {

            if (registerName.substring(0, 1).matches("[А-ЯЁ]")) {
                System.out.println("Введите Вашу фамилию:");
                String registerSurName = scanner.nextLine();
                m = pattern.matcher(registerSurName);

                if (m.find()) {

                    if (registerSurName.substring(0, 1).matches("[А-ЯЁ]")) {
                        System.out.println("Введите адрес электронной почты:");
                        pattern = Pattern.compile(REG_ENG);
                        String registerEmail = scanner.nextLine();
                        m = pattern.matcher(registerEmail);

                        if (m.find()) {

                            System.out.println("Введите имя учетной записи:");
                            String registerLogin = scanner.nextLine();
                            m = pattern.matcher(registerLogin);

                            if (m.find()) {
                                System.out.println("Введите пароль:");
                                pattern = Pattern.compile(REG_PAS);
                                String registerPassword = scanner.nextLine();
                                m = pattern.matcher(registerPassword);

                                if (m.find()) {

                                    flag = 1;
                                    listPerson.add(registerName);
                                    listPerson.add(registerSurName);
                                    listPerson.add(registerEmail);
                                    listPerson.add(registerLogin);
                                    listPerson.add(registerPassword);

                                    RegistrationPerson registrationPerson = new RegistrationPerson(listPerson.get
                                            (RegisterFields.NAME.ordinal()),
                                            listPerson.get(RegisterFields.SURNAME.ordinal()), listPerson.get
                                            (RegisterFields.EMAIL.ordinal()),
                                            listPerson.get(RegisterFields.LOGIN.ordinal()), listPerson.get
                                            (RegisterFields.PASSWORD.ordinal()));


                                } else {
                                    System.out.println("Пароль не соответствует требованиям безопасности");
                                }

                            } else {
                                System.out.println("Имя учетной записи некорректно");
                            }

                        } else {
                            System.out.println("Электронный адрес введен некорректно");
                        }
                    } else {
                        System.out.println("Фамилия должна начинаться с заглавной буквы");
                    }
                } else {
                    System.out.println("Фамилия введена некорректно");
                }
            } else {
                System.out.println("Имя должно начинаться с заглавной буквы");
            }
        } else {
            System.out.println("Имя введено некорректно");
        }


        if (flag == 1) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                try {
                    Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;database=education_r09",
                            "sa", "Q1w2e3r4t%");
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT TOP 10 * FROM WM_PERSONAL_CARD");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    System.out.println(resultSet);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

//        RegistrationPerson registrationPerson = new RegistrationPerson(listPerson.get(RegisterFields.NAME.ordinal()),
//                listPerson.get(RegisterFields.SURNAME.ordinal()), listPerson.get(RegisterFields.EMAIL.ordinal()),
//                listPerson.get(RegisterFields.LOGIN.ordinal()), listPerson.get(RegisterFields.PASSWORD.ordinal()));

        //System.out.println(registrationPerson.toString());

    }
}
