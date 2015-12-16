package com.scmspain.metrics;

public interface Chronos {
    void recordExecutionTime(String aspect, long timeInMs);
    void recordExecutionTime(String aspect, long timeInMs, double sampleRate);
    void recordExecutionTimeToNow(String aspect, long systemTimeMillisAtStart);
    void time(String aspect, long value);
}
