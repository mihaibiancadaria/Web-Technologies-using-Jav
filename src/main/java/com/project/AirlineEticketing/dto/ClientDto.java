package com.project.AirlineEticketing.dto;
import com.project.AirlineEticketing.validators.OnlyLetters;
import com.project.AirlineEticketing.validators.OnlyNumbers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class ClientDto {

    @NotNull(message = "This field is required.")
    private String Username;

    @NotNull(message = "This field is required.")
    private String Password;

    @OnlyLetters
    @NotNull(message = "This field is required.")
    private String FullName;

    @NotNull(message = "This field is required.")
    @Size(min = 13, max = 13, message = "The size should be 13.")
    @OnlyNumbers
    private String CNP;

    @NotNull(message = "This field is required.")
    private String Mail;

    @NotNull(message = "This field is required.")
    private String Gender;


    public ClientDto(){

    }

    public ClientDto(String Username, String Password, String FullName, String CNP, String Mail, String Gender){
        this.Username=Username;
        this.Password=Password;
        this.FullName=FullName;
        this.CNP=CNP;
        this.Mail=Mail;
        this.Gender=Gender;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;

    }
    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

}
