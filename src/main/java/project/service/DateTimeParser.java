package project.service;


import java.time.LocalDateTime;


public interface DateTimeParser {

    //this method returns LocalDateTime as java.util.Date to parse to JodaTime use timeToJodaTime()

    LocalDateTime parseDate (String dateToFormat);

    org.joda.time.LocalDateTime timeToJodaTime (LocalDateTime localDateTime);
}
