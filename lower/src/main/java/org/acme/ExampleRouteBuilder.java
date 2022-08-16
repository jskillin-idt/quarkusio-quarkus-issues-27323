package org.acme;

import java.util.Collections;
import java.util.List;
import org.acme.config.ExampleConfig;

public class ExampleRouteBuilder {
  private final List<ExampleConfig> exampleConfigs;

  public ExampleRouteBuilder(List<ExampleConfig> exampleConfigs) {
    this.exampleConfigs = exampleConfigs;
  }

  public void configure() {
    if (this.exampleConfigs.isEmpty()) {
      throw new RuntimeException("The extension ran without configurations!");
    }
  }
}
