package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

public class User {


    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("last_name")
    private String last_name;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("dob")
    private String dob;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private String address;

    @JsonProperty("status")
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

    public static User randomUser() throws ParseException {
        User person = new User();
        Faker faker = new Faker(new Locale("ES"));
        LocalDate randomDate = createRandomDate(1960, 2000);
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
        person.setDob(randomDate.toString());
        person.setEmail(faker.internet().emailAddress());
        person.setPhone(faker.phoneNumber().phoneNumber());
        person.setAddress(faker.address().fullAddress());
        person.setStatus(locStatus);
        return person;
    }

    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
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
