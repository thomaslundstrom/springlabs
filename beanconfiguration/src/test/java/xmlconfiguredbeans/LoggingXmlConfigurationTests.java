package xmlconfiguredbeans;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoggingXmlConfigurationTests {

	private ConfigurableApplicationContext ctx;

	@Before
	public void setup() {
		ctx = new ClassPathXmlApplicationContext("/logging-application-context.xml");
	}
	
	@After
	public void teardown() {
		ctx.close();
	}
	
	@Test
	public void appContextShouldBeInititated() {
		assertNotNull(ctx);
	}

}
