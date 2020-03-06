package data;

import com.github.javafaker.Faker;
import java.lang.reflect.Member;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class User {


    private String first_name;
    private String last_name;
    private String gender;
    private String dob;
    private String email;
    private String phone;
    private String address;
    private String status;

    public User() {}

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static User randomUser() {
        User person = new User();
        Faker faker = new Faker(new Locale("ES"));
        Date birth = faker.date().birthday();

        int ramdomN = faker.number().numberBetween(0, 1);
        String sexGender;
        String locStatus;
        if (ramdomN == 0) {
            sexGender = "male";
            locStatus = "inactive";
        } else {
            sexGender = "female";
            locStatus = "active";
        }

        person.setFirst_name(faker.name().firstName());
        person.setLast_name(faker.name().lastName());
        person.setGender(sexGender);
        person.setDob(birth.toString());
        person.setEmail(faker.internet().emailAddress());
        person.setPhone(faker.phoneNumber().toString());
        person.setAddress(faker.address().fullAddress());
        person.setStatus(locStatus);
        return person;
    }

    @Override
    public String toString() {
        return "User{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
