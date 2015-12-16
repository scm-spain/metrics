package com.scmspain.metrics;

public interface Sets {
    void recordSetEvent(String aspect, String eventName);
    void set(String aspect, String eventName);
}
