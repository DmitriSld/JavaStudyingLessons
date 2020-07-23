package register;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationTest {


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
        String regALph = "[а-яёА-ЯЁ]+";
        Pattern pattern = Pattern.compile(regALph);
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
                        listPerson.add(registerName);
                        listPerson.add(registerSurName);
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


        for (String s : listPerson) {
            System.out.println(s);
        }

    }
}
