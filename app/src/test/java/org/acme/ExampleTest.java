package org.acme;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.quarkus.arc.Arc;
import io.quarkus.arc.InstanceHandle;
import io.quarkus.test.junit.QuarkusTest;
import java.util.List;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ExampleTest {

	@Test
	public void test() throws Exception {
		List<InstanceHandle<ExampleRouteBuilder>> builderHandles =
				Arc.container().listAll(ExampleRouteBuilder.class);

		assertFalse(
				builderHandles.isEmpty(),
				"There should be at least one injected bean if the extensions are included correctly");
		for (InstanceHandle<ExampleRouteBuilder> builderHandle : builderHandles) {
			ExampleRouteBuilder exampleRouteBuilder = builderHandle.get();
			exampleRouteBuilder.configure();
		}
	}

}