package xmlconfiguredbeans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xmlconfiguredbeans.BeanOne;
import xmlconfiguredbeans.BeanThree;
import xmlconfiguredbeans.BeanTwo;

public class XmlConfigurationTests {
	
	private ApplicationContext appCtx;

	@Before
	public void setup() {
		appCtx = new ClassPathXmlApplicationContext("/application-context.xml");
	}

	@Test
	public void appContextShouldBeInititated() {
		assertNotNull(appCtx);
	}
	
	@Test
	public void canGetBeanOneWithDeps() {
		BeanOne beanOne = appCtx.getBean(BeanOne.class);
		
		assertNotNull(beanOne);
		assertNotNull(beanOne.getBeanTwo());
	}
	
	@Test
	public void canGetProperty() {
		BeanTwo two = getBeanTwo();
		assertEquals(3, two.getNumber());
	}

	
	@Test
	public void canGetPropertyWithP() {
		BeanTwo two = getBeanTwo();
		assertEquals("property", two.getProperty());
	}
	
	@Test
	public void canGetRefWithP() {
		BeanTwo two = getBeanTwo();
		BeanThree three = two.getBeanThree();
		
		assertNotNull(three);
	}
	
	@Test
	public void canGetSingletonBean() {
		SingletonBeanFour four = appCtx.getBean(SingletonBeanFour.class);
		assertNotNull(four);
	}
	
	@Test
	public void canGetFactoryCreatedBean() {
		FactoryCreatedBeanFive five = appCtx.getBean(FactoryCreatedBeanFive.class);
		assertNotNull(five);
	}
	
	private BeanTwo getBeanTwo() {
		BeanTwo two = appCtx.getBean(BeanTwo.class);
		return two;
	}
}
