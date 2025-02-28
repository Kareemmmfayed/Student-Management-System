package com.learning.Student_Management_System.util;

import jakarta.persistence.AttributeConverter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HourMinuteAttributeConverter implements AttributeConverter<LocalTime, String> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String convertToDatabaseColumn(LocalTime localTime) {
        return localTime.format(formatter);
    }

    @Override
    public LocalTime convertToEntityAttribute(String s) {
        return LocalTime.parse(s, formatter);
    }
}
