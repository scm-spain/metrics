package com.scmspain.metrics;

import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import com.timgroup.statsd.NoOpStatsDClient;
import com.timgroup.statsd.StatsDClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NonBlockingStatsDClient implements Metrics {
    private static final Logger LOGGER = LoggerFactory.getLogger(NonBlockingStatsDClient.class);
    private static final String PREFIX_KEY = "statsd.prefix";
    private static final String HOST_KEY = "statsd.host";
    private static final String PORT_KEY = "statsd.port";

    private final String defaultPrefix = "";
    private final String defaultHost = "statsd";
    private final Integer defaultPort = 8125;

    private DynamicPropertyFactory properties = DynamicPropertyFactory.getInstance();
    private DynamicStringProperty prefix = properties.getStringProperty(PREFIX_KEY, defaultPrefix);
    private DynamicStringProperty host = properties.getStringProperty(HOST_KEY, defaultHost);
    private DynamicIntProperty port = properties.getIntProperty(PORT_KEY, defaultPort);

    private StatsDClient client;

    public NonBlockingStatsDClient() {
        try {
            connectToBackend();
        } catch (Exception error) {
            fallbackToFakeClient(error);
        }
    }

    private void connectToBackend() {
        this.client = new com.timgroup.statsd.NonBlockingStatsDClient(
                prefix.get(),
                host.get(),
                port.get()
        );
    }

    private void fallbackToFakeClient(Exception error) {
        LOGGER.error(
                "Can't connect to StatsD Backend \"{}:{}\" with message \"{}\"",
                host.get(),
                port.get(),
                error.getMessage()
        );

        this.client = new NoOpStatsDClient();
    }

    @Override
    public void recordExecutionTime(String aspect, long timeInMs) {
        client.recordExecutionTime(aspect, timeInMs);
    }

    @Override
    public void recordExecutionTime(String aspect, long timeInMs, double sampleRate) {
        client.recordExecutionTime(aspect, timeInMs, sampleRate);
    }

    @Override
    public void recordExecutionTimeToNow(String aspect, long systemTimeMillisAtStart) {
        client.recordExecutionTime(aspect, systemTimeMillisAtStart);
    }

    @Override
    public void time(String aspect, long value) {
        client.time(aspect, value);
    }

    @Override
    public void count(String aspect, long delta) {
        client.count(aspect, delta);
    }

    @Override
    public void count(String aspect, long delta, double sampleRate) {
        client.count(aspect, delta, sampleRate);
    }

    @Override
    public void incrementCounter(String aspect) {
        client.incrementCounter(aspect);
    }

    @Override
    public void increment(String aspect) {
        client.increment(aspect);
    }

    @Override
    public void decrementCounter(String aspect) {
        client.decrementCounter(aspect);
    }

    @Override
    public void decrement(String aspect) {
        client.decrement(aspect);
    }

    @Override
    public void recordGaugeValue(String aspect, long value) {
        client.recordGaugeValue(aspect, value);
    }

    @Override
    public void recordGaugeValue(String aspect, double value) {
        client.recordGaugeValue(aspect, value);
    }

    @Override
    public void recordGaugeDelta(String aspect, long delta) {
        client.recordGaugeDelta(aspect, delta);
    }

    @Override
    public void recordGaugeDelta(String aspect, double delta) {
        client.recordGaugeDelta(aspect, delta);
    }

    @Override
    public void gauge(String aspect, long value) {
        client.gauge(aspect, value);
    }

    @Override
    public void gauge(String aspect, double value) {
        client.gauge(aspect, value);
    }

    @Override
    public void recordSetEvent(String aspect, String eventName) {
        client.recordSetEvent(aspect, eventName);
    }

    @Override
    public void set(String aspect, String eventName) {
        client.set(aspect, eventName);
    }
}
