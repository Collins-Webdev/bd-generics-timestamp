package com.amazon.ata;

import java.time.ZonedDateTime;

public class DataLogger {
    public static void main(String[] args) {
        int[] datas = {1, 1, 2, 3, 5, 8, 13, 21};
        ZonedDateTime[] timestamps = {
                ZonedDateTime.parse("2019-08-03T12:31:09Z[UTC]"),
                ZonedDateTime.parse("2019-08-04T12:31:08Z[UTC]"),
                ZonedDateTime.parse("2019-08-05T12:31:00Z[UTC]"),
                ZonedDateTime.parse("2019-08-06T12:31:06Z[UTC]"),
                ZonedDateTime.parse("2019-08-08T12:31:05Z[UTC]"),
                ZonedDateTime.parse("2019-08-10T12:31:01Z[UTC]"),
                ZonedDateTime.parse("2019-08-13T12:31:11Z[UTC]"),
                ZonedDateTime.parse("2019-08-19T12:31:09Z[UTC]"),
        };

        DataLogger dataLogger = new DataLogger();
        dataLogger.logData(datas, timestamps);
    }

    public void logData(int[] dataValues, ZonedDateTime[] timestampValues) {
        if (null == dataValues) {
            throw new IllegalArgumentException("data array cannot be null");
        }

        if (null == timestampValues) {
            throw new IllegalArgumentException("timestamp array cannot be null");
        }

        if (dataValues.length != timestampValues.length) {
            throw new IllegalArgumentException("data and timestamp arrays must have the same length");
        }

        for (int i = 0; i < dataValues.length; i++) {
            TimestampedData<Integer> timestampedData = new TimestampedData<>(dataValues[i], timestampValues[i]);
            System.out.println(timestampedData);
        }
    }
}