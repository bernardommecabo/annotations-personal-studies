package org.bernardomecabo.JavaMethods;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeExamples {
    static void main() {
        int year = 2005;
        int month = 5;
        int day = 18;

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterWithTimeZone = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        LocalDate onlyDate = LocalDate.now(); //Only date
        LocalDateTime dateTime = LocalDateTime.now(); //Date + Time (Local)
        Instant instant = Instant.now(); // Date + Time + TimeZone (Especially GMT +3)

        LocalDate parsedDateFromText = LocalDate.parse("2005-05-18");
        LocalDateTime parsedDateTimeFromText = LocalDateTime.parse("2005-05-18T08:30:00");
        Instant parsedInstantFromText = Instant.parse("2005-05-18T08:30:00-03:00");

        LocalDate customTextParsedDate = LocalDate.parse("18/05/2005", dateFormatter);
        LocalDate myBirthday = LocalDate.of(year, month, day);

        LocalDate parsedLocalDateFromInstant = LocalDate.ofInstant(instant, ZoneId.systemDefault());

        System.out.println("===== Date Time Instantiation =====");
        System.out.println("LocalDate: " + onlyDate);
        System.out.println("LocalDateTime: " + dateTime);
        System.out.println("Instant: " + instant);
        System.out.println("Text ISO parsed to LocalDate: " + parsedDateFromText);
        System.out.println("Text ISO parsed to LocalDateTime: " + parsedDateTimeFromText);
        System.out.println("Text ISO parsed to Instant: " + parsedInstantFromText);
        System.out.println("Custom Text parsed to LocalDate: " + customTextParsedDate);
        System.out.println("LocalDate of my birthday: " + myBirthday + "\n");

        System.out.println("===== Date Time Formatting =====");
        System.out.println("LocalDate to Custom format: " + myBirthday.format(dateFormatter));
        System.out.println("Instant to Custom format: " + formatterWithTimeZone.format(instant));
        System.out.println("Instant to LocalDate: " + parsedLocalDateFromInstant);
        System.out.println("My birthday day is: " + myBirthday.getDayOfMonth() + "\n");

        System.out.println("===== Date Time Calculus =====");
        System.out.println("1 week before my birthday (LocalDate): " + myBirthday.minusWeeks(1));
        System.out.println("2 week after my birthday (LocalDate): " + myBirthday.plusWeeks(2));
        System.out.println("1 week before my birthday (Instant): " + instant.minus(7, ChronoUnit.DAYS));
        System.out.println("2 week after my birthday (Instant): " + instant.plus(14,  ChronoUnit.DAYS));
    }
}
