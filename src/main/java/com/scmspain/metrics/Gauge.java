package com.scmspain.metrics;

public interface Gauge {
    void count(String aspect, long delta);
    void count(String aspect, long delta, double sampleRate);
    void incrementCounter(String aspect);
    void increment(String aspect);
    void decrementCounter(String aspect);
    void decrement(String aspect);
    void recordGaugeValue(String aspect, long value);
    void recordGaugeValue(String aspect, double value);
    void recordGaugeDelta(String aspect, long delta);
    void recordGaugeDelta(String aspect, double delta);
    void gauge(String aspect, long value);
    void gauge(String aspect, double value);
}
