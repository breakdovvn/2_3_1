package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя не может быть пустым")
    @Pattern(regexp = "^[А-Яа-яA-Za-z]+$", message = "Имя должно содержать только буквы")
    @Column(name = "name")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустой")
    @Pattern(regexp = "^[А-Яа-яA-Za-z]+$", message = "Фамилия должна содержать только буквы")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Неверный формат email")
    @NotBlank(message = "Email не может быть пустым")
    @Column(name = "email")
    private String email;

    @Min(value = 1, message = "Возраст должен быть больше 0")
    @Max(value = 130, message = "Возраст нереалистичный")
    @Column(name = "age")
    private int age;

    public User() {}

    public User(Long id, String firstName, String lastName, String email, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id != null && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}
