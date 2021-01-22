package com.project.AirlineEticketing.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Builder
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
@Table(name = "clients")

public class Client {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer ClientId;
//
//    @Column(name = "Username")
//    private String Username;
//
//    @Column(name = "Password")
//    private String Password;
//
//    @Column(name = "FullName")
//    private String FullName;
//
//    @Column(name = "CNP")
//    private String CNP;
//
//    @Column(name = "Mail")
//    private String Mail;
//
//    @Column(name = "Gender")
//    private String Gender;


    private Long ClientID;
    private String Username;
    private String Password;
    private String FullName;
    private String CNP;
    private String Mail;
    private String Gender;


    public Client(){

    }


    public Client(Long ClientID, String Username, String Password, String FullName, String CNP, String Mail, String Gender){
        this.ClientID=ClientID;
        this.Username=Username;
        this.Password=Password;
        this.FullName=FullName;
        this.CNP=CNP;
        this.Mail=Mail;
        this.Gender=Gender;
    }

    public Client(String Username, String Password, String FullName, String CNP, String Mail, String Gender){
        this.Username=Username;
        this.Password=Password;
        this.FullName=FullName;
        this.CNP=CNP;
        this.Mail=Mail;
        this.Gender=Gender;
    }

    public Long getClientID() {
        return ClientID;
    }

    public void setClientID(Long ClientID) {
        this.ClientID = ClientID;
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
