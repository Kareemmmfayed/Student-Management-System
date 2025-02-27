package com.learning.Student_Management_System.util;

import jakarta.persistence.AttributeConverter;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class YearMonthAttributeConverter implements AttributeConverter<YearMonth, String> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");

    @Override
    public String convertToDatabaseColumn(YearMonth yearMonth) {
        return yearMonth.format(formatter);
    }

    @Override
    public YearMonth convertToEntityAttribute(String s) {
        return YearMonth.parse(s, formatter);
    }
}
