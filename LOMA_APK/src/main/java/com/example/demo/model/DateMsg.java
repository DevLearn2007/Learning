package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public record DateMsg(@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") LocalDateTime dateTime) {

}
