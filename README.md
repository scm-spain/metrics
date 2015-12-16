# Metrics
This library tries to abstract the features of StatsD, so we have a common interface even though we want to change the library underneath (StatsD at this point).

# Usage
Just bind the common interface to the implementation that you want to use

```
bind(Metrics.class).to(NonBlockingStatsDClient.class).asEagerSingleton();
```

This module provides [a test double for the Metrics interface](src/main/java/com/scmspain/metrics/FakeMetrics.java), so that if you want to test classes that depend on this component, you don't need to create your own stub.