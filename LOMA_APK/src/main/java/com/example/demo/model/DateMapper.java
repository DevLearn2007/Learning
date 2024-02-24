package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


public record DateMapper( @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate, @DateTimeFormat(pattern = "dd-MM-yyyy")LocalDate  endDate) {

}
