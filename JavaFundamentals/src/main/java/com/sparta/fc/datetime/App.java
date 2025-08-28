package com.sparta.fc.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class App {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.getDayOfWeek());
        LocalDate nextWeek = now.plusWeeks(1);
        System.out.println(nextWeek);
        System.out.println(now.getMonth());
        System.out.println(365-now.getDayOfYear() + " days of the year left");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var myDate = LocalDate.parse("13-11-2002", formatter); // takes string format of date, plus formatter
        DateTimeFormatter americanFormatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        System.out.println(myDate.format(americanFormatter));

        LocalDate nishBday = LocalDate.of(1989, 11, 2);
        Period age = Period.between(nishBday, now);
        int yearAge = age.getYears();
        System.out.println("Nish is " + yearAge + " years of age");

        // method 1
        LocalDate nishBday2025 = LocalDate.of(2025, 11, 2);
        long daysUntilBday = ChronoUnit.DAYS.between(now, nishBday2025); // using the ChronoUnit Enum
        long monthsUntilBday = ChronoUnit.MONTHS.between(now, nishBday2025);
        System.out.println(daysUntilBday + " days until Nish's birthday");
        System.out.println(monthsUntilBday + " months until Nish's birthday");

        LocalDate nextBday = LocalDate.of(LocalDate.now().getYear(), nishBday.getMonth(), nishBday.getDayOfMonth());
        long daysUntilBday2 = ChronoUnit.DAYS.between(now, nextBday);
        System.out.println(daysUntilBday2);

        Period untilBday = Period.between(now, nishBday2025);
        System.out.println(untilBday.getMonths() + " month(s) and " + untilBday.getDays() + " days until Nish's birthday");

    }
}
