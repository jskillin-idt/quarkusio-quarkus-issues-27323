package org.acme;

import io.quarkus.runtime.annotations.Recorder;
import java.util.List;
import java.util.function.Supplier;
import org.acme.config.ExampleConfig;

@Recorder
public class ExampleRouteBuilderRecorder {
  public Supplier<ExampleRouteBuilder> getExampleRouteBuilderSupplier(
      final List<ExampleConfig> exampleConfigs) {
    return () -> new ExampleRouteBuilder(exampleConfigs);
  }
}
