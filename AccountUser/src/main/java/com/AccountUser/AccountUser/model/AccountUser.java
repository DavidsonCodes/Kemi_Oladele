package com.AccountUser.AccountUser.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class AccountUser {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private final int id;

    public AccountUser(int id) {
        this.id = id;
    }
    @NotBlank
    @NotNull
    @Length(min = 8, max = 30)
    private String firstName;

    @NotBlank
    @NotNull
    @Length(min = 8, max = 30)
    private String lastName;

    @NotBlank
    @NotNull
    @Length(min = 8, max = 30)
    private String middleName;

    @NotBlank
    @NotNull
    @Email
    @Length(min = 8, max = 30)
    private String username;

    @NotBlank
    @NotNull
    @Length(min = 8, max = 30)
    private String password;

    @NotBlank
    @NotNull
    @Length(min = 8, max = 30)
    private int phoneNumber;

    public AccountUser(int id, String firstName, String lastName, String middleName, String username, String password, int phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}

