package com.scmspain.metrics;

public class FakeMetrics implements Metrics {
    @Override
    public void recordExecutionTime(String aspect, long timeInMs) {

    }

    @Override
    public void recordExecutionTime(String aspect, long timeInMs, double sampleRate) {

    }

    @Override
    public void recordExecutionTimeToNow(String aspect, long systemTimeMillisAtStart) {

    }

    @Override
    public void time(String aspect, long value) {

    }

    @Override
    public void count(String aspect, long delta) {

    }

    @Override
    public void count(String aspect, long delta, double sampleRate) {

    }

    @Override
    public void incrementCounter(String aspect) {

    }

    @Override
    public void increment(String aspect) {

    }

    @Override
    public void decrementCounter(String aspect) {

    }

    @Override
    public void decrement(String aspect) {

    }

    @Override
    public void recordGaugeValue(String aspect, long value) {

    }

    @Override
    public void recordGaugeValue(String aspect, double value) {

    }

    @Override
    public void recordGaugeDelta(String aspect, long delta) {

    }

    @Override
    public void recordGaugeDelta(String aspect, double delta) {

    }

    @Override
    public void gauge(String aspect, long value) {

    }

    @Override
    public void gauge(String aspect, double value) {

    }

    @Override
    public void recordSetEvent(String aspect, String eventName) {

    }

    @Override
    public void set(String aspect, String eventName) {

    }
}
