package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static String[] formatDateTime(String input) {
        // Определяем формат входной строки
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        // Определяем форматы для времени и даты
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Парсим входную строку в LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(input, inputFormatter);

        // Форматируем LocalDateTime в две строки: время и дата
        String time = dateTime.format(timeFormatter);
        String date = dateTime.format(dateFormatter);

        return new String[]{time, date};
    }
}
