package org.acme.builditem;

import io.quarkus.builder.item.MultiBuildItem;
import org.acme.config.ExampleConfig;

public final class ExampleBuildItem extends MultiBuildItem {
  private final ExampleConfig config;

  public ExampleBuildItem(ExampleConfig config) {
    this.config = config;
  }

  public ExampleConfig getConfig() {
    return config;
  }
}
