package com.example.demo.Model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Data
@Entity
@EqualsAndHashCode(of = {"id"})
@Table(name = "USER_DETAIL")
public class UserDetail implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="user_name")
    public String userName ;
    @Column(name="surname")
    public String surName;
    @Column(name="phone_number")
    public String phoneNumber;
    @Column(name="date_of_birth")
    public LocalDateTime dob;
    @Column(name="date_of_joining")
    public LocalDateTime doj;
    @Column(name="pin")
    public String pin;
    @Column(name="status")
    public boolean status;

}
