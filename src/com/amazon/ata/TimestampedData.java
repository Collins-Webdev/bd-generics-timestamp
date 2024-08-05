package com.amazon.ata;

import java.time.ZonedDateTime;

public class TimestampedData<T> {
    private T data;
    private ZonedDateTime timestamp;

    public TimestampedData(T data, ZonedDateTime timestamp) {
        if (null == timestamp) {
            throw new IllegalArgumentException("timestamp cannot be null");
        }

        this.data = data;
        this.timestamp = timestamp;
    }

    public TimestampedData(T data) {
        this(data, ZonedDateTime.now());
    }

    // Nouveau getter pour data
    public T getData() {
        return data;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("{data: %s | timestamp: %s}", data, timestamp);
    }
}