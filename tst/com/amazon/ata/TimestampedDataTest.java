package com.amazon.ata;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TimestampedDataTest {
    private static final ZonedDateTime SAMPLE_TIMESTAMP = ZonedDateTime.parse("2019-07-31T08:00:19Z[UTC]");

    @Test
    void dataAndTimestampConstructor_withNonNullValues_constructsInstance() {
        String data = "My message";
        ZonedDateTime timestamp = SAMPLE_TIMESTAMP;

        TimestampedData<String> timestampedData = new TimestampedData<>(data, timestamp);

        assertEquals(data, timestampedData.getData(), "Expected data to match");
        assertEquals(timestamp, timestampedData.getTimestamp(), "Expected timestamp to match");
    }

    @Test
    void dataAndTimestampConstructor_withNullData_constructsInstance() {
        Double data = null;
        ZonedDateTime timestamp = SAMPLE_TIMESTAMP;

        TimestampedData<Double> timestampedData = new TimestampedData<>(data, timestamp);

        assertNull(timestampedData.getData(), "Expected data to be null");
        assertEquals(timestamp, timestampedData.getTimestamp(), "Expected timestamp to match");
    }

    @Test
    void dataAndTimestampConstructor_withNullTimestamp_throwsException() {
        ZonedDateTime data = ZonedDateTime.now();
        ZonedDateTime timestamp = null;

        assertThrows(IllegalArgumentException.class,
                () -> new TimestampedData<>(data, timestamp),
                "Expected IllegalArgumentException when passing in null timestamp");
    }

    @Test
    void dataConstructor_withData_defaultsTimestampToNow() {
        List<String> data = new ArrayList<>();
        data.add("Hello");
        data.add("there!");

        TimestampedData<List<String>> timestampedData = new TimestampedData<>(data);

        assertEquals(data, timestampedData.getData(), "Expected data to match");

        Duration durationBetweenTimestampAndNow = Duration.between(timestampedData.getTimestamp(), ZonedDateTime.now());
        assertTrue(durationBetweenTimestampAndNow.toMillis() < 5_000);
    }

    @Test
    void dataConstructor_withNullData_constructsInstance() {
        Integer data = null;

        TimestampedData<Integer> timestampedData = new TimestampedData<>(data);

        assertNull(timestampedData.getData(), "Expected data to be null");

        Duration durationBetweenTimestampAndNow = Duration.between(timestampedData.getTimestamp(), ZonedDateTime.now());
        assertTrue(durationBetweenTimestampAndNow.toMillis() < 5_000);
    }
}