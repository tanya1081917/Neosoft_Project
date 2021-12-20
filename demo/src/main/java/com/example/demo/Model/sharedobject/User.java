package com.example.demo.Model.sharedobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.time.LocalDateTime;

@Data
public class User {


    public Long id;
    @Size(min = 1, max = 50, message = "user name cannot be more than 50 characters.")
    public String userName ;
    @Size(min = 1, max = 50, message = "sur name cannot be more than 50 characters.")
    public String surName;
    public String email;
    @Size(min = 1, max = 10, message = "phone number cannot be more than 50 characters.")
    public String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime dob;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime doj;
    @Size(max = 6, message = "phone number cannot be more than 6 characters.")
    public String pin;

}
