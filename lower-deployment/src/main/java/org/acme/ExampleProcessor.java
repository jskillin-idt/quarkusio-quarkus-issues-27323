package org.acme;

import static io.quarkus.deployment.annotations.ExecutionTime.STATIC_INIT;

import io.quarkus.arc.deployment.SyntheticBeanBuildItem;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.Record;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import org.acme.builditem.ExampleBuildItem;
import org.acme.config.ExampleConfig;

class ExampleProcessor {

  @BuildStep
  void collectExampleBuildItems(
      final BuildProducer<ExampleBuildItem> examples) {
    examples.produce(new ExampleBuildItem(new ExampleConfig()));
  }

  @BuildStep
  @Record(STATIC_INIT)
  void produceExampleConfigBean(
      final List<ExampleBuildItem> exampleBuildItems,
      final ExampleRouteBuilderRecorder recorder,
      final BuildProducer<SyntheticBeanBuildItem> syntheticBeans) {

    if (!exampleBuildItems.isEmpty()) {

      final List<ExampleConfig> configs =
          exampleBuildItems.stream()
              .map(ExampleBuildItem::getConfig)
              .collect(Collectors.toUnmodifiableList());

      syntheticBeans.produce(SyntheticBeanBuildItem
          .configure(ExampleRouteBuilder.class)
          .unremovable()
          .scope(ApplicationScoped.class)
          .supplier(recorder.getExampleRouteBuilderSupplier(configs))
          .done());
    }
  }
}
