package project.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class DateTimeParserImpl implements DateTimeParser {


    @Override
    public LocalDateTime parseDate(String dateToFormat) {
        LocalDateTime localDateTime = LocalDateTime.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse(dateToFormat));

        return localDateTime;
    }

    public org.joda.time.LocalDateTime timeToJodaTime (LocalDateTime localDateTime) {


        org.joda.time.LocalDateTime jodaDateTime = new org.joda.time.LocalDateTime(localDateTime.getYear(),
                                                                                   localDateTime.getMonthValue(),
                                                                                   localDateTime.getDayOfMonth(),
                                                                                   localDateTime.getHour(),
                                                                                   localDateTime.getMinute(),
                                                                                   localDateTime.getSecond());

        return jodaDateTime;
    }


}
