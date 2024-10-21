package by.baraznov.proxyserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
public class Person {

    @Email
    private String email;
    @NotEmpty
    private String endpoint;
    @NotEmpty
    private String login;
    @NotEmpty
    private String message;
    private String supportLevel;
    @Min(value = 0)
    private long timestamp;
    @Id
    private long userId;

    @NotEmpty
    private String name;

    private String surname;
    @NotEmpty
    private String patronymic;
    @Min(value = 0)
    private int age;
    @NotEmpty
    private String birthdayTime;
    @NotEmpty
    @Pattern(regexp = "\\+[0-9]+")
    private String phoneNumber;
    @NotEmpty
    private String sex;



    public Person(){}

    public Person(String name, String surname, String email, String endpoint, String login, String message, String supportLevel, long timestamp, long userId, String patronymic, int age, String birthdayTime, String phoneNumber, String sex) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.endpoint = endpoint;
        this.login = login;
        this.message = message;
        this.supportLevel = supportLevel;
        this.timestamp = timestamp;
        this.userId = userId;
        this.patronymic = patronymic;
        this.age = age;
        this.birthdayTime = birthdayTime;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSupportLevel() {
        return supportLevel;
    }

    public void setSupportLevel(String supportLevel) {
        this.supportLevel = supportLevel;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthdayTime() {
        return birthdayTime;
    }

    public void setBirthdayTime(String birthdayTime) {
        this.birthdayTime = birthdayTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", login='" + login + '\'' +
                ", message='" + message + '\'' +
                ", supportLevel='" + supportLevel + '\'' +
                ", timestamp=" + timestamp +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", birthdayTime='" + birthdayTime + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
