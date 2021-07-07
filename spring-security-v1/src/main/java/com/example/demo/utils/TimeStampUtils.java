package com.example.demo.utils;

import java.sql.Timestamp;

public class TimeStampUtils {

    public static Timestamp getTimeStamp() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return timestamp;

    }

}
